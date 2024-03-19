package ast.expression;

import ast.ASTAbstractNode;
import ast.visitor.Visitor;

public class Modulus extends AbstractExpression {
    public String operator = "%";
    public Expression first_expression;
    public Expression second_expression;

    public Modulus(int line, int column, Expression firstExp, Expression secondExp) {
        super(line, column);
        this.first_expression = firstExp;
        this.second_expression = secondExp;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
