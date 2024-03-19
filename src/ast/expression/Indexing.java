package ast.expression;

import ast.ASTAbstractNode;
import ast.visitor.Visitor;

public class Indexing extends AbstractExpression {
    public Expression list;
    public Expression index;

    public Indexing(int line, int column, Expression list, Expression index) {
        super(line, column);
        this.list = list;
        this.index = index;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
