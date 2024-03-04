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

    public static Expression arithmeticFactory(int line, int column, Expression exp1, String operator, Expression exp2){
        if(operator.equals("%")){
            return new Modulus(line, column, exp1, exp2);
        }
        return new Arithmetic(line, column, exp1, operator, exp2);
    }
}
