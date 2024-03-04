package ast.statement;

import ast.ASTAbstractNode;
import ast.expression.Expression;

import java.util.ArrayList;
import java.util.List;

public class FunctionInvocation extends ASTAbstractNode implements Statement, Expression {
    public List<Expression> funcExpr;

    public FunctionInvocation(int line, int column, List<Expression> funcExpr) {
        super(line, column);
        this.funcExpr = funcExpr;
    }
}
