package ast.type;

public class Field {
    public Type fieldType;
    public String name;

    public Field(String name, Type fieldType) {
        this.fieldType = fieldType;
    }
}
