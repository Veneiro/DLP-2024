package ast.expression;

import ast.ASTNode;

public interface Expression extends ASTNode {

    public void setLValue(boolean v);

    public boolean getLValue();
}
