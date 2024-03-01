package ast.expression;

import ast.ASTAbstractNode;

public class Arithmetic extends ASTAbstractNode implements Expression {
    public String operator;
    public Expression firstExp;
    public Expression secondExp;

    public Arithmetic(int line, int column, Expression firstExp, String operator, Expression secondExp) {
        super(line, column);
        this.operator = operator;
        this.firstExp = firstExp;
        this.secondExp = secondExp;
    }
}
