package ast.program;

import ast.ASTAbstractNode;
import ast.statement.Statement;

import java.util.ArrayList;
import java.util.List;

public class FuncDefinition extends ASTAbstractNode implements Definition {
    public List<Statement> statements;
    private String name;
    @Override
    public String getName() {
        return name;
    }

    public FuncDefinition(int line, int column, List<Statement> statements, String name) {
        super(line, column);
        this.statements = statements;
        this.name = name;
    }
}
