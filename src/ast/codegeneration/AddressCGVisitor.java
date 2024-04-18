package ast.codegeneration;

public class AddressCGVisitor {

    /**
     * address[[Variable: expression -> ID]]=
     *
     * if(expression.definition.scope == 0)
     *      <pusha> + expression.definition.offset
     *  else
     *      <push bp>
     *      <pushi> expression.definition.offset
     *      <addi>
     */
}
