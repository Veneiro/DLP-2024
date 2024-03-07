package ast.expression;

import ast.ASTAbstractNode;

public class UnaryMinus extends ASTAbstractNode implements Expression {
    public Expression number;

    public UnaryMinus(int line, int column, Expression num) {
        super(line, column);
        this.number = num;
    }
}
