package ast.type;

import ast.ASTNode;
import ast.statement.Return;

import java.util.List;

public interface Type extends ASTNode {
    Type arithmetic(Type type);

    Type castTo(Type type);

    Type comparison(Type type);

    Type squareBrackets(Type type);

    Type logical(Type type);

    Type modulus(Type type);

    Type unaryMinus();

    Type fieldAccess(String name);

    Type parenthesis(List<Type> types);

    int numberOfBytes();

    boolean mustBeSubtype(Type param);

    char suffix();
}
