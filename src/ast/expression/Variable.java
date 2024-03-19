package ast.expression;

import ast.ASTAbstractNode;
import ast.visitor.Visitor;

public class Variable extends AbstractExpression {
    public String name;

    public Variable(int line, int column, String name){
        super(line, column);
        this.name = name;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
