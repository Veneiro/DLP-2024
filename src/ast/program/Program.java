package ast.program;

import ast.ASTAbstractNode;

import java.util.ArrayList;
import java.util.List;

public class Program extends ASTAbstractNode {
    public List<Definition> definitions;

    public Program(int line, int column, List<Definition> definitions) {
        super(line, column);
        this.definitions = definitions;
    }
}
