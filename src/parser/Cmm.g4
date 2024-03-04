grammar Cmm;

@header {
    import ast.*;
    import ast.expression.*;
    import ast.program.*;
    import ast.statement.*;
    import ast.type.*;
}

// --- PARSER ---

program returns [Program ast]: d=definitions { $ast = new Program(0,0,$d.ast); }
    ;

definitions returns [List<Definition> ast = new ArrayList<>()]:
    (def_var=varDef { $ast.addAll($def_var.ast); }
    | def_func=funcDef { $ast.add($def_func.ast); })*
    def_main=main_func_def { $ast.add($def_main.ast); }
    ;

expression returns [Expression ast]:
          ID
            { $ast = new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text); }
        | RC = REAL_CONSTANT
            {$ast = new RealLiteral($RC.getLine(), $RC.getCharPositionInLine()+1, LexerHelper.lexemeToReal($RC.text));}
        | CC = CHAR_CONSTANT
            {$ast = new CharLiteral($CC.getLine(), $CC.getCharPositionInLine()+1, LexerHelper.lexemeToChar($CC.text));}
        | IC = INT_CONSTANT
            {$ast = new IntLiteral($IC.getLine(), $IC.getCharPositionInLine()+1, LexerHelper.lexemeToInt($IC.text));}
        | '(' e1=expression ')'
            {$ast = $e1.ast;}
        | exp_list=expression '[' exp_index=expression ']'
            {$ast = new Indexing($exp_list.ast.getLine(), $exp_list.ast.getColumn(), $exp_list.ast, $exp_index.ast);}
        | exp_to_access=expression '.' ID
            {$ast = new FieldAccess($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text, $exp_to_access.ast);}
        | '(' cast_type=built_in_type ')' exp_to_cast=expression
            {$ast = new Cast($exp_to_cast.ast.getLine(), $exp_to_cast.ast.getColumn(), $cast_type.ast, $exp_to_cast.ast);}
        | '-' exp_num=expression
            {$ast = new UnaryMinus($exp_num.ast.getLine(), $exp_num.ast.getColumn(), $exp_num.ast);}
        | '!' exp_not=expression
            {$ast = new UnaryNot($exp_not.ast.getLine(), $exp_not.ast.getColumn(), $exp_not.ast);}
        | exp_left=expression OP=('*' | '/' | '%') exp_right=expression
            { $ast = Arithmetic.arithmeticFactory($exp_left.ast.getLine(), $exp_left.ast.getColumn(),
                $exp_left.ast, $OP.text, $exp_right.ast); }
        | exp_left=expression OP=('+' | '-') exp_right=expression
            { $ast = new Arithmetic($exp_left.ast.getLine(), $exp_left.ast.getColumn(),
                $exp_left.ast, $OP.text, $exp_right.ast); }
        | exp_left=expression OP=('<' | '>' | '<=' | '>=' | '==' | '!=') exp_right=expression
            { $ast = new Logical($exp_left.ast.getLine(), $exp_left.ast.getColumn(),
                $exp_left.ast, $OP.text, $exp_right.ast); }
        | exp_left=expression OP=('&&' | '||') exp_right=expression
            { $ast = new Logical($exp_left.ast.getLine(), $exp_left.ast.getColumn(),
                $exp_left.ast, $OP.text, $exp_right.ast); }
        | ID'(' es=expressions ')'
            {$ast = new FuncInvocation($ID.getLine(), $ID.getCharPositionInLine()+1, new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text), $es.ast);}
       ;

expressions returns [List<Expression> ast = new ArrayList<>()]:
        ((e1=expression { $ast.add($e1.ast); } ',')*
        e2=expression { $ast.add($e2.ast); } )?
        ;

statement returns [Statement ast]:
           r='read' ((e1=expression ',')* e1=expression)? ';'
           {$ast = new Read($r.getLine(), $r.getCharPositionInLine()+1, $e1.ast);}
         | w='write' es=expressions ';'
           {$ast = new Write($w.getLine(), $w.getCharPositionInLine()+1, $es.ast);}
         | assignTo=expression '=' toAssign=expression';'
           {$ast = new Assignment($assignTo.ast.getLine(), $assignTo.ast.getColumn(), $assignTo.ast, $toAssign.ast);}
         | ID'(' es=expressions ')' ';'
           {
            $ast = new FunctionInvocation(
               $ID.getLine(),
               $ID.getCharPositionInLine() + 1,
               $es.ast
           );}
         | {List<Statement> elseStatements = new ArrayList<>();}
         i='if' '(' exp=expression ')' ifStmts=block ('else' elseStmts=block {elseStatements = $elseStmts.ast;})?
          {$ast = new IfElse(
              $i.getLine(),
              $i.getCharPositionInLine() + 1,
              $ifStmts.ast,
              elseStatements,
              $exp.ast
           );}
         | wh='while' '(' e1=expression ')' wB=block
         {$ast = new While(
             $wh.getLine(),
             $wh.getCharPositionInLine() + 1,
             $wB.ast,
             $e1.ast
         );}
         | 'return' e1=expression ';'
         {$ast = new Return($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast);}
        ;

