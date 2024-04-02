package ast.visitor;

import ast.errorhandler.ErrorHandler;
import ast.expression.*;
import ast.program.Definition;
import ast.program.FuncDefinition;
import ast.program.VarDefinition;
import ast.semantic.SymbolTable;
import ast.statement.Statement;
import ast.type.ErrorType;

public class IdentificationVisitor<TP,TR> extends AbstractVisitor<TP,TR> {

    SymbolTable table = new SymbolTable();

    @Override
    public TR visit(VarDefinition varDefinition, TP param) {
        varDefinition.type.accept(this, null);
        if (!table.insert(varDefinition)) {
            ErrorType error = new ErrorType(
                    varDefinition.getLine(),
                    varDefinition.getColumn(),
                    String.format("Repeated variable definition for '%s'", varDefinition.getVar_name())
            );
            ErrorHandler.getInstance().addError(error);
        }
        return null;
    }
    @Override
    public TR visit(Variable variable, TP param) {
        Definition def = table.find(variable.name);
        if(def == null){
            ErrorType error = new ErrorType(
                    variable.getLine(),
                    variable.getColumn(),
                    String.format("Variable '%s' not previously defined", variable.name)
            );
            ErrorHandler.getInstance().addError(error);
            variable.setDefinition(new VarDefinition(0,0,"error", error));
        }
        else {
            variable.setDefinition(def);
        }
        return null;
    }

    @Override
    public TR visit(FuncDefinition funcDefinition, TP param){
        if (!table.insert(funcDefinition)) {
            ErrorType error = new ErrorType(
                    funcDefinition.getLine(),
                    funcDefinition.getColumn(),
                    String.format("Repeated function definition for '%s'", funcDefinition.getVar_name()));
            ErrorHandler.getInstance().addError(error);
        }
        table.set();
        funcDefinition.getType().accept(this, null);
        funcDefinition.statements.forEach(s -> s.accept(this, null));
        table.reset();
        return null;
    }
}
