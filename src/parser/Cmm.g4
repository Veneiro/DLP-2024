grammar Cmm;

@header {
    import ast.*;
    import ast.expression.*;
    import ast.program.*;
    import ast.statement.*;
    import ast.type.*;
}

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

expressions returns [List<Expression> ast = new ArrayList<>()]: ((e1=expression { $ast.add($e1.ast); } ',')* e2=expression { $ast.add($e2.ast); } )?
        ;

statement: 'read' ((expression ',')* expression)? ';'
         | 'write' ((expression ',')* expression)? ';'
         | expression '=' expression';'
         | ID'(' ((expression ',')* expression)? ')' ';'
         | 'if' '(' expression ')' block ('else' block)?
         | 'while' '(' expression ')' block
         | 'return' expression ';'
        ;

block: statement | '{' statement* '}'
    ;

type returns [Type ast]:
    t='int' { $ast = new IntType($t.getLine(), $t.getCharPositionInLine()+1);}
    | 'double' {$ast = new DoubleType();}
    | 'char' {$ast = new CharType();}
    | t=type '[' INT_CONSTANT ']' {$ast = new ArrayType($t.ast.getLine(), $t.ast.getColumn(), $INT_CONSTANT.int, $t.ast);}
    | s=struct {$ast = $s.ast;}
    ;

definitions returns [List<Definition> ast = new ArrayList<>()]: (d1=varDef { $ast.addAll($d1.ast); } | d2=funcDef { $ast.add($d2.ast); })* d3=mainFuncDef { $ast.add($d3.ast); }
           ;

varDef returns [List<VarDefinition> ast = new ArrayList<>()]: t=type i=ids ';'
        {
            for (String id: $i.ast) {
                $ast.add(new VarDefinition($t.ast.getLine(), $t.ast.getColumn(), id, $t.ast));
            }
        }
      ;

ids returns [List<String> ast = new ArrayList<>()]: (i1=ID { $ast.add($i1.text); }  ',')* i2=ID { $ast.add($i2.text); }
    ;

funcDef returns [FuncDefinition ast]: type ID '(' params ')' '{' body '}'
       ;

params: ((parameter ',')* parameter)?
       ;

mainFuncDef returns [FuncDefinition ast]: 'void' 'main' '(' ')' '{' body '}'
           ;

parameter: type ID
         ;

body: varDef* statement*
    ;

struct returns [StructType ast]: 'struct' '{' record '}' { $ast = new StructType()}
     ;

record returns [List<Field> ast = new ArrayList<>()]: varDef*
      ;

fragment
DIGIT: [0-9]
     ;

INT_CONSTANT: '0'
            | [1-9] DIGIT*
            ;

REAL_CONSTANT: INT_CONSTANT '.' [0-9]*?
             | INT_CONSTANT? '.' [0-9]+
             ;

REAL_CONSTANT_WITH_EXPONENT: REAL_CONSTANT
                          | REAL_CONSTANT ('e'| 'E') ('+' | '-')? INT_CONSTANT
                          ;

CHAR_CONSTANT: '\'' . '\''
             | '\'' '\\' [0-9]+ '\''
             | '\'' '\\t' '\''
             | '\'' '\\n' '\''
             ;

ON_LINE_COMMENT: '//' .*? ('\n' | '\r' | '\n\r' | '\r\n' | EOF) -> skip
               ;

MULTI_LINE_COMMENT: '/*' .*? '*/' -> skip
                  ;

ID: ([a-zA-Z] | '_')
    | ([a-zA-Z] | [0-9] | '_')+
  ;

WHITE_SPACES: (' ' | '\t' | '\n' | '\r') -> skip
            ;