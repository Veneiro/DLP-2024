package ast.visitor;

import ast.expression.*;
import ast.program.FuncDefinition;
import ast.program.Program;
import ast.program.VarDefinition;
import ast.statement.*;
import ast.type.*;

public class AbstractVisitor<TP, TR> implements Visitor<TP, TR> {
    @Override
    public TR visit(Arithmetic arithmetic, TP param) {
        arithmetic.first_expression.accept(this, null);
        arithmetic.second_expression.accept(this, null);
        return null;
    }

    @Override
    public TR visit(Cast cast, TP param) {
        cast.to_cast.accept(this, null);
        return null;
    }

    @Override
    public TR visit(CharLiteral charLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(Comparision comparision, TP param) {
        comparision.first_to_compare.accept(this, null);
        comparision.second_to_compare.accept(this, null);
        return null;
    }

    @Override
    public TR visit(FieldAccess fieldAccess, TP param) {
        fieldAccess.toAccess.accept(this, null);
        return null;
    }

    @Override
    public TR visit(FuncInvocation funcInvocation, TP param) {
        funcInvocation.expressions.forEach(exp -> exp.accept(this, null));
        funcInvocation.variable.accept(this, null);
        return null;
    }

    @Override
    public TR visit(Indexing indexing, TP param) {
        indexing.list.accept(this, null);
        indexing.index.accept(this, null);
        return null;
    }

    @Override
    public TR visit(IntLiteral intLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(Logical logical, TP param) {
        logical.first_expression.accept(this, null);
        logical.second_expression.accept(this, null);
        return null;
    }

    @Override
    public TR visit(Modulus modulus, TP param) {
        modulus.first_expression.accept(this, null);
        modulus.second_expression.accept(this, null);
        return null;
    }

    @Override
    public TR visit(RealLiteral realLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(UnaryMinus unaryMinus, TP param) {
        unaryMinus.number.accept(this, null);
        return null;
    }

    @Override
    public TR visit(UnaryNot unaryNot, TP param) {
        unaryNot.to_negate.accept(this, null);
        return null;
    }

    @Override
    public TR visit(Variable variable, TP param) {
        return null;
    }

    @Override
    public TR visit(FuncDefinition funcDefinition, TP param) {
        //funcDefinition.getType().accept(this, null);
        funcDefinition.statements.forEach(stmt -> stmt.accept(this, null));
        return null;
    }

    @Override
    public TR visit(Program program, TP param) {
        program.definitions.forEach(def -> def.accept(this, null));
        return null;
    }

    @Override
    public TR visit(VarDefinition varDefinition, TP param) {
        varDefinition.type.accept(this, null);
        return null;
    }

    @Override
    public TR visit(Assignment assignment, TP param) {
        assignment.assign_to.accept(this, null);
        assignment.to_assign.accept(this, null);
        return null;
    }

    @Override
    public TR visit(FunctionInvocation functionInvocation, TP param) {
        functionInvocation.expressions.forEach(exp -> exp.accept(this, null));
        functionInvocation.variable.accept(this, null);
        return null;
    }

    @Override
    public TR visit(IfElse ifElse, TP param) {
        ifElse.expr.accept(this, null);
        ifElse.if_statement.forEach(stmt -> stmt.accept(this, null));
        ifElse.else_statement.forEach(stmt -> stmt.accept(this, null));
        return null;
    }

    @Override
    public TR visit(Read read, TP param) {
        read.to_read.accept(this, null);
        return null;
    }

    @Override
    public TR visit(Return ret, TP param) {
        ret.to_return.accept(this, null);
        return null;
    }

    @Override
    public TR visit(While whl, TP param) {
        whl.while_expression.accept(this, null);
        whl.while_statement.forEach(stmt -> stmt.accept(this, null));
        return null;
    }

    @Override
    public TR visit(Write write, TP param) {
        write.to_write.forEach(toWrite -> toWrite.accept(this, null));
        return null;
    }

    @Override
    public TR visit(ArrayType arrayType, TP param) {
        arrayType.accept(this, null);
        return null;
    }

    @Override
    public TR visit(CharType charType, TP param) {
        return null;
    }

    @Override
    public TR visit(DoubleType doubleType, TP param) {
        return null;
    }

    @Override
    public TR visit(Field field, TP param) {
        field.field_type.accept(this, null);
        return null;
    }

    @Override
    public TR visit(FunctionType functionType, TP param) {
        functionType.definitions.forEach(def -> def.accept(this, null));
        return null;
    }

    @Override
    public TR visit(IntType intType, TP param) {
        return null;
    }

    @Override
    public TR visit(StructType structType, TP param) {
        structType.struct_fields.forEach(field -> field.accept(this, null));
        return null;
    }

    @Override
    public TR visit(ErrorType errorType, TP param) {
        return null;
    }
}
