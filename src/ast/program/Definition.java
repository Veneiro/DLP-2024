package ast.program;

import ast.statement.Statement;
import ast.type.Type;

public interface Definition extends Statement {
    Type defType = null;
    String getVar_name();
    int getScope();
    void setScope(int scope);
}
