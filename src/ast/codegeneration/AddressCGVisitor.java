package ast.codegeneration;

import ast.visitor.AbstractVisitor;

public class AddressCGVisitor<TP, TR> extends AbstractVisitor<TP,TR> {

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
