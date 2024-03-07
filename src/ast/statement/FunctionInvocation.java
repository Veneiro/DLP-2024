package ast.statement;

import ast.ASTAbstractNode;
import ast.expression.Expression;
import ast.expression.Variable;

import java.util.List;

public class FunctionInvocation extends ASTAbstractNode implements Statement, Expression {
    public List<Expression> expressions;
    public Variable variable;

    public FunctionInvocation(int line, int column, Variable funcVar, List<Expression> funcExpr) {
        super(line, column);
        this.expressions = funcExpr;
        this.variable = funcVar;
    }
}
