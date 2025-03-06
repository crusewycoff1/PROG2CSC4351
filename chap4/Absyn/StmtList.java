package Absyn;
import Symbol.Symbol;
public class StmtList extends Statement{
    public StmtList statements;
    public Statement stmt;
    public StmtList(int p, Statement s , StmtList l) {pos=p; stmt=s; statements=l;}
}
