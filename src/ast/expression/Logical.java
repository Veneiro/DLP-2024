package ast.expression;

import ast.ASTAbstractNode;
import ast.visitor.Visitor;

public class Logical extends AbstractExpression {
    public String operator;
    public Expression first_expression;
    public Expression second_expression;

    public Logical(int line, int column, Expression firstExp, String operator, Expression secondExp) {
        super(line, column);
        this.operator = operator;
        this.first_expression = firstExp;
        this.second_expression = secondExp;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

}
