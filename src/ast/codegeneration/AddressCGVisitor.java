package ast.codegeneration;

import ast.expression.FieldAccess;
import ast.expression.Indexing;
import ast.expression.Variable;
import ast.program.Field;
import ast.type.ArrayType;
import ast.type.IntType;
import ast.type.StructType;
import ast.visitor.AbstractVisitor;

public class AddressCGVisitor<TP, TR> extends AbstractCGVisitor<TP,TR> {

    CodeGenerator codeGenerator;

    ValueCGVisitor<TP,TR> valueCGVisitor;

    public AddressCGVisitor(CodeGenerator codeGenerator){
        this.codeGenerator = codeGenerator;
    }

    public void setValueCGVisitor(ValueCGVisitor<TP, TR> value) {
        this.valueCGVisitor = value;
    }

    /**
     * address[[Variable: expression -> ID]]=
     * if(expression.definition.scope == 0)
     *      <pusha> expression.definition.offset
     *  else
     *      <push bp>
     *      <pushi> expression.definition.offset
     *      <addi>
     */
    public TR visit(Variable variable, TP param){
        if(variable.varDefinition.getScope() == 0){
            codeGenerator.pusha(variable.getDefinition().getOffset());
        } else {
            codeGenerator.pushbp();
            codeGenerator.push(new IntType(0,0), variable.getDefinition().getOffset());
            codeGenerator.add(new IntType(0,0));
        }
        return null;
    }

    /**
     *  address[[Indexing: expression1 -> expression2 expression3
     *  address[[expression2]]
     *  value[[expression3]]
     *  <pushi > expression1.type.numberOfBytes
     *  <muli>
     *  <addi>
     */
    public TR visit(Indexing indexing, TP param){
        indexing.list.accept(this, null);
        indexing.index.accept(valueCGVisitor, null);
        codeGenerator.push(new IntType(0,0), indexing.getType().numberOfBytes());
        codeGenerator.mul(new IntType(0,0));
        codeGenerator.add(new IntType(0,0));
        return null;
    }


     /**
     *  address[[FieldAccess: expression1 -> expression2 ID]]
     *  address[[expression2]]
     *  <pushi > expression1.type.numberOfBytes
     *  <addi>
     */
     public TR visit(FieldAccess fieldAccess, TP param){
         fieldAccess.toAccess.accept(this, null);

         StructType type = (StructType) fieldAccess.toAccess.getType();
         Field field = type.struct_fields.stream().filter(f -> f.getName().equals(fieldAccess.name)).findFirst().orElseThrow();


         codeGenerator.push(new IntType(0,0), field.offset);
         codeGenerator.add(new IntType(0,0));
         return null;
     }
}
