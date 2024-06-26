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
            ErrorType error = new ErrorType(this.getLine(), this.getColumn(), "Arithmetic operation between different types");
            ErrorHandler.getInstance().addError(error);
            return error;
        }
    }

    @Override
    public Type castTo(Type type) {
        if (this.getClass() == type.getClass()) {
            return this;
        } else if (type instanceof DoubleType) {
            return new DoubleType(this.getLine(), this.getColumn());
        } else if (type instanceof CharType) {
            return new CharType(this.getLine(), this.getColumn());
        } else if (type instanceof ErrorType){
            return type;
        } else {
            ErrorType error = new ErrorType(this.getLine(), this.getColumn(), "Cast operation between different types");
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
            ErrorType error = new ErrorType(this.getLine(), this.getColumn(), "Comparison operation between different types");
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
            ErrorType error = new ErrorType(this.getLine(), this.getColumn(), "Logical operation between different types");
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
            ErrorType error = new ErrorType(this.getLine(), this.getColumn(), "Modulus operation between different types");
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

    @Override
    public char suffix() {
        return 'i';
    }

    @Override
    public boolean isSimpleType(){
        return true;
    }

    @Override
    public boolean promotesTo(Type returnType){
        if(returnType instanceof IntType){
            return true;
        }
        return false;
    }

    @Override
    public boolean isLogical(){
        return true;
    }

    @Override
    public String toString(){
        return "int";
    }
}
