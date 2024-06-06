package ast.visitor;

import ast.errorhandler.ErrorHandler;
import ast.expression.*;
import ast.program.FuncDefinition;
import ast.statement.*;
import ast.type.*;

import java.util.stream.Collectors;

public class TypeCheckingVisitor<TP,TR> extends AbstractVisitor<TP,TR> {

    /**
     * EXPRESSIONS
     * (P) FunctionDefinition: expression1 -> type expression2
     * (R) type.returnType.isSimpleType()
     */
    @Override
    public TR visit(FuncDefinition functionDefinition, TP param) {
        functionDefinition.statements.forEach(statement -> statement.setDefinition(functionDefinition));
        functionDefinition.statements.forEach(stmt -> stmt.accept(this, null));
        functionDefinition.getType().accept(this, null);
        if(((FunctionType)functionDefinition.getType()).return_type == null) {
            functionDefinition.statements.stream().forEach(st -> {
                if(st instanceof Return) {
                    new ErrorType(
                            st.getLine(),
                            st.getColumn(),
                            "Return statement in Void function");
                }
            });
        } else {

        }
        return null;
    }
     /**
     * (P) FuncInvocation: statement -> expression expression*
     * (R) expression.type.parenthesis(expression*.stream().map(exp -> exp.type).toArray())
     */
     @Override
     public TR visit(FunctionInvocation functionInvocation, TP param){
         functionInvocation.expressions.forEach(expr -> expr.accept(this, null));
         functionInvocation.variable.accept(this, null);
         functionInvocation.variable.getType().parenthesis((functionInvocation.expressions.stream().map(args -> args.getType())).toList());
         return null;
     }

     /** STATEMENTS
     * (P) Write: statement -> expression
     * (R) expression.type.isSimpleType()
     */
     @Override
     public TR visit(Write write, TP param){
         write.toWrite.accept(this, null);
         if(!write.toWrite.getType().isSimpleType()){
             ErrorHandler.getInstance().addError(new ErrorType(write.toWrite.getLine(), write.toWrite.getColumn(), "Not a Simple Type"));
         }
         return null;
     }

     /**
     * (P) WhileStmt: statement1 -> expression statement2*
     * (R) expression.type.mustBeBoolean()
     */
     @Override
     public TR visit(While aWhile, TP param) {
         super.visit(aWhile, null);
         if(!aWhile.while_expression.getType().isLogical()){
             ErrorHandler.getInstance().addError(new ErrorType(aWhile.while_expression.getLine(), aWhile.while_expression.getColumn(), "Expression must be a boolean"));
         }
         return null;
     }

     /**
     * (P) IfElseStmt: statement1 -> expression statement2*
     * (R) expression.type.mustBeBoolean()
     */
     @Override
     public TR visit(IfElse ifElse, TP param) {
         super.visit(ifElse, null);
         if(!ifElse.expr.getType().isLogical()){
             ErrorHandler.getInstance().addError(new ErrorType(ifElse.expr.getLine(), ifElse.expr.getColumn(), "Expression must be a boolean"));
         }
         return null;
     }

     /**
     * (P) ReturnStmt: statement -> expression
     * (R) expression.type.mustBeSameTypeAs(returnType)
     */
     @Override
     public TR visit(Return aReturn, TP param) {
         super.visit(aReturn, null);

         FuncDefinition funcDef = aReturn.getDefinition();
         FunctionType funcType = (FunctionType) funcDef.getType();

         if (funcType.return_type != null && aReturn.to_return != null) {
             // Comprueba que el tipo de la izquierda sea igual al de la derecha
             if (!aReturn.to_return.getType().promotesTo(funcType.return_type)) {
                 ErrorHandler.getInstance().addError(
                         new ErrorType(aReturn.getLine(), aReturn.getColumn(), "Return type does not match function return type"));
             }
         }
         else if(funcType.return_type != null){
             ErrorHandler.getInstance().addError(
                     new ErrorType(aReturn.getLine(), aReturn.getColumn(), "Missing return expression"));
         }
         else {
             if (aReturn.to_return != null) {
                 ErrorHandler.getInstance().addError(
                 new ErrorType(aReturn.getLine(), aReturn.getColumn(), "Void functions does not have a return statement"));
             }
         }
         return null;
     }

