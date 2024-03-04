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

    public static ArrayType createArray(int line, int column, int size, Type previousType){
        if (previousType instanceof ArrayType){
            //Loop go to the end and connect objects
        }
        return new ArrayType(line, column, size, previousType);
    }
}
