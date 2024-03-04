package ast.statement;

import ast.ASTAbstractNode;
import ast.expression.Expression;

import java.util.ArrayList;
import java.util.List;

public class While extends ASTAbstractNode implements Statement, Expression {
    public List<Statement> whileStat;
    public Expression expr;

    public While(int line, int column, List<Statement> whileStat, Expression expr) {
        super(line, column);
        this.whileStat = whileStat;
        this.expr = expr;
    }
}
