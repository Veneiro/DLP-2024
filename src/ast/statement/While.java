package ast.statement;

import ast.ASTAbstractNode;
import ast.expression.Expression;

import java.util.List;

public class While extends ASTAbstractNode implements Statement, Expression {
    public List<Statement> while_statement;
    public Expression while_expression;

    public While(int line, int column, List<Statement> whileStat, Expression expr) {
        super(line, column);
        this.while_statement = whileStat;
        this.while_expression = expr;
    }
}
