package ast.type;

import ast.ASTAbstractNode;
import ast.program.VarDefinition;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends ASTAbstractNode implements Type {
    public List<VarDefinition> definitions;
    public Type returnType;

    public FunctionType(int line, int column, List<VarDefinition> definitions, Type returnType) {
        super(line, column);
        this.definitions = definitions;
        this.returnType = returnType;
    }
}
