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

expression returns [Expression ast]:
          ID { $ast = new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text); }
        | RC = REAL_CONSTANT {$ast = new RealLiteral($ID.getLine(), $ID.getCharPositionInLine()+1, LexerHelper.lexemeToReal($RC.text));}
        | CC = CHAR_CONSTANT {$ast = new CharLiteral($ID.getLine(), $ID.getCharPositionInLine()+1, LexerHelper.lexemeToChar($CC.text));}
        | IC = INT_CONSTANT {$ast = new IntLiteral($ID.getLine(), $ID.getCharPositionInLine()+1, LexerHelper.lexemeToInt($IC.text));}
        | '(' e1=expression ')' {$ast = $e1.ast;}
        | e1=expression '[' e2=expression ']' {$ast = new Indexing($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast);}
        | e1=expression '.' ID {$ast = new FieldAccess($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text, $e1.ast);}
        | '(' t=type ')' e=expression {$ast = new Cast($e.ast.getLine(), $e.ast.getColumn(), $t.ast, $e.ast);}
        | '-' e1=expression {$ast = new UnaryMinus($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast);}
        | '!' e1=expression {$ast = new UnaryNot($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast);}
        | e1=expression ('*' | '/' | '%') e2=expression
            { $ast = new Arithmetic($e1.ast.getLine(), $e1.ast.getColumn(),
                $e1.ast, $OP.text, $e2.ast); }
        | e1=expression OP=('+' | '-') e2=expression
            { $ast = new Arithmetic($e1.ast.getLine(), $e1.ast.getColumn(),
                $e1.ast, $OP.text, $e2.ast); }
        | e1=expression ('<' | '>' | '<=' | '>=' | '==' | '!=') e2=expression
            { $ast = new Logical($e1.ast.getLine(), $e1.ast.getColumn(),
                $e1.ast, $OP.text, $e2.ast); }
        | e1=expression ('&&' | '||') e2=expression
            { $ast = new Logical($e1.ast.getLine(), $e1.ast.getColumn(),
                $e1.ast, $OP.text, $e2.ast); }
        | ID'(' es=expressions ')' {$ast = new FuncInvocation($ID.getLine(), $ID.getCharPositionInLine()+1, new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text), $es.ast);}
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
    st1=statement {$ast.add($st1.ast);}
    | '{' (st2=statement {$ast.add($st2.ast);} )* '}'
    ;

type returns [Type ast]:
    builtInType {$ast = $builtInType.ast;}
    | t2=type '[' INT_CONSTANT ']' {$ast = new ArrayType($t2.ast.getLine(), $t2.ast.getColumn(), $INT_CONSTANT.int, $t2.ast);}
    | s=struct {$ast = $s.ast;}
    ;

builtInType returns [Type ast]:
    t1='int' { $ast = new IntType($t1.getLine(), $t1.getCharPositionInLine()+1);}
    | t1='double' {$ast = new DoubleType($t1.getLine(), $t1.getCharPositionInLine()+1);}
    | t1='char' {$ast = new CharType($t1.getLine(), $t1.getCharPositionInLine()+1);}
    ;

definitions returns [List<Definition> ast = new ArrayList<>()]:
    (d1=varDef { $ast.addAll($d1.ast); }
    | d2=funcDef { $ast.add($d2.ast); })*
    d3=mainFuncDef { $ast.add($d3.ast); }
    ;

mainFuncDef returns [FuncDefinition ast]: 'void' main='main' '(' ')' '{' body '}'
    {
       $ast = new FuncDefinition($main.getLine(), $main.getCharPositionInLine()+1, $body.ast, "main");
    }
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

funcDef returns [FuncDefinition ast] locals [List<Statement> statements = new ArrayList<>()]:
        (builtInType | 'void') ID '(' params ')' '{' body '}'
        {FuncDefinition funcDef = new FuncDefinition(
                                        $ID.getLine(),
                                        $ID.getCharPositionInLine() + 1,
                                        $statements,
                                        $ID.text
                                    );
        $ast = funcDef;};

params returns [List<VarDefinition> ast = new ArrayList<>()]:
        ((parameter {$ast.add($parameter.ast);} ',')*
        parameter {$ast.add($parameter.ast);})?
       ;

parameter returns [VarDefinition ast]: builtInType ID
         {$ast = new VarDefinition(
             $ID.getLine(),
             $ID.getCharPositionInLine() + 1,
             $ID.text,
             $builtInType.ast
         );}
         ;

body returns [List<Statement> ast = new ArrayList<>()]:
        (varDef {$ast.addAll($varDef.ast);} )*
        | st1=statement {$ast.add($st1.ast);}
        | '{' (st2=statement {$ast.add($st2.ast);} )* '}'
        ;

struct returns [StructType ast]:
     s='struct' '{' r=record '}'
     { $ast = new StructType($s.getLine(), $s.getCharPositionInLine()+1, $r.ast);}
     ;

record returns [List<Field> ast = new ArrayList<>()]: varDef*
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