package ast.expression;

import ast.ASTAbstractNode;
import ast.type.Type;

public class Cast extends ASTAbstractNode implements Expression {
    public Type cast_type;
    public Expression to_cast;

    public Cast(int line, int column, Type castType, Expression toCast) {
        super(line, column);
        this.cast_type = castType;
        this.to_cast = toCast;
    }
}
