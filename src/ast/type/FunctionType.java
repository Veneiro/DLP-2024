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

    @Override
    public Type parenthesis(List<Type> types) {
        if (types.size() != definitions.size()) {
            ErrorType error = new ErrorType(this.getLine(), this.getColumn(), "ERROR: Number of parameters does not match");
            ErrorHandler.getInstance().addError(error);
            return error;
        }
        for (int i = 0; i < types.size(); i++) {
            if (!types.get(i).equals(definitions.get(i).getType())) {
                ErrorType error = new ErrorType(this.getLine(), this.getColumn(), "ERROR: Parameter type does not match");
                ErrorHandler.getInstance().addError(error);
                return error;
            }
        }
        return return_type;
    }
}
