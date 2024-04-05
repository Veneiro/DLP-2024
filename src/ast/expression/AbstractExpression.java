package ast.expression;

import ast.ASTAbstractNode;
import ast.type.Type;
import ast.visitor.Visitor;

public abstract class AbstractExpression extends ASTAbstractNode implements Expression {

    public boolean lvalue;

    public Type expressionType;

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

    @Override
    public Type getType(){
        return this.expressionType;
    }

    @Override
    public void setType(Type type){
        this.expressionType = type;
    }
}
