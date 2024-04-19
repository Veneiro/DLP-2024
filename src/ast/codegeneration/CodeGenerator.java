package ast.codegeneration;

import ast.type.Type;

import java.io.OutputStream;
import java.io.PrintStream;

public class CodeGenerator {

    private PrintStream out;

    public CodeGenerator(OutputStream os) {
        out = new PrintStream(os);
    }

    public void push(Type type, int value) {
        out.println("push" + type.suffix() + " " + value);
        out.flush();
    }

    public void in(Type type) {
        out.println("in" + type.suffix());
        out.flush();
    }
}
