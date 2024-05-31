package ast.statement;

import ast.ASTAbstractNode;
import ast.expression.Expression;
import ast.visitor.Visitor;

public class Read extends AbstractStatement {
    public Expression to_read;

    public Read(int line, int column, Expression readExpr) {
        super(line, column);
        this.to_read = readExpr;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
