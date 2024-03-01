package ast.expression;

import ast.ASTAbstractNode;

public class Variable extends ASTAbstractNode implements Expression {
    public String name;

    public Variable(int line, int column, String name){
        super(line, column);
        this.name = name;
    }
}
