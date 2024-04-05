package ast.expression;

import ast.type.Type;
import ast.visitor.Visitor;

public class Cast extends AbstractExpression {
    public Type castType;
    public Expression toCast;

    public Cast(int line, int column, Type castType, Expression toCast) {
        super(line, column);
        this.castType = castType;
        this.toCast = toCast;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type getType() {
        return castType;
    }

    @Override
    public void setType(Type type) {
        this.castType = type;
    }
}
