package ast.statement;

import ast.ASTAbstractNode;
import ast.expression.Expression;
import ast.visitor.Visitor;

public class Return extends AbstractStatement {
    public Expression to_return;

    public Return(int line, int column, Expression retExpr) {
        super(line, column);
        this.to_return = retExpr;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
