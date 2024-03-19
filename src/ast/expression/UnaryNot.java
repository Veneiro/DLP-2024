package ast.expression;

import ast.ASTAbstractNode;
import ast.visitor.Visitor;

public class UnaryNot extends AbstractExpression {
    public Expression to_negate;

    public UnaryNot(int line, int column, Expression expr) {
        super(line, column);
        this.to_negate = expr;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
