package Absyn;
import Symbol.Symbol;
public class CompoundStmt extends Statement{
    public DecList decLs;
    public StmtList stmtLs;
    public CompoundStmt(int p, DecList d, StmtList s) {pos=p; decLs=d; stmtLs=s;}
}
