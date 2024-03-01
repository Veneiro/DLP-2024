package ast.statement;

import ast.ASTAbstractNode;
import ast.expression.Expression;

public class Read extends ASTAbstractNode implements Statement {
    public Expression readExpr;

    public Read(int line, int column, Expression readExpr) {
        super(line, column);
        this.readExpr = readExpr;
    }
}
