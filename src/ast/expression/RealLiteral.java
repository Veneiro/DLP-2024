package ast.expression;

import ast.ASTAbstractNode;
import ast.visitor.Visitor;

public class RealLiteral extends AbstractExpression {
    private double value;

    public RealLiteral(int line, int column, double value) {
        super(line, column);
        this.value = value;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}
