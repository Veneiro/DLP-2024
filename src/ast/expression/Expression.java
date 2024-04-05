package ast.expression;

import ast.ASTNode;
import ast.type.Type;

public interface Expression extends ASTNode {

    public void setLValue(boolean v);

    public boolean getLValue();

    public Type getType();

    public void setType(Type type);
}
