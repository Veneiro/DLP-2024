package ast.codegeneration;

import ast.expression.CharLiteral;
import ast.expression.IntLiteral;
import ast.expression.RealLiteral;
import ast.type.CharType;
import ast.type.DoubleType;
import ast.type.IntType;
import ast.type.Type;

import java.io.OutputStream;
import java.io.PrintStream;

public class CodeGenerator {

    private PrintStream out;

    private int labelCont = 0;

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
        out.println("out" + type.suffix());
        out.flush();
    }

    public void load(Type type) {
        out.println("load" + type.suffix());
        out.flush();
    }

    public void label(String name) {
        out.println(name + ":");
        out.flush();
    }

    public void enter(int varSize) {
        out.println("enter " + varSize);
        out.flush();
    }

    public void ret(int returnSize, int paramSize, int localSize) {
        out.println("ret " + returnSize + ", " + localSize + ", " + paramSize);
        out.flush();
    }

    public void call(String name) {
        out.println("call " + name);
        out.flush();
    }

    public void halt() {
        out.println("halt");
        out.flush();
    }

    public void store(Type type) {
        out.println("store" + type.suffix());
        out.flush();
    }

    /**
 *          Char        Int     Real
     * Char ---         b2i     b2i - i2f
     * Int  i2b         ---     i2f
     * Real f2i - i2b   i2b     ---
     * @param typeToConvert
     * @param OutputType
     */
    public void convert(Type typeToConvert, Type OutputType) {
        if(typeToConvert instanceof CharType &&
            OutputType instanceof IntType){
            out.println("b2i");
        } else if (typeToConvert instanceof CharType &&
                    OutputType instanceof DoubleType){
            out.println("b2i");
            out.println("i2f");
        } else if (typeToConvert instanceof IntType &&
                    OutputType instanceof CharType){
            out.println("i2b");
        } else if (typeToConvert instanceof IntType &&
                    OutputType instanceof DoubleType){
            out.println("i2f");
        } else if (typeToConvert instanceof DoubleType &&
                    OutputType instanceof CharType){
            out.println("f2i");
            out.println("i2b");
        } else if (typeToConvert instanceof DoubleType &&
                OutputType instanceof IntType) {
            out.println("f2i");
        }
        out.flush();
    }

    public String nextLabel() {
        labelCont++;
        return "_" + labelCont;
    }

    public void jz(String label) {
        out.printf("jz %s%n", label);
        out.flush();
    }

    public void jmp(String label) {
        out.printf("jmp %s%n", label);
        out.flush();
    }

    public Type superType(Type type1, Type type2){
        if(type1 instanceof RealLiteral){
            return type1;
        } else if (type2 instanceof RealLiteral){
            return type2;
        } else if (type1 instanceof IntLiteral){
            return type1;
        } else if (type2 instanceof IntLiteral){
            return type2;
        }
        return type1;
    }

    public void eq(Type superType) {
        out.println("eq" + superType.suffix());
        out.flush();
    }

    public void lt(Type superType) {
        out.println("lt" + superType.suffix());
        out.flush();
    }

    public void gt(Type superType) {
        out.println("gt" + superType.suffix());
        out.flush();
    }

    public void le(Type superType) {
        out.println("le" + superType.suffix());
        out.flush();
    }

    public void ge(Type superType) {
        out.println("ge" + superType.suffix());
        out.flush();
    }

    public void source(String source) {
        out.println("#source \"" + source + "\"");
        out.flush();
    }

    public void line(int line) {
        out.println("#line " + line);
        out.flush();
    }

    public void sub(Type type) {
        out.println("sub" + type.suffix());
        out.flush();
    }

    public void div(Type type) {
        out.println("div" + type.suffix());
        out.flush();
    }

    public void mod(Type type) {
        out.println("mod" + type.suffix());
        out.flush();
    }

    public void and(Type type) {
        out.println("and");
        out.flush();
    }

    public void or(Type type) {
        out.println("or");
        out.flush();
    }

    public void pop(char suffix) {
        out.println("pop" + suffix);
        out.flush();
    }
}
