package ast.statement;

import ast.ASTNode;
import ast.program.Definition;
import ast.program.FuncDefinition;

public interface Statement extends ASTNode {
    void setDefinition(FuncDefinition definition);
}
