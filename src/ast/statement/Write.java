package ast.statement;

import ast.ASTAbstractNode;
import ast.expression.Expression;

import java.util.ArrayList;

public class Write extends ASTAbstractNode implements Statement {
    public ArrayList<Expression> toWrite;

    public Write(int line, int column, ArrayList<Expression> toWrite) {
        super(line, column);
        this.toWrite = toWrite;
    }
}
