package ast.statement;

import ast.ASTAbstractNode;
import ast.expression.Expression;

import java.util.ArrayList;

public class While extends ASTAbstractNode implements Statement, Expression {
    public ArrayList<Statement> whileStat;
    public Expression expr;

    public While(int line, int column, ArrayList<Statement> whileStat, Expression expr) {
        super(line, column);
        this.whileStat = whileStat;
        this.expr = expr;
    }
}
