package ast.statement;

import ast.ASTAbstractNode;
import ast.expression.Expression;

import java.util.ArrayList;
import java.util.List;

public class IfElse extends ASTAbstractNode implements Statement {
    public List<Statement> ifStat;
    public List<Statement> elseStat;
    public Expression expr;

    public IfElse(int line, int column, List<Statement> ifStat, List<Statement> elseStat, Expression expr) {
        super(line, column);
        this.ifStat = ifStat;
        this.elseStat = elseStat;
        this.expr = expr;
    }
}
