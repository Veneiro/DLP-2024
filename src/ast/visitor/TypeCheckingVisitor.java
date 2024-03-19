package ast.visitor;

import ast.errorhandler.ErrorHandler;
import ast.expression.*;
import ast.statement.*;
import ast.type.*;

public class TypeCheckingVisitor<TP,TR> extends AbstractVisitor<TP,TR> {

    // EXPRESSIONS
    @Override
    public TR visit(Arithmetic arithmetic, TP param) {
        super.visit(arithmetic, param);
        arithmetic.setLValue(false);
        return null;
    }

    @Override
    public TR visit(Cast cast, TP param) {
        super.visit(cast, param);
        cast.setLValue(false);
        return null;
    }

    @Override
    public TR visit(CharLiteral charLiteral, TP param) {
        super.visit(charLiteral, param);
        charLiteral.setLValue(false);
        return null;
    }

    @Override
    public TR visit(Comparision comparision, TP param) {
        super.visit(comparision,param);
        comparision.setLValue(false);
        return null;
    }

    @Override
    public TR visit(Variable variable, TP param) {
        super.visit(variable, param);
        variable.setLValue(true);
        return null;
    }

    @Override
    public TR visit(Indexing indexing, TP param) {
        super.visit(indexing, param);
        indexing.setLValue(true);
        return null;
    }

    @Override
    public TR visit(IntLiteral intLiteral, TP param) {
        super.visit(intLiteral, param);
        intLiteral.setLValue(false);
        return null;
    }

    @Override
    public TR visit(Logical logical, TP param) {
        super.visit(logical, param);
        logical.setLValue(false);
        return null;
    }

    @Override
    public TR visit(Modulus modulus, TP param) {
        super.visit(modulus, param);
        modulus.setLValue(false);
        return null;
    }

    @Override
    public TR visit(RealLiteral realLiteral, TP param) {
        super.visit(realLiteral, param);
        realLiteral.setLValue(false);
        return null;
    }

    @Override
    public TR visit(UnaryMinus unaryMinus, TP param) {
        super.visit(unaryMinus, param);
        unaryMinus.setLValue(false);
        return null;
    }

    @Override
    public TR visit(UnaryNot unaryNot, TP param) {
        super.visit(unaryNot, param);
        unaryNot.setLValue(false);
        return null;
    }

    @Override
    public TR visit(FieldAccess fieldAccess, TP param) {
        super.visit(fieldAccess, param);
        fieldAccess.setLValue(true);
        return null;
    }





    // STATEMENTS

    @Override
    public TR visit(Assignment assignment, TP param) {
        if(!assignment.assign_to.getLValue()){
            ErrorType error = new ErrorType(assignment.assign_to.getLine(), assignment.assign_to.getColumn(),
                    "Wrong Lvalue for assignment");
            ErrorHandler.getInstance().addError(error);
        }
        assignment.assign_to.accept(this, param);
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
