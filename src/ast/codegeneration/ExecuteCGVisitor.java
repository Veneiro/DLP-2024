package ast.codegeneration;

public class ExecuteCGVisitor {
    /**
     *
     *   execute[[Read: statement -> expression]]=
     *      address[[expression]]
     *      <in> expression.type.suffix()
     *
     *   execute[[Write: statement -> expression]]=
     *      value[[expression]]
     *      <out> expression.type.suffix()
     *
     *   execute[[Assignment: statement -> expression1 expression2]]=
     *      address[[expression1]]
     *      value[[expression2]]
     *      expression2.type.convertTo(expression1.type)
     *      <store> expression1.type.suffix()
     *
     *
     *   execute[[FunctionDefinition: definition -> type name statements*]]=
     *      <id>:
     *      enter functionDefinition.numberOfBytesInLocalVars()
     *      execute[[statements]]
     *      ret getReturnType().numberOfBytes(), type.numberOfBytesInParams(), functionDefinition.numberOfBytesInLocalVars()
     *
     *   execute[[Program -> definitions*]]=
     *      <call> main
     *      <halt>
     *      execute[[definitions]]
     */
}
