package ast.codegeneration;

import ast.expression.*;
import ast.type.FunctionType;
import ast.type.Type;
import ast.visitor.AbstractVisitor;

public class ValueCGVisitor<TP,TR> extends AbstractVisitor<TP,TR> {

    private CodeGenerator codeGenerator;
    private AddressCGVisitor<TP,TR> addressCGVisitor;

    public ValueCGVisitor(CodeGenerator codeGenerator){
        this.codeGenerator = codeGenerator;
    }

    public void setAddressCGVisitor(AddressCGVisitor<TP, TR> address) {
        this.addressCGVisitor = address;
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
        variable.accept(addressCGVisitor, null);
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
    @Override
    public TR visit(Arithmetic arithmetic, TP param){
        arithmetic.first_expression.accept(this, param);
        codeGenerator.convert(arithmetic.getType(), arithmetic.first_expression.getType());
        arithmetic.second_expression.accept(this, param);
        codeGenerator.convert(arithmetic.getType(), arithmetic.second_expression.getType());

        switch(arithmetic.operator){
            case "+":
                codeGenerator.add(arithmetic.getType());
                break;
            case "-":
                codeGenerator.sub(arithmetic.getType());
                break;
            case "*":
                codeGenerator.mul(arithmetic.getType());
                break;
            case "/":
                codeGenerator.div(arithmetic.getType());
                break;
            case "%":
                codeGenerator.mod(arithmetic.getType());
                break;
            default:
                assert false;
        }
        return null;
    }


    /**
     *  value[[Comparison: expression1 -> expression2 expression3]]=
     *      Type superType = expression2.type.superType(expression1.type)
     *      value[[expression2]]
     *      expression2.type.convertTo(superType)
     *      value[[expression3]]
     *      expression3.type.convertTo(superType)
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

    @Override
    public TR visit(Comparision comparision, TP param){
        Type superType = codeGenerator.superType(comparision.first_to_compare.getType(),
                comparision.second_to_compare.getType());

        comparision.first_to_compare.accept(this, param);
        codeGenerator.convert(comparision.first_to_compare.getType(), superType);

        comparision.second_to_compare.accept(this, param);
        codeGenerator.convert(comparision.second_to_compare.getType(), superType);

        switch(comparision.operator){
            case "==":
               codeGenerator.eq(superType);
               break;
            case "<":
               codeGenerator.lt(superType);
               break;
            case ">":
                codeGenerator.gt(superType);
                break;
            case "<=":
                codeGenerator.le(superType);
               break;
            case ">=":
                codeGenerator.ge(superType);
                break;
            default: assert false;
        }
        return null;
    }

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
    @Override
    public TR visit(Logical logical, TP param){
        logical.first_expression.accept(this, param);
        codeGenerator.convert(logical.first_expression.getType(), logical.getType());
        logical.second_expression.accept(this, param);
        codeGenerator.convert(logical.second_expression.getType(), logical.getType());

        switch(logical.operator){
            case "&&":
                codeGenerator.and(logical.getType());
                break;
            case "||":
                codeGenerator.or(logical.getType());
                break;
            default:
                assert false;
        }
        return null;
    }

    /**
     *  value[[Cast: expression1 -> type expression2]]=
     *          value[[expression2]]
     *          expression2.type.convertTo(type)
     */
    @Override
    public TR visit(Cast cast, TP param){
        cast.toCast.accept(this, param);
        codeGenerator.convert(cast.toCast.getType(), cast.castType);
        return null;
    }

    /**
     *  value[[Indexing: expression1 -> expression2 expression3
     *  address[[expression1]]
     *  <load> expression1.type.suffix()
     */
    @Override
    public TR visit(Indexing indexing, TP param){
        indexing.accept(addressCGVisitor, param);
        codeGenerator.load(indexing.getType());
        return null;
    }

     /**
     *  value[[FieldAccess: expression1 -> expression2 ID
     *  address[[expression1]]
     *  <load> expression1.type.suffix()
     */
     @Override
    public TR visit(FieldAccess fieldAccess, TP param){
        fieldAccess.accept(addressCGVisitor, param);
        codeGenerator.load(fieldAccess.getType());
        return null;
    }

    @Override
    public TR visit(FuncInvocation funcInvocation, TP param) {

        funcInvocation.expressions.forEach(e -> e.accept(this, param));
        codeGenerator.call(funcInvocation.variable.name);
        return null;
    }

}
