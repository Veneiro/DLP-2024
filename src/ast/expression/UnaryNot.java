package ast.expression;

import ast.ASTAbstractNode;

public class UnaryNot extends ASTAbstractNode implements Expression {
    public Expression expr;

    public UnaryNot(int line, int column, Expression expr) {
        super(line, column);
        this.expr = expr;
    }
}
