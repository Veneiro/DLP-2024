package ast.statement;

import ast.ASTAbstractNode;
import ast.expression.Expression;
import ast.visitor.Visitor;

import java.util.List;

public class IfElse extends ASTAbstractNode implements Statement {
    public List<Statement> if_statement;
    public List<Statement> else_statement;
    public Expression expr;

    public IfElse(int line, int column, List<Statement> ifStat, List<Statement> elseStat, Expression expr) {
        super(line, column);
        this.if_statement = ifStat;
        this.else_statement = elseStat;
        this.expr = expr;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
