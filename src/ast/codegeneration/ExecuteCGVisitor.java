package ast.codegeneration;

import ast.statement.Read;
import ast.statement.Write;
import ast.visitor.AbstractVisitor;

public class ExecuteCGVisitor<TP,TR> extends AbstractVisitor<TP, TR> {

    private AddressCGVisitor<TP,TR> addressCGVisitor;
    private CodeGenerator codeGenerator;

    public ExecuteCGVisitor(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
    }

    public void setAddressCGVisitor(AddressCGVisitor<TP,TR> addressCGVisitor) {
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
    /**
     *
     *   execute[[Write: statement -> expression]]=
     *      value[[expression]]
     *      <out> expression.type.suffix()
     */
    @Override
    public TR visit(Write write, TP param){
        write.toWrite.accept(addressCGVisitor, param);
        codeGenerator.outW(write.toWrite.getType());
        return null;
    }

    /**
     *   execute[[Assignment: statement -> expression1 expression2]]=
     *      address[[expression1]]
     *      value[[expression2]]
     *      expression2.type.convertTo(expression1.type)
     *      <store> expression1.type.suffix()
     */

     /**
     *   execute[[FunctionDefinition: definition -> type name statements*]]=
     *      <id>:
     *      enter functionDefinition.numberOfBytesInLocalVars()
     *      execute[[statements]]
     *      ret getReturnType().numberOfBytes(), type.numberOfBytesInParams(), functionDefinition.numberOfBytesInLocalVars()
     */
     /**
     *   execute[[Program -> definitions*]]=
     *      <call> main
     *      <halt>
     *      execute[[definitions]]
     */

    /**
     * execute[[While: statement -> expression statement*]]
     *      String condLabel = cg.nextLabel(),
     *      exitLabel = cg.nextLabel();
     *      condLabel<:>
     *          value[[expression]]
     *          <jz > exitLabel
     *          statement*.forEach(stmt -> execute[[stmt]])
     *          <jmp > condLabel
     *      exitLabel<:>
     */
    /**
     * execute[[IfElseStmt: statement -> expression statement*]]
     *      String elseLabel = cg.nextLabel(),
     *      exitLabel = cg.nextLabel();
     *      value[[expression]]
     *      <jz > elseLabel
     *      statement*.forEach(stmt -> execute[[stmt]])
     *      <jmp > exitLabel
     *      elseLabel<:>
     *          statement*.forEach(stmt -> execute[[stmt]])
     *      exitLabel<:>
     */
}
