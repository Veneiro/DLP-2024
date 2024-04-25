package ast.codegeneration;

import ast.expression.CharLiteral;
import ast.expression.IntLiteral;
import ast.expression.RealLiteral;
import ast.expression.Variable;
import ast.type.IntType;
import ast.visitor.AbstractVisitor;

public class ValueCGVisitor<TP,TR> extends AbstractVisitor<TP,TR> {

    private CodeGenerator codeGenerator;
    private AddressCGVisitor<TP,TR> addressCGVisitor

    public ValueCGVisitor(CodeGenerator codeGenerator, AddressCGVisitor<TP,TR> addressCGVisitor){
        this.codeGenerator = codeGenerator;
        this.addressCGVisitor = addressCGVisitor;
    }

    /**
     * value[[IntLiteral: expression -> INT_LITERAL]]=
     *      <pushi> INT_LITERAL
     */

    public TR visit(IntLiteral intLiteral, TP param){
        codeGenerator.push(intLiteral.getType(), intLiteral.getValue());
        return null;
    }

    /**
     * value[[CharLiteral: expression -> CHAR_LITERAL]]=
     *      <pushb> (int)CHAR_LITERAL
     */
    public TR visit(CharLiteral charLiteral, TP param){
        codeGenerator.push(charLiteral.getType(), charLiteral.getValue());
        return null;
    }

    /**
     * value[[RealLiteral: expression -> REAL_LITERAL]]=
     *      <pushf> REAL_LITERAL
     */
    public TR visit(RealLiteral realLiteral, TP param){
        codeGenerator.pushf(realLiteral.getType(), realLiteral.getValue());
        return null;
    }

    /**
     * value[[Variable: expression -> ID]]=
     *     address[[expression]]
     *     <load> expression.type.suffix()
     */
    public TR visit(Variable variable, TP param){
        variable.varDefinition.accept(addressCGVisitor, null);
        codeGenerator.load(variable.getType());
        return null;
    }

    /**
     * value[[Arithmetic: expression1 -> expression2 (+|-|*|/|%) expression3]]=
     *      value[[expression2]]
     *      expression2.type.convertTo(expression1.type)
     *      value[[expression3]]
     *      expression3.type.convertTo(expression1.type)
     *      switch(){
     *          case '+':
     *              <add> expression1.type.suffix()
     *              break;
     *          case '-':
     *              <sub> expression1.type.suffix()
     *              break;
     *          case '*':
     *               <mul> expression1.type.suffix()
     *               break;
     *          case '/':
     *               <div> expression1.type.suffix()
     *               break;
     *          case '%':
     *              <modi> expression1.type.suffix()
     *              break;
     *      }
     */

    /**
     *  value[[Comparison: expression1 -> expression2 expression3]]=
     *      Type superType = expression2.type.superType(expression1.type)
     *      value[[expression2]]
     *      expression2.type.convertTo(superType)
     *      value[[expression3]]
     *      expression3.type.convertTo(expression1.type)
     *      switch(){
     *          case '==':
     *              <eqi> expression1.type.suffix()
     *              break;
     *          case '<':
     *              <lti> expression1.type.suffix()
     *              break;
     *          case '>':
     *              <gti> expression1.type.suffix()
     *              break;
     *          case '<=':
     *              <lei> expression1.type.suffix()
     *              break;
     *          case '>=':
     *              <gei> expression1.type.suffix()
     *              break;
     *          default: assert false;
     */

    /**
     *  value[[Logical: expression1 -> expression2 expression3]]=
     *      value[[expression2]]
     *      expression2.type.convertTo(expression1.type)
     *      value[[expression3]]
     *      expression3.type.convertTo(expression1.type)
     *      switch(){
     *          case '&&':
     *              <and> expression1.type.suffix()
     *              break;
     *          case '||':
     *              <or> expression1.type.suffix()
     *              break;
     *          default: assert false;
     */

    /**
     *  value[[Cast: expression1 -> type expression2]]=
     *          value[[expression2]]
     *          expression2.type.convertTo(type)
     */

    /**
     *  value[[Indexing: expression1 -> expression2 expression3
     *  address[[expression1]]
     *  <load> expression1.type.suffix()
     */

     /**
     *  value[[FieldAccess: expression1 -> expression2 ID
     *  address[[expression1]]
     *  <load> expression1.type.suffix()
     */
}
