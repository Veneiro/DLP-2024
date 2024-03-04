package ast.statement;

import ast.ASTAbstractNode;
import ast.expression.Expression;

public class Assignment extends ASTAbstractNode implements Statement {
    public Expression assignTo;
    public Expression toAssign;

    public Assignment(int line, int column, Expression assignTo, Expression toAssign) {
        super(line, column);
        this.assignTo = assignTo;
        this.toAssign = toAssign;
    }
}
