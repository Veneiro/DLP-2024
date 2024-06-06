package ast.type;

import ast.errorhandler.ErrorHandler;
import ast.program.Field;
import ast.visitor.Visitor;

import java.util.List;

public class StructType extends AbstractType {
    public List<Field> struct_fields;

    public StructType(int line, int column, List<Field> fields) {
        super(line, column);
        this.struct_fields = fields;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type fieldAccess(String name/*, ASTNode node*/) {
        for (Field field : struct_fields) {
            if (field.getName().equals(name)) {
                return field.getType();
            }
        }
        ErrorType error = new ErrorType(this.getLine(), this.getColumn(), "Field not found in struct");
        ErrorHandler.getInstance().addError(error);
        return error;
    }

    @Override
    public int numberOfBytes() {
        int bytes = 0;
        for (Field field : struct_fields) {
            bytes += field.getType().numberOfBytes();
        }
        return bytes;
    }
}
