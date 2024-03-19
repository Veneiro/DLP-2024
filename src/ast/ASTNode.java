package ast;

import ast.expression.Arithmetic;
import ast.visitor.Visitor;

public interface ASTNode {
    int getLine();
    int getColumn();
    public <TP,TR> TR accept(Visitor<TP,TR> visitor, TP param);
}
