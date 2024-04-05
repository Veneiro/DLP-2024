package ast.type;

import ast.ASTAbstractNode;
import ast.errorhandler.ErrorHandler;
import ast.program.VarDefinition;
import ast.visitor.Visitor;

import java.util.List;

public class FunctionType extends AbstractType {
    public List<VarDefinition> definitions;
    public Type return_type;

    public FunctionType(int line, int column, List<VarDefinition> definitions, Type returnType) {
        super(line, column);
        this.definitions = definitions;
        this.return_type = returnType;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
