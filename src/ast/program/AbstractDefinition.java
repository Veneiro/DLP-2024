package ast.program;

import ast.ASTAbstractNode;
import ast.type.Type;

public abstract class AbstractDefinition extends ASTAbstractNode implements Definition {
    private final Type type;
    private final String name;
    protected int scope;

    public AbstractDefinition(int line, int column, Type type, String name) {
        super(line, column);
        this.type = type;
        this.name = name;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getScope() {
        return this.scope;
    }

    @Override
    public void setScope(int scope) {
        this.scope = scope;
    }

    @Override
    public void setDefinition(FuncDefinition definition) {

    }
}
