package ast.statement;

import ast.ASTAbstractNode;
import ast.expression.Expression;

public class Asignment extends ASTAbstractNode implements Statement {
    public Expression assignTo;
    public Expression toAssign;

    public Asignment(int line, int column, Expression assignTo, Expression toAssign) {
        super(line, column);
        this.assignTo = assignTo;
        this.toAssign = toAssign;
    }
}
