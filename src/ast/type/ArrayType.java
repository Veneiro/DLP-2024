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
            Type final_type = previousType;
            while(final_type instanceof ArrayType) {
                final_type = ((ArrayType) final_type).type;
            }
            Type new_type = new ArrayType(line, column, size, final_type);
            ArrayType parent_type = (ArrayType) previousType;
            while( parent_type.type instanceof ArrayType) {
                parent_type = (ArrayType) parent_type.type;
            }

            parent_type.type = new_type;
            return (ArrayType) previousType;

        }
        return new ArrayType(line, column, size, previousType);
    }
}
