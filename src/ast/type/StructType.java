package ast.type;

import ast.ASTAbstractNode;

import java.util.ArrayList;
import java.util.List;

public class StructType extends ASTAbstractNode implements Type {
    public List<Field> fields;

    public StructType(int line, int column, List<Field> fields) {
        super(line, column);
        this.fields = fields;
    }
}
