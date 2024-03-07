package ast.program;

import ast.ASTAbstractNode;
import ast.type.Type;

public class VarDefinition extends ASTAbstractNode implements Definition {


    public Type type;
    public String var_name;

    public VarDefinition(int line, int column, String name, Type type) {
        super(line, column);
        this.type = type;
        this.var_name = name;
    }

    @Override
    public String getVar_name() {
        return null;
    }
}
