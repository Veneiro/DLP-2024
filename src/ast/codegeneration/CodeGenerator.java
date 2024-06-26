package ast.codegeneration;

import ast.expression.IntLiteral;
import ast.expression.RealLiteral;
import ast.program.Definition;
import ast.program.Program;
import ast.program.VarDefinition;
import ast.statement.Statement;
import ast.type.CharType;
import ast.type.DoubleType;
import ast.type.IntType;
import ast.type.Type;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class CodeGenerator {

    private PrintStream out;

    private int labelCont = -1;

    public CodeGenerator(OutputStream os) {
        out = new PrintStream(os);
    }

    public void push(Type type, int value) {
        out.println("\tpush" + type.suffix() + " " + value);
        out.flush();
    }

    public void pushf(Type type, double value){
        out.println("\tpushf " + value);
        out.flush();
    }

    public void pusha(int value) {
        out.println("\tpusha " + value);
        out.flush();
    }

    public void pushbp(){
        out.println("\tpush bp");
        out.flush();
    }

    public void add(Type type){
        out.println("\tadd" + type.suffix());
        out.flush();
    }

    public void mul(Type type){
        out.println("\tmul" + type.suffix());
        out.flush();
    }

    public void in(Type type) {
        out.println("\tin" + type.suffix());
        out.flush();
    }

    public void outW(Type type){
        out.println("\tout" + type.suffix());
        out.flush();
    }

    public void load(Type type) {
        out.println("\tload" + type.suffix());
        out.flush();
    }

    public void label(String name) {
        out.println(name + ":");
        out.flush();
    }

    public void enter(int varSize) {
        out.println("\tenter " + varSize);
        out.flush();
    }

    public void ret(int returnSize, int paramSize, int localSize) {
        out.println("\tret " + returnSize + ", " + localSize + ", " + paramSize);
        out.flush();
    }

    public void call(String name) {
        if(name.equals("main")){
            out.println("\n' Invocation to the main function");
        }
        out.println("\tcall " + name);
        out.flush();
    }

    public void halt() {
        out.println("\thalt");
        out.flush();
    }

    public void store(Type type) {
        out.println("\tstore" + type.suffix());
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
            out.println("\tb2i");
        } else if (typeToConvert instanceof CharType &&
                    OutputType instanceof DoubleType){
            out.println("\tb2i");
            out.println("\ti2f");
        } else if (typeToConvert instanceof IntType &&
                    OutputType instanceof CharType){
            out.println("\ti2b");
        } else if (typeToConvert instanceof IntType &&
                    OutputType instanceof DoubleType){
            out.println("\ti2f");
        } else if (typeToConvert instanceof DoubleType &&
                    OutputType instanceof CharType){
            out.println("\tf2i");
            out.println("\ti2b");
        } else if (typeToConvert instanceof DoubleType &&
                OutputType instanceof IntType) {
            out.println("\tf2i");
        }
        out.flush();
    }

    public String nextLabel() {
        labelCont++;
        return "label" + labelCont;
    }

    public void jz(String label) {
        out.printf("\tjz %s%n", label);
        out.flush();
    }

    public void jmp(String label) {
        out.printf("\tjmp %s%n", label);
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
        out.println("\teq" + superType.suffix());
        out.flush();
    }

    public void lt(Type superType) {
        out.println("\tlt" + superType.suffix());
        out.flush();
    }

    public void gt(Type superType) {
        out.println("\tgt" + superType.suffix());
        out.flush();
    }

    public void le(Type superType) {
        out.println("\tle" + superType.suffix());
        out.flush();
    }

    public void ge(Type superType) {
        out.println("\tge" + superType.suffix());
        out.flush();
    }

    public void source(String source, Program program) {
        out.println("#source \"" + source + "\"");
        out.println("' * Global variables:");
        for (Definition def : program.definitions){
            if(def instanceof VarDefinition){
                out.printf("' * %s %s%n", def.getType().toString(), def.getName());
            }
        }
        out.flush();
    }

    public void line(int line) {
        out.println("\n#line " + line);
        out.flush();
    }

    public void sub(Type type) {
        out.println("\tsub" + type.suffix());
        out.flush();
    }

    public void div(Type type) {
        out.println("\tdiv" + type.suffix());
        out.flush();
    }

    public void mod(Type type) {
        out.println("\tmod" + type.suffix());
        out.flush();
    }

    public void and(Type type) {
        out.println("\tand");
        out.flush();
    }

    public void or(Type type) {
        out.println("\tor");
        out.flush();
    }

    public void pop(char suffix) {
        out.println("\tpop" + suffix);
        out.flush();
    }

    public void param(List<VarDefinition> definitions) {
        out.println("' * Parameters");
        for(Definition param: definitions){
            out.println(param.toString());
        }
        out.println();
    }

    public void locals(List<Statement> statements) {
        out.println("' * Local variables");
        for (Statement stmt: statements){
            if(stmt instanceof VarDefinition) {
                out.println(stmt.toString());
            }
        }
        out.println();
    }
}
