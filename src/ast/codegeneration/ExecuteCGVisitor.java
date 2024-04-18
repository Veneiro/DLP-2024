package ast.codegeneration;

public class ExecuteCGVisitor {
    /**
     *
     *   execute[[Read: statement -> expression]]=
     *      address[[expression]]
     *      <read> expression.type.suffix()
     *
     *   execute[[Write: statement -> expression]]=
     *      value[[expression]]
     *      <write> expression.type.suffix()
     *
     *   execute[[Assignment: statement -> expression1 expression2]]=
     *      address[[expression1]]
     *      value[[expression2]]
     *      expression2.type.convertTo(expression1.type)
     *      <store> expression1.type.suffix()
     *
     *   execute[[VariableDefinition: expression1 -> type expression2]]=
     *      address[[expression2]]
     *      <pushi> expression2.type.numberOfBytes()
     *      <store> expression1.type.suffix()
     *
     *   execute[[FunctionDefinition: expression1 -> type expression2]]=
     *      <id>:
     *      enter expression2.type.numberOfBytes()
     *      execute[[expression2]]
     *      ret getReturnType().numberOfBytes(), type.numberOfBytes(), expression2.type.numberOfBytes()
     *
     *   execute[[Program -> definitions*]]=
     *      <pusha> bp
     *      <pusha> sp
     *      <jmp> main
     *      <halt>
     */
}