block returns [List<Statement> ast = new ArrayList<>()]:
    st1=statement
        {$ast.add($st1.ast);}
    | '{' (st2=statement
        {$ast.add($st2.ast);} )* '}'
    ;

type returns [Type ast]:
    built_in_type
        {$ast = $built_in_type.ast;}
    | t2=type '[' IC=INT_CONSTANT ']'
        {$ast = ArrayType.createArray($t2.ast.getLine(), $t2.ast.getColumn(), LexerHelper.lexemeToInt($IC.text), $t2.ast);}
    | s=struct
        {$ast = $s.ast;}
    ;

built_in_type returns [Type ast]:
    t1='int'
        { $ast = new IntType($t1.getLine(), $t1.getCharPositionInLine()+1);}
    | t1='double'
        {$ast = new DoubleType($t1.getLine(), $t1.getCharPositionInLine()+1);}
    | t1='char'
        {$ast = new CharType($t1.getLine(), $t1.getCharPositionInLine()+1);}
    ;

main_func_def returns [FuncDefinition ast]:
    'void' main='main' '(' ')' '{' body '}' EOF
        {$ast = new FuncDefinition($main.getLine(), $main.getCharPositionInLine()+1, $body.ast, "main");}
    ;

varDef returns [List<VarDefinition> ast = new ArrayList<>()]: t=type i=ids ';'
        {
            for (String id: $i.ast) {
                $ast.add(new VarDefinition($t.ast.getLine(), $t.ast.getColumn(), id, $t.ast));
            }
        }
      ;

ids returns [List<String> ast = new ArrayList<>()]:
    (i1=ID { $ast.add($i1.text); }  ',')* i2=ID { $ast.add($i2.text); }
    ;

funcDef returns [FuncDefinition ast]: //Function type is the only type that cannot be compose
        (built_in_type | 'void') ID '(' params ')' '{' b=body '}'
        {$ast = new FuncDefinition( $ID.getLine(), $ID.getCharPositionInLine() + 1, $b.ast, $ID.text );};

params returns [List<VarDefinition> ast = new ArrayList<>()]:
        ((parameter {$ast.add($parameter.ast);} ',')*
        parameter {$ast.add($parameter.ast);})?
       ;

parameter returns [VarDefinition ast]: built_in_type ID
         {$ast = new VarDefinition(
             $ID.getLine(),
             $ID.getCharPositionInLine() + 1,
             $ID.text,
             $built_in_type.ast
         );}
         ;

body returns [List<Statement> ast = new ArrayList<>()]: (varDef {$ast.addAll($varDef.ast);} )* (st2=statement {$ast.add($st2.ast);} )*
        ;

struct returns [StructType ast]:
     s='struct' '{' r=record '}'
     { $ast = new StructType($s.getLine(), $s.getCharPositionInLine()+1, $r.ast);}
     ;

record returns [List<Field> ast = new ArrayList<>()]: (field { $ast.addAll($field.ast); } )*
      ;

field returns [List<Field> ast = new ArrayList<>()]: t=type i=ids ';'
        {
            for (String id: $i.ast) {
                $ast.add(new Field($t.ast));
            }
        }
      ;



// --- LEXER ---

/**
* Digits
*/
fragment
DIGIT: [0-9]
     ;

/**
* Integer Constants
*/
INT_CONSTANT: '0'
            | [1-9] DIGIT*
            ;

/**
* Real Constants
*/
REAL_CONSTANT: INT_CONSTANT '.' [0-9]*?
             | INT_CONSTANT? '.' [0-9]+
             ;

/**
* Real Constants but with exponents
*/
REAL_CONSTANT_WITH_EXPONENT: REAL_CONSTANT
                          | REAL_CONSTANT ('e'| 'E') ('+' | '-')? INT_CONSTANT
                          ;

/**
* Character constant
*/
CHAR_CONSTANT: '\'' . '\''
             | '\'' '\\' [0-9]+ '\''
             | '\'' '\\t' '\''
             | '\'' '\\n' '\''
             ;

/**
* Single line comment to skip
*/
ON_LINE_COMMENT: '//' .*? ('\n' | '\r' | '\n\r' | '\r\n' | EOF) -> skip
               ;

/**
* Multiline comment to skip
*/
MULTI_LINE_COMMENT: '/*' .*? '*/' -> skip
                  ;

/**
* ID
*/
ID: ([a-zA-Z] | '_')
    | ([a-zA-Z] | [0-9] | '_')+
  ;

/**
* White spaces to skip
*/
WHITE_SPACES: (' ' | '\t' | '\n' | '\r') -> skip
            ;