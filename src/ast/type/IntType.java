package ast.type;

import ast.ASTAbstractNode;
import ast.errorhandler.ErrorHandler;
import ast.visitor.Visitor;

public class IntType extends AbstractType {

    public IntType(int line, int column) {
        super(line, column);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type arithmetic(Type type) {
        if(this.getClass() == type.getClass()){
            return this;
        } else if (type instanceof ErrorType){
            return type;
        } else {
            ErrorType error = new ErrorType(this.getLine(), this.getColumn(), "ERROR: Arithmetic operation between different types");
            ErrorHandler.getInstance().addError(error);
            return error;
        }
    }

    @Override
    public Type castTo(Type type) {
        if(this.getClass() == type.getClass()){
            return this;
        } else if (type instanceof ErrorType){
            return type;
        } else {
            ErrorType error = new ErrorType(this.getLine(), this.getColumn(), "ERROR: Cast operation between different types");
            ErrorHandler.getInstance().addError(error);
            return error;
        }
    }

    @Override
    public Type comparison(Type type) {
        if(this.getClass() == type.getClass()){
            return this;
        } else if (type instanceof ErrorType){
            return type;
        } else {
            ErrorType error = new ErrorType(this.getLine(), this.getColumn(), "ERROR: Comparison operation between different types");
            ErrorHandler.getInstance().addError(error);
            return error;
        }
    }

    @Override
    public Type logical(Type type) {
        if(this.getClass() == type.getClass()){
            return this;
        } else if (type instanceof ErrorType){
            return type;
        } else {
            ErrorType error = new ErrorType(this.getLine(), this.getColumn(), "ERROR: Logical operation between different types");
            ErrorHandler.getInstance().addError(error);
            return error;
        }
    }

    @Override
    public Type modulus(Type type) {
        if(this.getClass() == type.getClass()){
            return this;
        } else if (type instanceof ErrorType){
            return type;
        } else {
            ErrorType error = new ErrorType(this.getLine(), this.getColumn(), "ERROR: Modulus operation between different types");
            ErrorHandler.getInstance().addError(error);
            return error;
        }
    }

    @Override
    public Type unaryMinus() {
        return this;
    }

    @Override
    public int numberOfBytes() {
        return 2;
    }

    @Override
    public boolean mustBeSubtype(Type type) {
        if(type instanceof IntType || type instanceof DoubleType) {
            return true;
        }
        return false;
    }
}
