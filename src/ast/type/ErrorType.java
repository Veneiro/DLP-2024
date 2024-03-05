package ast.type;

import ast.ASTAbstractNode;

public class ErrorType extends ASTAbstractNode implements Type {

    public String error_message;

    public ErrorType(int line, int column, String error_message) {
        super(line, column);
        this.error_message = error_message;
    }

    @Override
    public String toString() {
        return String.format("ERROR: %s in line %i and column %i",
                this.error_message, this.getLine(), this.getColumn());
    }
}
