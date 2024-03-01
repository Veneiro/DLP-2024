package ast.type;

import ast.ASTAbstractNode;

import java.util.ArrayList;

public class StructType extends ASTAbstractNode implements Type {
    public ArrayList<Field> fields;

    public StructType(int line, int column, ArrayList<Field> fields) {
        super(line, column);
        this.fields = fields;
    }
}
