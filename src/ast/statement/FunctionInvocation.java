package ast.statement;

import ast.ASTAbstractNode;
import ast.expression.Expression;
import ast.expression.Variable;
import ast.visitor.Visitor;

import java.util.List;

public class FunctionInvocation extends ASTAbstractNode implements Statement {
    public List<Expression> expressions;
    public Variable variable;

    public FunctionInvocation(int line, int column, Variable funcVar, List<Expression> funcExpr) {
        super(line, column);
        this.expressions = funcExpr;
        this.variable = funcVar;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
