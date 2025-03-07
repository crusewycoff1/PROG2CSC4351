import Absyn.*;
import Symbol.Symbol;
import java.io.PrintWriter;

public class TestPrint {
    public static void main(String[] args) {
        Exp var = new VarExp(0, new SimpleVar(0, Symbol.symbol("x")));
        Exp value = new IntExp(0, 42);
        Exp assignExp = new AssignExp(0, var, AssignExp.ASSIGN, value);
        PrintWriter writer = new PrintWriter(System.out, true);
        Print printer = new Print(writer);
        printer.prExp(assignExp, 0);
        writer.flush();
    }
} 