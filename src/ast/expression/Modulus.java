package ast.expression;

import ast.ASTAbstractNode;

public class Modulus extends ASTAbstractNode implements Expression {
    public String operator = "%";
    public Expression first_expression;
    public Expression second_expression;

    public Modulus(int line, int column, Expression firstExp, Expression secondExp) {
        super(line, column);
        this.first_expression = firstExp;
        this.second_expression = secondExp;
    }
}
