package ast.expression;

import ast.ASTAbstractNode;
import ast.program.Definition;
import ast.visitor.Visitor;

public class Variable extends AbstractExpression {
    public String name;
    public Definition varDefinition;

    public Variable(int line, int column, String name){
        super(line, column);
        this.name = name;
    }

    public void setDefinition(Definition definition){
        this.varDefinition = definition;
    }

    public Definition getDefinition(){
        return this.varDefinition;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
