package ast.errorhandler;

import ast.type.ErrorType;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {
    private static ErrorHandler instance;
    private List<ErrorType> errors = new ArrayList<>();

    private ErrorHandler() {
    }

    public static ErrorHandler getInstance() {
        if (instance == null) {
            instance = new ErrorHandler();
            return instance;
        }
        return instance;
    }

    public boolean anyError() {
        if (errors.isEmpty()) {
            return true;
        }
        return false;
    }

    public void showErrors(PrintStream out) {
        for (ErrorType error : errors) {
            out.println(error.toString());
        }
    }

    public void addError(ErrorType error) {
        if (error != null) {
            errors.add(error);
        }
    }
}
