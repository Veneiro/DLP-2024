package ast.type;

import ast.ASTAbstractNode;

public class ArrayType extends ASTAbstractNode implements Type {
    private int size;
    private Type type;

    public ArrayType(int line, int column, int size, Type type) {
        super(line, column);
        this.size = size;
        this.type = type;
    }
}
