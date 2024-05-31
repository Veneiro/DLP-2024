package ast.statement;

import ast.ASTAbstractNode;
import ast.program.FuncDefinition;

public abstract class AbstractStatement extends ASTAbstractNode implements Statement {
    private FuncDefinition definition;

    public AbstractStatement(int line, int column) {
        super(line, column);
    }

    @Override
    public void setDefinition(FuncDefinition definition){
        this.definition = definition;
    }

    public FuncDefinition getDefinition(){
        return this.definition;
    }
}
