package ast.visitor;

import ast.errorhandler.ErrorHandler;
import ast.expression.*;
import ast.statement.*;
import ast.type.*;

public class TypeCheckingVisitor<TP,TR> extends AbstractVisitor<TP,TR> {

    /**
     * EXPRESSIONS
     *
     * (P) Arithmetic: expression1 -> expression2 expression3
     * (R) expression1.type = expression2.type.arithmetic(expression3.type)
     *
     * (P) Indexing: expression1 -> expression2 expression3
     * (R) expression1.type = expression2.type.squareBrackets(expression3.type)
     *
     * (P) FunctionDefinition: expression1 -> type expression2
     * (R) expression1.type = expression2.type
     *
     * No ID because is terminal and not variable because is non terminal and will be never used
     * (P) FuncInvocation: expression1 -> expression2 expression*
     * (R) expression1.type = expression2.type.parenthesis(
     *  expression*.stream().map(exp -> exp.type).toArray())
     *
     * (P) FuncInvocation: statement -> expression expression*
     * (R) expression.type.parenthesis(expression*.stream().map(exp -> exp.type).toArray())
     *
     * (P) Modulus: expression1 -> expression2 expression3
     * (R) expression1.type = expression2.type.modulus(expression3.type)
     *
     * (P) Logical: expression1 -> expression2 expression3
     * (R) expression1.type = expression2.type.logical(expression3.type)
     *
     * (P) Comparison: expression1 -> expression2 expression3
     * (R) expression1.type = expression2.type.comparison(expression3.type)
     *
     * (P) UnaryMinus: expression1 -> expression2
     * (R) expression1.type = expression2.type.unaryMinus()
     *
     * (P) Cast: expression1 -> type expression2
     * (R) expression1.type = expression2.type.castTo(type)
     *
     * (P) VariableDefinition: expression1 -> type expression2
     * (R) expression1.type = expression2.type
     *
     * (P) CharLiteral: expression -> CHAR
     * (R) expression.type = CHAR
     *
     * (P) IntLiteral: expression -> INT
     * (R) expression.type = INT
     *
     * (P) RealLiteral: expression -> REAL
     * (R) expression.type = REAL
     *
     * STATEMENTS
     * (P) Assignment: statement -> expression expression
     * (R) expression1.type = expression2.type
     *
     * (P) Read: statement -> expression
     * (R) statement.type = expression.type
     *
     * (P) Write: statement -> expression
     * (R) statement.type = expression.type
     *
     * (P) WhileStmt: statement1 -> expression statement2*
     * (R) expression.type.mustBeBoolean()
     *
     * (P) IfElseStmt: statement1 -> expression statement2*
     * (R) expression.type.mustBeBoolean()
     *
     * (P) ReturnStmt: statement -> expression
     * (R) expression.type.mustBeSameTypeAs(returnType)
     */

    // EXPRESSIONS
    @Override
    public TR visit(Arithmetic arithmetic, TP param) {
        arithmetic.first_expression.accept(this, null);
        arithmetic.second_expression.accept(this, null);
        arithmetic.setLValue(false);
        return null;
    }

    @Override
    public TR visit(Cast cast, TP param) {
        cast.castType.accept(this, null);
        cast.toCast.accept(this, null);
        cast.setLValue(false);
        return null;
    }

    @Override
    public TR visit(CharLiteral charLiteral, TP param) {
        charLiteral.setLValue(false);
        return null;
    }

    @Override
    public TR visit(Comparision comparision, TP param) {
        comparision.first_to_compare.accept(this, null);
        comparision.second_to_compare.accept(this, null);
        comparision.setLValue(false);
        return null;
    }

    @Override
    public TR visit(Variable variable, TP param) {
        super.visit(variable, param);
        variable.setLValue(true);
        //variable.varDefinition.accept(this, null);
        return null;
    }

    @Override
    public TR visit(Indexing indexing, TP param) {
        indexing.list.accept(this, null);
        indexing.index.accept(this, null);
        indexing.setLValue(true);
        return null;
    }

    @Override
    public TR visit(IntLiteral intLiteral, TP param) {
        intLiteral.setLValue(false);
        return null;
    }

    @Override
    public TR visit(Logical logical, TP param) {
        logical.first_expression.accept(this, null);
        logical.second_expression.accept(this, null);
        logical.setLValue(false);
        return null;
    }

    @Override
    public TR visit(Modulus modulus, TP param) {
        modulus.first_expression.accept(this, null);
        modulus.second_expression.accept(this, null);
        modulus.setLValue(false);
        return null;
    }

    @Override
    public TR visit(RealLiteral realLiteral, TP param) {
        realLiteral.setLValue(false);
        return null;
    }

    @Override
    public TR visit(UnaryMinus unaryMinus, TP param) {
        unaryMinus.number.accept(this, null);
        unaryMinus.setLValue(false);
        return null;
    }

    @Override
    public TR visit(UnaryNot unaryNot, TP param) {
        unaryNot.to_negate.accept(this, null);
        unaryNot.setLValue(false);
        return null;
    }

    @Override
    public TR visit(FieldAccess fieldAccess, TP param) {
        fieldAccess.toAccess.accept(this, null);
        fieldAccess.setLValue(true);
        return null;
    }





    // STATEMENTS

    @Override
    public TR visit(Assignment assignment, TP param) {
        assignment.assign_to.accept(this, param);
        assignment.to_assign.accept(this, param);
        if(!assignment.assign_to.getLValue()){
            ErrorType error = new ErrorType(assignment.assign_to.getLine(), assignment.assign_to.getColumn(),
                    "Wrong Lvalue for assignment");
            ErrorHandler.getInstance().addError(error);
        }
        return null;
    }



    @Override
    public TR visit(Read read, TP param) {
        if(!read.to_read.getLValue()){
            ErrorType error = new ErrorType(read.to_read.getLine(), read.to_read.getColumn(),
                    "Wrong Lvalue for read");
            ErrorHandler.getInstance().addError(error);
        }
        super.visit(read, param);
        return null;
    }

}
