package ast.expression;

import ast.ASTAbstractNode;
import ast.visitor.Visitor;

public class IntLiteral extends AbstractExpression {
    private int value;

    public IntLiteral(int line, int column, int value) {
        super(line, column);
        this.value = value;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}
