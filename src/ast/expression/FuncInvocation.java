package ast.expression;

import ast.ASTAbstractNode;

import java.util.List;

public class FuncInvocation extends ASTAbstractNode implements Expression {
    public List<Expression> expressions;
    public Variable variable;

    public FuncInvocation(int line, int column, Variable funcVar, List<Expression> expressions) {
        super(line, column);
        this.expressions = expressions;
        this.variable = funcVar;
    }
}
