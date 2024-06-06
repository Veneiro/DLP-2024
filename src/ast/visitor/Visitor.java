package ast.visitor;

import ast.expression.*;
import ast.program.Field;
import ast.program.FuncDefinition;
import ast.program.Program;
import ast.program.VarDefinition;
import ast.statement.*;
import ast.type.*;

public interface Visitor<TP,TR> {

    // EXPRESSIONS
    public TR visit(Arithmetic arithmetic, TP param);
    public TR visit(Cast cast,TP param);
    public TR visit(CharLiteral charLiteral,TP param);
    public TR visit(Comparision comparision,TP param);
    public TR visit(FieldAccess fieldAccess, TP param);
    public TR visit(FuncInvocation funcInvocation,TP param);
    public TR visit(Indexing indexing,TP param);
    public TR visit(IntLiteral intLiteral,TP param);
    public TR visit(Logical logical,TP param);
    public TR visit(Modulus modulus,TP param);
    public TR visit(RealLiteral realLiteral,TP param);
    public TR visit(UnaryMinus unaryMinus,TP param);
    public TR visit(UnaryNot unaryNot,TP param);
    public TR visit(Variable variable, TP param);

    // DEFINITIONS
    public TR visit(FuncDefinition funcDefinition, TP param);
    public TR visit(Program program, TP param);
    public TR visit(VarDefinition varDefinition, TP param);

    // STATEMENT
    public TR visit(Assignment assignment, TP param);
    public TR visit(FunctionInvocation functionInvocation, TP param);
    public TR visit(IfElse ifElse, TP param);
    public TR visit(Read read, TP param);
    public TR visit(Return ret, TP param);
    public TR visit(While whl,TP param);
    public TR visit(Write write,TP param);

    // TYPES
    public TR visit(ArrayType arrayType, TP param);
    public TR visit(CharType charType, TP param);
    public TR visit(DoubleType doubleType, TP param);
    public TR visit(Field field, TP param);
    public TR visit(FunctionType functionType, TP param);
    public TR visit(IntType intType, TP param);
    public TR visit(StructType structType, TP param);
    public TR visit(ErrorType errorType, TP param);
}
