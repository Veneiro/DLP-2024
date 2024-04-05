package ast.expression;

import ast.ASTAbstractNode;
import ast.type.CharType;
import ast.type.Type;
import ast.visitor.Visitor;

public class CharLiteral extends AbstractExpression {
    private char value;

    public CharLiteral(int line, int column, char value) {
        super(line, column);
        this.value = value;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
