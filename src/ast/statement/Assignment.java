package ast.statement;

import ast.ASTAbstractNode;
import ast.expression.Expression;
import ast.visitor.Visitor;

public class Assignment extends ASTAbstractNode implements Statement {
    public Expression assign_to;
    public Expression to_assign;

    public Assignment(int line, int column, Expression assignTo, Expression toAssign) {
        super(line, column);
        this.assign_to = assignTo;
        this.to_assign = toAssign;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
