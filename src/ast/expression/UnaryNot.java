package ast.expression;

import ast.ASTAbstractNode;

public class UnaryNot extends ASTAbstractNode implements Expression {
    public Expression to_negate;

    public UnaryNot(int line, int column, Expression expr) {
        super(line, column);
        this.to_negate = expr;
    }
}
