package ast.program;

import ast.ASTAbstractNode;
import ast.statement.Statement;
import ast.type.FunctionType;
import ast.type.Type;
import ast.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FuncDefinition extends ASTAbstractNode implements Definition {
    public List<Statement> statements;
    private String name;
    private int scope;

    private FunctionType function_type;

    @Override
    public String getVar_name() {
        return name;
    }

    @Override
    public int getScope() {
        return this.scope;
    }

    @Override
    public void setScope(int scope) {
        this.scope = scope;
    }

    public FunctionType getType(){
        return function_type;
    }

    public FuncDefinition(int line, int column, List<Statement> statements, String name, FunctionType function_type) {
        super(line, column);
        this.statements = statements;
        this.name = name;
        this.function_type = function_type;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
