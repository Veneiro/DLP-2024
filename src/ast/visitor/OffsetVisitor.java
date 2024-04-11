package ast.visitor;

import ast.expression.FieldAccess;
import ast.expression.Variable;
import ast.program.Definition;
import ast.program.FuncDefinition;
import ast.program.Program;
import ast.program.VarDefinition;
import ast.type.Field;
import ast.type.FunctionType;
import ast.type.StructType;

public class OffsetVisitor<TP,TR> extends AbstractVisitor<TP,TR>{

     /**
     * &param = BP + 4 + Σ( noB(type(params on the right not inlcuding itself)))
     * (P) FunctionDefinition: expression1 -> type expression2
     */
     public TR visit(FunctionType funcType, TP param){
         int offset = 0;
         for(int i = 0; i < funcType.definitions.size(); i++){
             funcType.definitions.get(i).setOffset(offset + 4);
             offset += funcType.definitions.get(i).getType().numberOfBytes();
         }
         return null;
     }

    /**
     * &field = Σ( noB(types(prev fields not including itself)))
     * (P) field: field -> type ID
     * (R) field.offset -> field.type.numberOfBytes(ID)
     */
    public TR visit(StructType struct, TP param){
        int offset = 0;
        for(Field field : struct.struct_fields){
            field.setOffset(offset);
            offset += field.numberOfBytes();
        }
        return null;
    }

    protected int nObGlobal = 0;
    protected int nObLocal = 0;
    /**
     * &global = Σ( noB(type(prev globals not including itself)))
     * &local = BP - Σ( noB(type(prev locals including itself)))
     * (P) VariableDefinition: definition -> type ID*
     */
    public TR visit(VarDefinition varDefinition, TP param){
        if(varDefinition.getScope() == 0){ //Global
            varDefinition.setOffset(nObGlobal);
            nObGlobal += varDefinition.getType().numberOfBytes();
        } else { //Local
            varDefinition.setOffset(nObLocal);
            nObLocal += varDefinition.getType().numberOfBytes();
        }
        return null;
    }

}
