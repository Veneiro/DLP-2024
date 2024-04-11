package ast.program;

import ast.ASTAbstractNode;
import ast.type.Type;
import ast.visitor.Visitor;

public class VarDefinition extends AbstractDefinition {

    public Type type;
    public String var_name;
    public int scope;

    public int offset;

    public VarDefinition(int line, int column, String name, Type type) {
        super(line, column, type, name);
        this.type = type;
        this.var_name = name;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
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
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
