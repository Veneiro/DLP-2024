package ast.expression;

import ast.ASTAbstractNode;

public class Comparision extends ASTAbstractNode implements Expression {
    public String operator;
    public Expression firstCompare;
    public Expression secondCompare;

    public Comparision(int line, int column, String operator, Expression firstCompare, Expression secondCompare) {
        super(line, column);
        this.operator = operator;
        this.firstCompare = firstCompare;
        this.secondCompare = secondCompare;
    }
}
