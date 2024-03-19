package ast.statement;

import ast.ASTAbstractNode;
import ast.expression.Expression;
import ast.visitor.Visitor;

import java.util.List;

public class While extends ASTAbstractNode implements Statement {
    public List<Statement> while_statement;
    public Expression while_expression;

    public While(int line, int column, List<Statement> whileStat, Expression expr) {
        super(line, column);
        this.while_statement = whileStat;
        this.while_expression = expr;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
