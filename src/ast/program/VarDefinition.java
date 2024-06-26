package ast.program;

import ast.ASTAbstractNode;
import ast.type.Type;
import ast.visitor.Visitor;

public class VarDefinition extends AbstractDefinition {

    public int offset;

    public VarDefinition(int line, int column, String name, Type type) {
        super(line, column, type, name);
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String toString(){
        return String.format("\t%s %s",this.getType(),this.getName());
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
