package ast;

import ast.type.ErrorType;
import ast.visitor.Visitor;

public abstract class ASTAbstractNode implements ASTNode {
    private int line;
    private int column;

    public ASTAbstractNode(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public int getLine(){
        return this.line;
    }

    public int getColumn(){
        return this.column;
    }

    //@Override
    //public <TP,TR> TR accept(Visitor visitor, TP param){
    //    throw new RuntimeException("accept en ASTAbstractNode no se puede llamar");
    //}
}
