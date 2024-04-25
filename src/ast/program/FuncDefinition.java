package ast.program;

import ast.ASTAbstractNode;
import ast.statement.Statement;
import ast.type.FunctionType;
import ast.type.Type;
import ast.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FuncDefinition extends AbstractDefinition {
    public List<Statement> statements;
    private int scope;

    @Override
    public int getScope() {
        return this.scope;
    }

    @Override
    public void setScope(int scope) {
        this.scope = scope;
    }

    public FuncDefinition(int line, int column, List<Statement> statements, String name, FunctionType function_type) {
        super(line, column, function_type, name);
        this.statements = statements;
    }

    @Override
    public int getOffset() {
        throw new RuntimeException("Los tipos de funcion no tienen offset");
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
