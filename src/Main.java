import ast.errorhandler.ErrorHandler;
import ast.program.Program;
import ast.visitor.IdentificationVisitor;
import ast.visitor.TypeCheckingVisitor;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorView;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.CmmLexer;
import parser.CmmParser;

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
            System.out.println(String.format("You have %i syntax errors", parser.getNumberOfSyntaxErrors()));
            return;
        }

        Program ast = parser.program().ast;
        ast.accept(new IdentificationVisitor(), null);
        ast.accept(new TypeCheckingVisitor(), null);
        if (ErrorHandler.getInstance().anyError()) {
            ErrorHandler.getInstance().showErrors(System.err);
        } else {
            IntrospectorModel model = new IntrospectorModel("Program", ast);
            new IntrospectorView("Introspector", model);
        }
    }
}