    // EXPRESSIONS

    /**
     * (P) Arithmetic: expression1 -> expression2 expression3
     * (R) expression1.type = expression2.type.arithmetic(expression3.type)
     * @param arithmetic
     * @param param
     * @return
     */
    @Override
    public TR visit(Arithmetic arithmetic, TP param) {
        arithmetic.first_expression.accept(this, null);
        arithmetic.second_expression.accept(this, null);
        arithmetic.setLValue(false);
        arithmetic.setType(arithmetic.first_expression.getType().arithmetic(arithmetic.second_expression.getType()));
        return null;
    }

    /**
     * (P) Cast: expression1 -> type expression2
     * (R) expression1.type = expression2.type.castTo(type)
     * @param cast
     * @param param
     * @return
     */
    @Override
    public TR visit(Cast cast, TP param) {
        cast.castType.accept(this, null);
        cast.toCast.accept(this, null);
        cast.setLValue(false);
        cast.setType(cast.toCast.getType().castTo(cast.castType));
        return null;
    }

    /**
     * (P) CharLiteral: expression -> CHAR
     * (R) expression.type = CHAR
     * @param charLiteral
     * @param param
     * @return
     */
    @Override
    public TR visit(CharLiteral charLiteral, TP param) {
        charLiteral.setLValue(false);
        charLiteral.setType(new CharType(charLiteral.getLine(), charLiteral.getColumn()));
        return null;
    }

    /**
     * (P) Comparison: expression1 -> expression2 expression3
     * (R) expression1.type = expression2.type.comparison(expression3.type)
     * @param comparision
     * @param param
     * @return
     */
    @Override
    public TR visit(Comparision comparision, TP param) {
        comparision.first_to_compare.accept(this, null);
        comparision.second_to_compare.accept(this, null);
        comparision.setLValue(false);
        comparision.setType(comparision.first_to_compare.getType().comparison(comparision.second_to_compare.getType()));
        return null;
    }

    /**
     * (P) VariableDefinition: expression1 -> type expression2
     * (R) expression1.type = expression2.type
     * @param variable
     * @param param
     * @return
     */
    @Override
    public TR visit(Variable variable, TP param) {
        variable.setLValue(true);
        System.out.println(variable.name);
        variable.setType(variable.getDefinition().getType());
        return null;
    }

    /**
     * (P) Indexing: expression1 -> expression2 expression3
     * (R) expression1.type = expression2.type.squareBrackets(expression3.type)
     * @param indexing
     * @param param
     * @return
     */
    @Override
    public TR visit(Indexing indexing, TP param) {
        indexing.list.accept(this, null);
        indexing.index.accept(this, null);
        indexing.setLValue(true);
        indexing.setType(indexing.list.getType().squareBrackets(indexing.index.getType()));
        return null;
    }

    /**
     * (P) IntLiteral: expression -> INT
     * (R) expression.type = INT
     * @param intLiteral
     * @param param
     * @return
     */
    @Override
    public TR visit(IntLiteral intLiteral, TP param) {
        intLiteral.setLValue(false);
        intLiteral.setType(new IntType(intLiteral.getLine(), intLiteral.getColumn()));
        return null;
    }

    /**
     * (P) Logical: expression1 -> expression2 expression3
     * (R) expression1.type = expression2.type.logical(expression3.type)
     * @param logical
     * @param param
     * @return
     */
    @Override
    public TR visit(Logical logical, TP param) {
        logical.first_expression.accept(this, null);
        logical.second_expression.accept(this, null);
        logical.setLValue(false);
        logical.setType(logical.first_expression.getType().logical(logical.second_expression.getType()));
        return null;
    }

