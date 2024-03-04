package ast.expression;

import ast.ASTAbstractNode;

public class Modulus extends ASTAbstractNode implements Expression {
    public String operator = "%";
    public Expression firstExp;
    public Expression secondExp;

    public Modulus(int line, int column, Expression firstExp, Expression secondExp) {
        super(line, column);
        this.firstExp = firstExp;
        this.secondExp = secondExp;
    }
}
