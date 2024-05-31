import ast.codegeneration.AddressCGVisitor;
import ast.codegeneration.CodeGenerator;
import ast.codegeneration.ExecuteCGVisitor;
import ast.codegeneration.ValueCGVisitor;
import ast.errorhandler.ErrorHandler;
import ast.program.Program;
import ast.visitor.IdentificationVisitor;
import ast.visitor.OffsetVisitor;
import ast.visitor.TypeCheckingVisitor;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorView;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.CmmLexer;
import parser.CmmParser;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class Main {

    public static void main(String... args) throws Exception {
        if (args.length < 1) {
            System.err.println("Please, pass me the input file.");
            return;
        }

        // create a lexer that feeds off of input CharStream
        CharStream input = CharStreams.fromFileName(args[0]);
        CmmLexer lexer = new CmmLexer(input);

        // create a parser that feeds off the tokens buffer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CmmParser parser = new CmmParser(tokens);

        // If there is a syntax error just stop the execution
        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.out.printf("You have %d syntax errors%n", parser.getNumberOfSyntaxErrors());
            return;
        }

        Program ast = parser.program().ast;
        ast.accept(new IdentificationVisitor<Void,Void>(), null);
        ast.accept(new TypeCheckingVisitor<Void,Void>(), null);
        if (ErrorHandler.getInstance().anyError()) {
            ErrorHandler.getInstance().showErrors(System.err);
        } else {
            ast.accept(new OffsetVisitor<>(), null);
            OutputStream os = new FileOutputStream("output.txt");
            CodeGenerator cg = new CodeGenerator(os);
            ExecuteCGVisitor<Void, Void> execute = new ExecuteCGVisitor<>(cg, args[0]);
            ValueCGVisitor<Void, Void> value = new ValueCGVisitor<>(cg);
            AddressCGVisitor<Void, Void> address = new AddressCGVisitor<>(cg);
            value.setAddressCGVisitor(address);
            address.setValueCGVisitor(value);
            execute.setAddressCGVisitor(address);
            execute.setValueCGVisitor(value);
            ast.accept(execute, null);
            os.close();
            IntrospectorModel model = new IntrospectorModel("Program", ast);
            new IntrospectorView("Introspector", model);
        }
    }
}
