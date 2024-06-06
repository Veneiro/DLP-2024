package ast.codegeneration;

import ast.expression.*;
import ast.program.Field;
import ast.program.FuncDefinition;
import ast.program.Program;
import ast.program.VarDefinition;
import ast.statement.*;
import ast.type.*;
import ast.visitor.Visitor;

public abstract class AbstractCGVisitor<TP,TR> implements Visitor<TP,TR> {
    @Override
    public TR visit(Arithmetic arithmetic, TP param) {
        throw new RuntimeException("Arithmetic not found");
    }

    @Override
    public TR visit(Cast cast, TP param) {
        throw new RuntimeException("Cast not found");
    }

    @Override
    public TR visit(CharLiteral charLiteral, TP param) {
        throw new RuntimeException("CharLiteral not found");
    }

    @Override
    public TR visit(Comparision comparision, TP param) {
        throw new RuntimeException("Comparison not found");
    }

    @Override
    public TR visit(FieldAccess fieldAccess, TP param) {
        throw new RuntimeException("FieldAccess not found");
    }

    @Override
    public TR visit(FuncInvocation funcInvocation, TP param) {
        throw new RuntimeException("FuncInvocation not found");
    }

    @Override
    public TR visit(Indexing indexing, TP param) {
        throw new RuntimeException("Indexing not found");
    }

    @Override
    public TR visit(IntLiteral intLiteral, TP param) {
        throw new RuntimeException("IntLiteral not found");
    }

    @Override
    public TR visit(Logical logical, TP param) {
        throw new RuntimeException("Logical not found");
    }

    @Override
    public TR visit(Modulus modulus, TP param) {
        throw new RuntimeException("Modulus not found");
    }

    @Override
    public TR visit(RealLiteral realLiteral, TP param) {
        throw new RuntimeException("RealLiteral not found");
    }

    @Override
    public TR visit(UnaryMinus unaryMinus, TP param) {
        throw new RuntimeException("UnaryMinus not found");
    }

    @Override
    public TR visit(UnaryNot unaryNot, TP param) {
        throw new RuntimeException("UnaryNot not found");
    }

    @Override
    public TR visit(Variable variable, TP param) {
        throw new RuntimeException("Variable not found");
    }

    @Override
    public TR visit(FuncDefinition funcDefinition, TP param) {
        throw new RuntimeException("FuncDefinition not found");
    }

    @Override
    public TR visit(Program program, TP param) {
        throw new RuntimeException("Program not found");
    }

    @Override
    public TR visit(VarDefinition varDefinition, TP param) {
        throw new RuntimeException("VarDefinition not found");
    }

    @Override
    public TR visit(Assignment assignment, TP param) {
        throw new RuntimeException("Assignment not found");
    }

    @Override
    public TR visit(FunctionInvocation functionInvocation, TP param) {
        throw new RuntimeException("FunctionInvocation not found");
    }

    @Override
    public TR visit(IfElse ifElse, TP param) {
        throw new RuntimeException("IfElse not found");
    }

    @Override
    public TR visit(Read read, TP param) {
        throw new RuntimeException("Read not found");
    }

    @Override
    public TR visit(Return ret, TP param) {
        throw new RuntimeException("Return not found");
    }

    @Override
    public TR visit(While whl, TP param) {
        throw new RuntimeException("While not found");
    }

    @Override
    public TR visit(Write write, TP param) {
        throw new RuntimeException("Write not found");
    }

    @Override
    public TR visit(ArrayType arrayType, TP param) {
        throw new RuntimeException("ArrayType not found");
    }

    @Override
    public TR visit(CharType charType, TP param) {
        throw new RuntimeException("CharType not found");
    }

    @Override
    public TR visit(DoubleType doubleType, TP param) {
        throw new RuntimeException("DoubleType not found");
    }

    @Override
    public TR visit(Field field, TP param) {
        throw new RuntimeException("Field not found");
    }

    @Override
    public TR visit(FunctionType functionType, TP param) {
        throw new RuntimeException("FunctionType not found");
    }

    @Override
    public TR visit(IntType intType, TP param) {
        throw new RuntimeException("IntType not found");
    }

    @Override
    public TR visit(StructType structType, TP param) {
        throw new RuntimeException("StructType not found");
    }

    @Override
    public TR visit(ErrorType errorType, TP param) {
        throw new RuntimeException("ErrorType not found");
    }
}
