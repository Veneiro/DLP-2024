package ast.statement;

import ast.ASTAbstractNode;
import ast.expression.Expression;

public class Return extends ASTAbstractNode implements Statement {
    public Expression retExpr;

    public Return(int line, int column, Expression retExpr) {
        super(line, column);
        this.retExpr = retExpr;
    }
}
