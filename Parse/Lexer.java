package Parse;
import java_cup.runtime.Symbol;

interface Lexer {
    public Symbol nextToken() throws java.io.IOException;
}
