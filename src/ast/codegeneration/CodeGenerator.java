package ast.codegeneration;

import ast.type.Type;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class CodeGenerator {

    private PrintStream out;

    public CodeGenerator(OutputStream os) {
        out = new PrintStream(os);
    }

    public void push(Type type, int value) {
        out.println("push" + type.suffix() + " " + value);
        out.flush();
    }

    public void pushf(Type type, double value){
        out.println("pushf " + value);
        out.flush();
    }

    public void pusha(int value) {
        out.println("pusha " + value);
        out.flush();
    }

    public void pushbp(){
        out.println("push bp");
        out.flush();
    }

    public void add(Type type){
        out.println("add" + type.suffix());
        out.flush();
    }

    public void mul(Type type){
        out.println("mul" + type.suffix());
        out.flush();
    }

    public void in(Type type) {
        out.println("in" + type.suffix());
        out.flush();
    }

    public void outW(Type type){
        out.println("push" + type.suffix());
        out.println("out" + type.suffix());
    }

    public void load(Type type) {
        out.println("load" + type.suffix());
        out.flush();
    }
}
