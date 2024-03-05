grammar Cmm;

// --- IMPORTS ---
/**
 * There you have the imports for the ast clases we created in previous labs to make the grammar work
 * and create the ast
 */
@header {
    import ast.*;
    import ast.expression.*;
    import ast.program.*;
    import ast.statement.*;
    import ast.type.*;
}

// --- PARSER ---

/**
 * Program production rule
 */
program returns [Program ast]:
        d=definitions { $ast = new Program(0,0,$d.ast); }
        ;

/**
 * Definitions production rule, contains the definitions for variable, common function and main function
 */
definitions returns [List<Definition> ast = new ArrayList<>()]:
        (def_var=varDef { $ast.addAll($def_var.ast); }
        | def_func=funcDef { $ast.add($def_func.ast); })*
        def_main=main_func_def { $ast.add($def_main.ast); }
        ;

/**
 * Expression production rule, contains all the expressions contained in C--
 */
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
            {$ast = new FuncInvocation($ID.getLine(), $ID.getCharPositionInLine()+1, new Variable($ID.getLine(),
                $ID.getCharPositionInLine()+1, $ID.text), $es.ast);}
       ;

/**
 * Expressions production rule, it defines a list of expressions
 */
expressions returns [List<Expression> ast = new ArrayList<>()]:
        ((e1=expression { $ast.add($e1.ast); } ',')*
        e2=expression { $ast.add($e2.ast); } )?
        ;

/**
 * Statement production rule, contains all the statements defined in C--
 */
statement returns [Statement ast]:
          r='read' ((toRead=expression ',')* toRead=expression)? ';'
            {$ast = new Read($r.getLine(), $r.getCharPositionInLine()+1, $toRead.ast);}
        | w='write' es_to_write=expressions ';'
            {$ast = new Write($w.getLine(), $w.getCharPositionInLine()+1, $es_to_write.ast);}
        | assignTo=expression '=' toAssign=expression';'
            {$ast = new Assignment($assignTo.ast.getLine(), $assignTo.ast.getColumn(), $assignTo.ast, $toAssign.ast);}
        | ID'(' es=expressions ')' ';'
            {
              $ast = new FunctionInvocation(
              $ID.getLine(),
              $ID.getCharPositionInLine() + 1,
              $es.ast
            );}
        | {List<Statement> else_statements = new ArrayList<>();}
        i='if' '(' exp=expression ')' if_stmts=block ('else' else_stmts=block {else_statements = $else_stmts.ast;})?
            {$ast = new IfElse(
                $i.getLine(),
                $i.getCharPositionInLine() + 1,
                $if_stmts.ast,
                else_statements,
                $exp.ast
            );}
        | wh='while' '(' e1=expression ')' while_block=block
            {$ast = new While(
                $wh.getLine(),
                $wh.getCharPositionInLine() + 1,
                $while_block.ast,
                $e1.ast
            );}
        | 'return' exp_to_return=expression ';'
            {$ast = new Return($exp_to_return.ast.getLine(), $exp_to_return.ast.getColumn(), $exp_to_return.ast);}
        ;

/**
 * Block production rule,
 * is the pr to define the blocks of some of the statements like if-block, else-block or while-block
 */
block returns [List<Statement> ast = new ArrayList<>()]:
        st1=statement
            {$ast.add($st1.ast);}
        | '{' (st2=statement
            {$ast.add($st2.ast);} )* '}'
        ;

/**
 * Type production rule, contains all the types defined in C--
 */
type returns [Type ast]:
        built_in_type
            {$ast = $built_in_type.ast;}
        | array_type=type '[' IC=INT_CONSTANT ']'
            {$ast = ArrayType.createArray($array_type.ast.getLine(), $array_type.ast.getColumn(),
                LexerHelper.lexemeToInt($IC.text), $array_type.ast);}
        | s=struct
            {$ast = $s.ast;}
        ;

/**
 * Built in type production rule, contains just the built in types defined in C--, in this case are int, double and char
 */
built_in_type returns [Type ast]:
        t1='int'
            { $ast = new IntType($t1.getLine(), $t1.getCharPositionInLine()+1);}
        | t1='double'
            {$ast = new DoubleType($t1.getLine(), $t1.getCharPositionInLine()+1);}
        | t1='char'
            {$ast = new CharType($t1.getLine(), $t1.getCharPositionInLine()+1);}
        ;

/**
 * Main function production rule, contains the definition for the main function in C--
 */
main_func_def returns [FuncDefinition ast]:
        'void' main='main' '(' ')' '{' body '}' EOF
            {$ast = new FuncDefinition($main.getLine(), $main.getCharPositionInLine()+1, $body.ast, "main");}
        ;

/**
 * Variable definition production rule, contains the specification for defining variables in C--
 */
varDef returns [List<VarDefinition> ast = new ArrayList<>()]:
        t=type i=ids ';'
        {for (String id: $i.ast) {
                $ast.add(new VarDefinition($t.ast.getLine(), $t.ast.getColumn(), id, $t.ast));
        }}
        ;

/**
 * Ids production rule, it is used in varDef, it contains a list of ids or variable names in case of varDef
 */
ids returns [List<String> ast = new ArrayList<>()]:
        (i1=ID { $ast.add($i1.text); }  ',')* i2=ID { $ast.add($i2.text); }
        ;

/**
 * Function definition production rule, it contains the specification for defining functions in C--
 */
funcDef returns [FuncDefinition ast]: //Function type is the only type that cannot be compose
        (built_in_type | 'void') ID '(' params ')' '{' b=body '}'
        {$ast = new FuncDefinition( $ID.getLine(), $ID.getCharPositionInLine() + 1, $b.ast, $ID.text );};

/**
 * Params production rule, it is used to specify a list of parameters, like the ones used in functions
 */
params returns [List<VarDefinition> ast = new ArrayList<>()]:
        ((parameter {$ast.add($parameter.ast);} ',')*
        parameter {$ast.add($parameter.ast);})?
        ;

/**
 * Parameter production rule, definition for a single parameter, like the ones used in functions
 */
parameter returns [VarDefinition ast]: built_in_type ID
        {$ast = new VarDefinition(
            $ID.getLine(),
            $ID.getCharPositionInLine() + 1,
            $ID.text,
            $built_in_type.ast
        );}
        ;

/**
 * Body production rule, it is the definition for the body of the functions in C--, it is different from block
 */
body returns [List<Statement> ast = new ArrayList<>()]:
        (varDef {$ast.addAll($varDef.ast);} )* (st2=statement {$ast.add($st2.ast);} )*
        ;

/**
 * Struct production rule, it defines the struct for C--
 */
struct returns [StructType ast]:
         s='struct' '{' r=record '}'
         { $ast = new StructType($s.getLine(), $s.getCharPositionInLine()+1, $r.ast);}
         ;

/**
 * Record production rule
 */
record returns [List<Field> ast = new ArrayList<>()]:
        (field { $ast.addAll($field.ast); } )*
        ;

/**
 * Field production rule
 */
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