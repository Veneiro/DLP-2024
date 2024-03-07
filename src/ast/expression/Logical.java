package ast.expression;

import ast.ASTAbstractNode;

public class Logical extends ASTAbstractNode implements Expression {
    public String operator;
    public Expression first_expression;
    public Expression second_expression;

    public Logical(int line, int column, Expression firstExp, String operator, Expression secondExp) {
        super(line, column);
        this.operator = operator;
        this.first_expression = firstExp;
        this.second_expression = secondExp;
    }
}
