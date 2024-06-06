package ast.type;

import ast.errorhandler.ErrorHandler;
import ast.visitor.Visitor;

public class CharType extends AbstractType {

    public CharType(int line, int column) {
        super(line, column);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type arithmetic(Type type) {
        if(this.getClass() == type.getClass()){
            return new IntType(this.getLine(), this.getColumn());
        } else if (type instanceof ErrorType){
            return type;
        } else {
            ErrorType error = new ErrorType(this.getLine(), this.getColumn(), "ERROR: Arithmetic operation between different types");
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
    public Type castTo(Type type) {
        if(this.getClass() == type.getClass()){
            return this;
        } else if (type instanceof IntType){
            return new IntType(this.getLine(), this.getColumn());
        } else if (type instanceof DoubleType){
            return new DoubleType(this.getLine(), this.getColumn());
        } else if (type instanceof ErrorType){
            return type;
        } else {
            ErrorType error = new ErrorType(this.getLine(), this.getColumn(), "ERROR: Cast operation between different types");
            ErrorHandler.getInstance().addError(error);
            return error;
        }
    }

    @Override
    public Type modulus(Type type) {
        if(this.getClass() == type.getClass()){
            return new IntType(this.getLine(), this.getColumn());
        } else if (type instanceof ErrorType){
            return type;
        } else {
            ErrorType error = new ErrorType(this.getLine(), this.getColumn(), "ERROR: Modulus operation between different types");
            ErrorHandler.getInstance().addError(error);
            return error;
        }
    }

    @Override
    public boolean isSimpleType(){
        return true;
    }

    @Override
    public Type unaryMinus() {
        return new IntType(this.getLine(), this.getColumn());
    }

    @Override
    public int numberOfBytes(){
        return 1;
    }

    @Override
    public boolean mustBeSubtype(Type type){
        return true;
    }

    @Override
    public char suffix() {
        return 'b';
    }

    @Override
    public boolean promotesTo(Type returnType){
        if(returnType instanceof CharType){
            return true;
        }
        return false;
    }
}
