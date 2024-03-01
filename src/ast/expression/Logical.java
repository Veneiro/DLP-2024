package ast.expression;

import ast.ASTAbstractNode;

public class Logical extends ASTAbstractNode implements Expression {
    public String operator;
    public Expression firstExp;
    public Expression secondExp;

    public Logical(int line, int column, Expression firstExp, String operator, Expression secondExp) {
        super(line, column);
        this.operator = operator;
        this.firstExp = firstExp;
        this.secondExp = secondExp;
    }
}
