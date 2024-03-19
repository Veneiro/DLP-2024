package ast.type;

import ast.ASTAbstractNode;
import ast.visitor.Visitor;

import java.util.List;

public class StructType extends ASTAbstractNode implements Type {
    public List<Field> struct_fields;

    public StructType(int line, int column, List<Field> fields) {
        super(line, column);
        this.struct_fields = fields;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
