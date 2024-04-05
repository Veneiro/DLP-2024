package ast.type;

import ast.ASTAbstractNode;
import ast.visitor.Visitor;

public abstract class AbstractType extends ASTAbstractNode implements Type {

    public AbstractType(int line, int column) {
        super(line, column);
    }

    @Override
    public Type arithmetic(Type type) {
        if (type instanceof ErrorType){
            return type;
        } else {
            return new ErrorType(this.getLine(), this.getColumn(), "ERROR: Invalid Type for arithmetic operation");
        }
    }

    @Override
    public Type castTo(Type type) {
        if (type instanceof ErrorType){
            return type;
        } else {
            return new ErrorType(this.getLine(), this.getColumn(), "ERROR: Invalid Type for cast operation");
        }
    }

    @Override
    public Type comparison(Type type) {
        if (type instanceof ErrorType){
            return type;
        } else {
            return new ErrorType(this.getLine(), this.getColumn(), "ERROR: Invalid Type for comparison operation");
        }
    }

    @Override
    public Type squareBrackets(Type type) {
        if (type instanceof ErrorType){
            return type;
        } else {
            return new ErrorType(this.getLine(), this.getColumn(), "ERROR: Invalid Type for square brackets operation");
        }
    }

    @Override
    public Type logical(Type type) {
        if (type instanceof ErrorType){
            return type;
        } else {
            return new ErrorType(this.getLine(), this.getColumn(), "ERROR: Invalid Type for logical operation");
        }
    }

    @Override
    public Type modulus(Type type) {
        if (type instanceof ErrorType){
            return type;
        } else {
            return new ErrorType(this.getLine(), this.getColumn(), "ERROR: Invalid Type for modulus operation");
        }
    }

    @Override
    public Type unaryMinus() {
        return new ErrorType(this.getLine(), this.getColumn(), "ERROR: Invalid Type for unary minus operation");
    }

    @Override
    public Type fieldAccess(Type type) {
        if (type instanceof ErrorType){
            return type;
        } else {
            return new ErrorType(this.getLine(), this.getColumn(), "ERROR: Invalid Type for field access operation");
        }
    }
}
