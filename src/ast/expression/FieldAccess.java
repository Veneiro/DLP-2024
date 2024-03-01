package ast.expression;

import ast.ASTAbstractNode;

public class FieldAccess extends ASTAbstractNode implements Expression {
    public String name;
    public Expression toAccess;

    public FieldAccess(int line, int column, String name, Expression toAccess) {
        super(line, column);
        this.name = name;
        this.toAccess = toAccess;
    }
}
