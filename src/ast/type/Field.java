package ast.type;

import ast.ASTAbstractNode;
import ast.visitor.Visitor;

import java.util.Objects;

public class Field extends ASTAbstractNode implements Type {
    public Type field_type;
    public String name;

    public Field(int line, int column, String name, Type fieldType) {
        super(line, column);
        this.name = name;
        this.field_type = fieldType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return Objects.equals(name, field.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
