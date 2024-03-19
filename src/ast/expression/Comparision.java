package ast.expression;

import ast.ASTAbstractNode;
import ast.visitor.Visitor;

public class Comparision extends AbstractExpression {
    public String operator;
    public Expression first_to_compare;
    public Expression second_to_compare;

    public Comparision(int line, int column, String operator, Expression firstCompare, Expression secondCompare) {
        super(line, column);
        this.operator = operator;
        this.first_to_compare = firstCompare;
        this.second_to_compare = secondCompare;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