    /**
     * (P) Modulus: expression1 -> expression2 expression3
     * (R) expression1.type = expression2.type.modulus(expression3.type)
     * @param modulus
     * @param param
     * @return
     */
    @Override
    public TR visit(Modulus modulus, TP param) {
        modulus.first_expression.accept(this, null);
        modulus.second_expression.accept(this, null);
        modulus.setLValue(false);
        modulus.setType(modulus.first_expression.getType().modulus(modulus.second_expression.getType()));
        return null;
    }

    /**
     * (P) RealLiteral: expression -> REAL
     * (R) expression.type = REAL
     * @param realLiteral
     * @param param
     * @return
     */
    @Override
    public TR visit(RealLiteral realLiteral, TP param) {
        realLiteral.setLValue(false);
        realLiteral.setType(new DoubleType(realLiteral.getLine(), realLiteral.getColumn()));
        return null;
    }

    /**
     * (P) UnaryMinus: expression1 -> expression2
     * (R) expression1.type = expression2.type.unaryMinus()
     * @param unaryMinus
     * @param param
     * @return
     */
    @Override
    public TR visit(UnaryMinus unaryMinus, TP param) {
        unaryMinus.number.accept(this, null);
        unaryMinus.setLValue(false);
        unaryMinus.setType(unaryMinus.number.getType().unaryMinus());
        return null;
    }

    @Override
    public TR visit(UnaryNot unaryNot, TP param) {
        unaryNot.to_negate.accept(this, null);
        unaryNot.setLValue(false);
        unaryNot.setType(unaryNot.to_negate.getType().logical(unaryNot.to_negate.getType()));
        return null;
    }

    /**
     * (P) FieldAccess: expression1 -> expression2 field
     * (R) expression1.type = expression2.type.fieldAccess(field)
     * @param fieldAccess
     * @param param
     * @return
     */
    @Override
    public TR visit(FieldAccess fieldAccess, TP param) {
        fieldAccess.toAccess.accept(this, null);
        fieldAccess.setLValue(true);
        fieldAccess.setType(fieldAccess.toAccess.getType().fieldAccess(fieldAccess.name));
        return null;
    }

    // STATEMENTS
    /**
     * (P) Assignment: statement -> expression expression
     * (R) expression1.type = expression2.type
     * @param assignment
     * @param param
     * @return
     */
    @Override
    public TR visit(Assignment assignment, TP param) {
        assignment.assign_to.accept(this, param);
        assignment.to_assign.accept(this, param);
        if(!assignment.to_assign.getType().promotesTo(assignment.assign_to.getType())){
            ErrorHandler.getInstance().addError(new ErrorType(assignment.getLine(), assignment.getColumn(), "Invalid Type Assignment"));
        }
        if(!assignment.assign_to.getLValue()){
            ErrorType error = new ErrorType(assignment.assign_to.getLine(), assignment.assign_to.getColumn(),
                    "Wrong Lvalue for assignment");
            ErrorHandler.getInstance().addError(error);
        }
        return null;
    }

    /**
     * (P) Read: statement -> expression
     * (R) expression.type.isSimpleType()
     * @param read
     * @param param
     * @return
     */
    @Override
    public TR visit(Read read, TP param) {
        super.visit(read, param);
        if(!read.to_read.getLValue()){
            ErrorType error = new ErrorType(read.to_read.getLine(), read.to_read.getColumn(),
                    "Wrong Lvalue for read");
            ErrorHandler.getInstance().addError(error);
        }
        return null;
    }

    /**
     * No ID because is terminal and not variable because is non terminal and will be never used
     * (P) FuncInvocation: expression1 -> expression2 expression*
     * (R) expression1.type = expression2.type.parenthesis(
     * expression*.stream().map(exp -> exp.type).toArray())
     */
   @Override
    public TR visit(FuncInvocation funcInvocation, TP param) {
        funcInvocation.variable.accept(this, null);
        for(Expression e : funcInvocation.expressions){
            e.accept(this, null);
        }
        funcInvocation.setLValue(false);
        funcInvocation.setType(funcInvocation.variable.getType().parenthesis(funcInvocation.expressions.stream().map(Expression::getType).collect(Collectors.toList())));
    return null;
}

}
