# DLP 2023-2024 Course
``Teacher: Francisco Ortin``

## Language Description

### Program
A program is a sequence of variable and function definitions.

### Variable and Program Definitions
- The syntax of a variable definition is a type followed by a non-empty enumeration of comma-separated identifiers. 
- Variable definitions must end with the ";" character.
- Functions are defined by specifying the return type, the function identifier and a list of comma-separated parameters between ( and ). 
- The bodies of functions are sequences of variable definitions followed by sequences of statements. Both must end with the ";" character.
- The last and mandatory function is "main", which returns void and receives no parameters.

### Types
- Built-in types are "int", "double" and "char". 
- Array types can be created with the "[]" type constructor, following the Java syntax but specifying the size of the array with an integer constant (like C). 
- The "struct" type constructor is added for specifying record types. Records have no type identifier, and fields are declared as var definitions between { and }. 
- Type definition (i.e., typedef) is not supported.
- Parameter types must be built-in (i.e., no arrays or records). 
- Return types could be built-in or void. The function body goes between { and }.

### Statements
- The syntax of a write statement (console output) is the "write" keyword followed by a non-empty comma-separated list of expressions. 
- The read statement (console input) is similar, but using the "read" keyword.
- If / else and while statements follow the C syntax. 
- The return <expression> statement is also supported (the expression is mandatory). 
- Variables cannot be defined in if / else and while bodies.
- A function invocation may be an expression or a statement. 
- A procedure (i.e., a function returning void) invocation is always a statement.

### Expressions
- The cast expression follows the C syntax.
- Assignments are built with two expressions separated by the "=" operator.

**Expressions priority:**

Expressions are built with:
- Integer, real and character constants without sign.
- Identifiers.
- The following operators applied to one or two expressions (descending order of precedence):

|Expression|Associativity|
|---|---|
|( )|Non-associative|         
|[]|Non-associative|
|.|Non-associative|
|Cast|Non-associative|
|- (unary)|Non-associative|
|!|Non-associative|
|* / %|Left associative|
|+ -|Left associative|
|> >= < <= != ==|Left associative|
| && \|\| |Left associative|

