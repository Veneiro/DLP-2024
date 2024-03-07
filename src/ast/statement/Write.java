package ast.statement;

import ast.ASTAbstractNode;
import ast.expression.Expression;

import java.util.List;

public class Write extends ASTAbstractNode implements Statement {
    public List<Expression> to_write;

    public Write(int line, int column, List<Expression> toWrite) {
        super(line, column);
        this.to_write = toWrite;
    }
}
