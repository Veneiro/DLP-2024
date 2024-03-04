package ast.statement;

import ast.ASTAbstractNode;
import ast.expression.Expression;

import java.util.ArrayList;
import java.util.List;

public class Write extends ASTAbstractNode implements Statement {
    public List<Expression> toWrite;

    public Write(int line, int column, List<Expression> toWrite) {
        super(line, column);
        this.toWrite = toWrite;
    }
}
