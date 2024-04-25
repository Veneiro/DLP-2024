package ast.statement;

import ast.ASTAbstractNode;
import ast.expression.Expression;
import ast.visitor.Visitor;

import java.util.List;

public class Write extends ASTAbstractNode implements Statement {
    public Expression toWrite;

    public Write(int line, int column, Expression toWrite) {
        super(line, column);
        this.toWrite = toWrite;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
