package ast.type;

import ast.ASTAbstractNode;
import ast.visitor.Visitor;

import java.util.List;

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
    public Type fieldAccess(String name) {
        return new ErrorType(this.getLine(), this.getColumn(), "ERROR: Invalid Type for field access operation");
    }

    @Override
    public Type parenthesis(List<Type> types) {
        return new ErrorType(this.getLine(), this.getColumn(), "ERROR: Invalid Type for parenthesis operation");
    }

    @Override
    public int numberOfBytes() {
        return 0;
    }

    @Override
    public boolean mustBeSubtype(Type param) {
        return false;
    }

    @Override
    public char suffix() {
        assert false;
        return ' ';
    }
    @Override
    public boolean isSimpleType(){
        return false;
    }
    @Override
    public boolean promotesTo(Type returnType){
        return false;
    }

    @Override
    public boolean isLogical(){
        return false;
    }
}
