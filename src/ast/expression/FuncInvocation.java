package ast.expression;

import ast.ASTAbstractNode;
import ast.visitor.Visitor;

import java.util.List;

public class FuncInvocation extends AbstractExpression {
    public List<Expression> expressions;
    public Variable variable;

    public FuncInvocation(int line, int column, Variable funcVar, List<Expression> expressions) {
        super(line, column);
        this.expressions = expressions;
        this.variable = funcVar;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
