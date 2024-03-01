package ast.statement;

import ast.ASTAbstractNode;
import ast.expression.Expression;

import java.util.ArrayList;

public class FunctionInvocation extends ASTAbstractNode implements Statement, Expression {
    public ArrayList<Expression> funcExpr;

    public FunctionInvocation(int line, int column, ArrayList<Expression> funcExpr) {
        super(line, column);
        this.funcExpr = funcExpr;
    }
}
