package ast.program;

import ast.ASTAbstractNode;
import ast.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Program extends ASTAbstractNode {
    public List<Definition> definitions;

    public Program(int line, int column, List<Definition> definitions, FuncDefinition main) {
        super(line, column);
        this.definitions = definitions;
        definitions.add(main);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
