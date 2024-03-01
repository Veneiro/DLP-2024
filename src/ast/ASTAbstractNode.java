package ast;

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
}
