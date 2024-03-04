package ast.type;

import ast.ASTAbstractNode;

public class VoidType extends ASTAbstractNode implements Type {
    private static VoidType instance = null;

    public VoidType(int line, int column) {
        super(line, column);
    }

    public static VoidType getInstance() {
        if(instance == null) {
            instance = new VoidType(0,0);
        }

        return instance;
    }
}
