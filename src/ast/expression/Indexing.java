package ast.expression;

import ast.ASTAbstractNode;

public class Indexing extends ASTAbstractNode implements Expression {
    public Expression list;
    public Expression index;

    public Indexing(int line, int column, Expression list, Expression index) {
        super(line, column);
        this.list = list;
        this.index = index;
    }
}
