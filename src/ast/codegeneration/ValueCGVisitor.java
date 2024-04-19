package ast.codegeneration;

public class ValueCGVisitor {

    /**
     * value[[IntLiteral: expression -> INT_LITERAL]]=
     *      <pushi> INT_LITERAL
     *
     * value[[CharLiteral: expression -> CHAR_LITERAL]]=
     *      <pushb> (int)CHAR_LITERAL
     *
     * value[[RealLiteral: expression -> REAL_LITERAL]]=
     *      <pushf> REAL_LITERAL
     *
     * value[[Variable: expression -> ID]]=
     *     address[[expression]]
     *     <load> expression.type.suffix()
     *
     * value[[Arithmetic: expression1 -> expression2 (+|-|*|/|%) expression3]]=
     *      value[[expression2]]
     *      expression2.type.convertTo(expression1.type)
     *      value[[expression3]]
     *      expression3.type.convertTo(expression1.type)
     *      switch(){
     *          case '+':
     *              <add> expression1.type.suffix()
     *              break;
 *              case '-':
     *              <sub> expression1.type.suffix()
 *                  break;
*               case '*':
     *               <mul> expression1.type.suffix()
*                    break;
*               case '/':
     *               <div> expression1.type.suffix()
     *               break;
     *          case '%':
     *              <modi> expression1.type.suffix()
     *              break;
     *      }
     *
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
     *
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
     *
     *  value[[Cast: expression1 -> type expression2]]=
     *          value[[expression2]]
     *          expression2.type.convertTo(type)
     */
}
