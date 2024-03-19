package ast.visitor;

import ast.expression.*;
import ast.program.FuncDefinition;
import ast.program.VarDefinition;
public class IdentificationVisitor<TP,TR> extends AbstractVisitor<TP,TR> {
    @Override
    public TR visit(VarDefinition varDefinition, TP param) {
        return null;
    }
    @Override
    public TR visit(Variable variable, TP param) {
        return null;
    }

    @Override
    public TR visit(FuncDefinition funcDefinition, TP param){
        return null;
    }
}
