package ast.program;

import ast.ASTAbstractNode;
import ast.statement.Statement;
import ast.type.FunctionType;

import java.util.ArrayList;
import java.util.List;

public class FuncDefinition extends ASTAbstractNode implements Definition {
    public List<Statement> statements;
    private String name;

    private FunctionType function_type;

    @Override
    public String getName() {
        return name;
    }

    public FuncDefinition(int line, int column, List<Statement> statements, String name, FunctionType function_type) {
        super(line, column);
        this.statements = statements;
        this.name = name;
        this.function_type = function_type;
    }
}
