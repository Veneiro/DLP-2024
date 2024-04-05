package ast.expression;

import ast.ASTAbstractNode;
import ast.type.Type;
import ast.visitor.Visitor;

public class Arithmetic extends AbstractExpression {
    public String operator;
    public Expression first_expression;
    public Expression second_expression;

    public Arithmetic(int line, int column, Expression firstExp, String operator, Expression secondExp) {
        super(line, column);
        this.operator = operator;
        this.first_expression = firstExp;
        this.second_expression = secondExp;
    }

    public static Expression arithmeticFactory(int line, int column, Expression exp1, String operator, Expression exp2){
        if(operator.equals("%")){
            return new Modulus(line, column, exp1, exp2);
        }
        return new Arithmetic(line, column, exp1, operator, exp2);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
