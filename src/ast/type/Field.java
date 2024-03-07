package ast.type;

import java.util.Objects;

public class Field {
    public Type field_type;
    public String name;

    public Field(String name, Type fieldType) {
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
}
