package ast.codegeneration;

import ast.expression.FuncInvocation;
import ast.program.FuncDefinition;
import ast.program.Program;
import ast.program.VarDefinition;
import ast.statement.*;
import ast.type.FunctionType;
import ast.visitor.AbstractVisitor;

public class ExecuteCGVisitor<TP,TR> extends AbstractVisitor<TP, TR> {

    private AddressCGVisitor<TP,TR> addressCGVisitor;
    private ValueCGVisitor<TP,TR> valueCGVisitor;
    private CodeGenerator codeGenerator;
    private String source;

    public ExecuteCGVisitor(CodeGenerator codeGenerator, String source) {
        this.source = source;
        this.codeGenerator = codeGenerator;
    }

    public void setAddressCGVisitor(AddressCGVisitor<TP,TR> addressCGVisitor) {
        this.addressCGVisitor = addressCGVisitor;
    }
    public void setValueCGVisitor(ValueCGVisitor<TP, TR> value) {
        this.valueCGVisitor = value;
    }

    /**
     *
     *   execute[[Read: statement -> expression]]=
     *      address[[expression]]
     *      <in> expression.type.suffix()
     */
    @Override
    public TR visit(Read read, TP param) {
        codeGenerator.line(read.getLine());

        read.to_read.accept(addressCGVisitor, param);
        codeGenerator.in(read.to_read.getType());
        codeGenerator.store(read.to_read.getType());

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
        codeGenerator.line(write.getLine());

        write.toWrite.accept(valueCGVisitor, param);
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
    @Override
    public TR visit(Assignment assignment, TP param){
        codeGenerator.line(assignment.getLine());

        assignment.assign_to.accept(addressCGVisitor, param);
        assignment.to_assign.accept(valueCGVisitor, param);
        codeGenerator.convert(assignment.to_assign.getType(), assignment.assign_to.getType());
        codeGenerator.store(assignment.assign_to.getType());
        return null;
    }

     /**
     *   execute[[FunctionDefinition: definition -> type name statements*]]=
     *      <id>:
     *      enter functionDefinition.numberOfBytesInLocalVars()
     *      execute[[statements]]
     *      ret getReturnType().numberOfBytes(), type.numberOfBytesInParams(), functionDefinition.numberOfBytesInLocalVars()
     */
    @Override
    public TR visit(FuncDefinition funcDefinition, TP param) {
        codeGenerator.line(funcDefinition.getLine());

        int localSize = funcDefinition.statements.stream()
                .filter(s -> s instanceof VarDefinition)
                .mapToInt(s -> ((VarDefinition)s).getType().numberOfBytes())
                .sum();
        int paramSize = ((FunctionType) funcDefinition.getType()).definitions.stream()
                .mapToInt(s -> ((VarDefinition)s).getType().numberOfBytes())
                .sum();
        int returnSize = 0;
        if (((FunctionType) funcDefinition.getType()).return_type != null) {
            returnSize = ((FunctionType) funcDefinition.getType()).return_type.numberOfBytes();
        }

        codeGenerator.label(funcDefinition.getName());
        codeGenerator.enter(localSize);
        funcDefinition.statements.forEach(s -> s.accept(this, param));
        return null;
    }
    /**
     *   execute[[Program -> definitions*]]=
     *      <call> main
     *      <halt>
     *      execute[[definitions]]
     */
    @Override
    public TR visit(Program program, TP param) {
        codeGenerator.source(source);
        codeGenerator.call("main");
        codeGenerator.halt();
        program.definitions.forEach(d -> d.accept(this,param));
        return null;
    }

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

    @Override
    public TR visit(While w, TP param){
        codeGenerator.line(w.getLine());

        String condLabel = codeGenerator.nextLabel();
        String exitLabel = codeGenerator.nextLabel();

        codeGenerator.label(condLabel);
        w.while_expression.accept(valueCGVisitor, param);
        codeGenerator.jz(exitLabel);
        w.while_statement.forEach(s -> s.accept(this, param));
        codeGenerator.jmp(condLabel);
        codeGenerator.label(exitLabel);

        return null;
    }
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
    @Override
    public TR visit(IfElse ifElse, TP param){
        codeGenerator.line(ifElse.getLine());

        String elseLabel = codeGenerator.nextLabel();
        String exitLabel = codeGenerator.nextLabel();

        ifElse.expr.accept(valueCGVisitor, param);

        codeGenerator.jz(elseLabel);
        ifElse.if_statement.forEach(s -> s.accept(this, param));
        codeGenerator.jmp(exitLabel);
        codeGenerator.label(elseLabel);
        ifElse.else_statement.forEach(s -> s.accept(this, param));
        codeGenerator.label(exitLabel);
        return null;
    }

    /**
     * execute[[Return: statement -> exp]] (int bytesReturn, int bytesLocals, int bytesArgs) =
     * value[[exp]]
     * <ret > bytesReturn <, > bytesLocals <, > bytesArgs
     */
    @Override
    public TR visit(Return ret, TP param){
        codeGenerator.line(ret.getLine());
        ret.to_return.accept(valueCGVisitor, param);
        int localSize = ret.getDefinition().statements.stream()
                .filter(s -> s instanceof VarDefinition)
                .mapToInt(s -> ((VarDefinition)s).getType().numberOfBytes())
                .sum();
        int paramSize = ((FunctionType) ret.getDefinition().getType()).definitions.stream()
                .mapToInt(s -> ((VarDefinition)s).getType().numberOfBytes())
                .sum();
        int returnSize = 0;
        if (((FunctionType) ret.getDefinition().getType()).return_type != null) {
            returnSize = ((FunctionType) ret.getDefinition().getType()).return_type.numberOfBytes();
        }
        codeGenerator.ret(returnSize, paramSize, localSize);
        return null;
    }

    @Override
    public TR visit(FuncInvocation funcInvocation, TP param) {

        funcInvocation.expressions.forEach(e -> e.accept(valueCGVisitor, param));

        codeGenerator.call(funcInvocation.variable.name);

        FunctionType type = (FunctionType) funcInvocation.variable.getType();
        if (type.return_type != null) {
            codeGenerator.pop(type.return_type.suffix());
        }

        return null;
    }
}
