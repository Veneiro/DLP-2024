package ast.expression;

import ast.ASTAbstractNode;
import ast.visitor.Visitor;

public class FieldAccess extends AbstractExpression {
    public String name;
    public Expression toAccess;

    public FieldAccess(int line, int column, String name, Expression toAccess) {
        super(line, column);
        this.name = name;
        this.toAccess = toAccess;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
