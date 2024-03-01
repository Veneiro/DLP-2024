package ast.type;

import ast.ASTAbstractNode;
import ast.program.VarDefinition;

import java.util.ArrayList;

public class FunctionType extends ASTAbstractNode implements Type {
    public ArrayList<VarDefinition> definitions;
    public Type returnType;

    public FunctionType(int line, int column, ArrayList<VarDefinition> definitions, Type returnType) {
        super(line, column);
        this.definitions = definitions;
        this.returnType = returnType;
    }
}
