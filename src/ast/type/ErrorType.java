package ast.type;

import ast.ASTAbstractNode;
import ast.visitor.Visitor;

public class ErrorType extends ASTAbstractNode implements Type {

    public String error_message;

    public ErrorType(int line, int column, String error_message) {
        super(line, column);
        this.error_message = error_message;
    }

    @Override
    public String toString() {
        return String.format("ERROR: %s | line %d and column %d",
                this.error_message, this.getLine(), this.getColumn());
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
