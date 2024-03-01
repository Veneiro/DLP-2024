package ast.expression;

import ast.ASTAbstractNode;

public class CharLiteral extends ASTAbstractNode implements Expression {
    private char value;

    public CharLiteral(int line, int column, char value) {
        super(line, column);
        this.value = value;
    }
}
