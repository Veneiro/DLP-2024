package ast.program;

import ast.statement.Statement;
import ast.type.Type;

public interface Definition extends Statement, Type {
    Type defType = null;
    String getVar_name();
}
