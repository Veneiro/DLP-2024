package ast.program;

import ast.type.Type;
import ast.visitor.Visitor;

import java.util.Objects;

public class Field extends AbstractDefinition {
    public int offset;

    public Field(int line, int column, String name, Type fieldType) {
        super(line, column, fieldType, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return Objects.equals(getName(), field.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    public int getOffset() {
        return offset;
    }
    public void setOffset(int offset) {
        this.offset = offset;
    }
}
