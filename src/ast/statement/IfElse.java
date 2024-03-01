package ast.statement;

import ast.ASTAbstractNode;
import ast.expression.Expression;

import java.util.ArrayList;

public class IfElse extends ASTAbstractNode implements Statement {
    public ArrayList<Statement> ifStat;
    public ArrayList<Statement> elseStat;
    public Expression expr;

    public IfElse(int line, int column, ArrayList<Statement> ifStat, ArrayList<Statement> elseStat, Expression expr) {
        super(line, column);
        this.ifStat = ifStat;
        this.elseStat = elseStat;
        this.expr = expr;
    }
}
