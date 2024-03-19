package ast.expression;

import ast.ASTAbstractNode;
import ast.visitor.Visitor;

public abstract class AbstractExpression extends ASTAbstractNode implements Expression {

    public boolean lvalue;

    public AbstractExpression(int line, int column) {
        super(line, column);
    }

    @Override
    public void setLValue(boolean v){
        this.lvalue = v;
    }

    @Override
    public boolean getLValue(){
        return this.lvalue;
    }
}
