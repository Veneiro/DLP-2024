package ast.expression;

import ast.ASTAbstractNode;
import ast.visitor.Visitor;

public class UnaryMinus extends AbstractExpression {
    public Expression number;

    public UnaryMinus(int line, int column, Expression num) {
        super(line, column);
        this.number = num;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
