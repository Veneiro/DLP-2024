package ast.expression;

import ast.ASTAbstractNode;

public class RealLiteral extends ASTAbstractNode implements Expression {
    private double value;

    public RealLiteral(int line, int column, double value) {
        super(line, column);
        this.value = value;
    }
}
