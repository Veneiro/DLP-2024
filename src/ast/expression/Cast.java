package ast.expression;

import ast.ASTAbstractNode;
import ast.type.Type;

public class Cast extends ASTAbstractNode implements Expression {
    public Type castType;
    public Expression toCast;

    public Cast(int line, int column, Type castType, Expression toCast) {
        super(line, column);
        this.castType = castType;
        this.toCast = toCast;
    }
}
