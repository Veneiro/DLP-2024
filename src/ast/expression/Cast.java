package ast.expression;

import ast.ASTAbstractNode;
import ast.type.Type;
import ast.visitor.Visitor;

public class Cast extends AbstractExpression {
    public Type cast_type;
    public Expression to_cast;

    public Cast(int line, int column, Type castType, Expression toCast) {
        super(line, column);
        this.cast_type = castType;
        this.to_cast = toCast;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
