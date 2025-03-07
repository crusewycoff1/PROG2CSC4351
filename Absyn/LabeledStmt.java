package Absyn;

public class LabeledStmt extends Statement{
    public Var label;
    public Statement stmt;
    public LabeledStmt(int p, Var l, Statement s) {pos=p; label = l; stmt = s;}
}
