package ast.codegeneration;

import ast.expression.FieldAccess;
import ast.statement.Read;
import ast.visitor.AbstractVisitor;
import ast.visitor.Visitor;

public class ExecuteCGVisitor<TP,TR> extends AbstractVisitor<TP, TR> {

    private AddressCGVisitor addressCGVisitor;
    private CodeGenerator codeGenerator;

    public ExecuteCGVisitor(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
    }

    public void setAddressCGVisitor(AddressCGVisitor addressCGVisitor) {
        this.addressCGVisitor = addressCGVisitor;
    }

    /**
     *
     *   execute[[Read: statement -> expression]]=
     *      address[[expression]]
     *      <in> expression.type.suffix()
     */
    @Override
    public TR visit(Read read, TP param) {
        read.to_read.accept(addressCGVisitor, param);
        codeGenerator.in(read.to_read.getType());

        return null;
    }
    /*
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
