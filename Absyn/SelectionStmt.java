package Absyn;

public class SelectionStmt extends Statement{
    public Exp exp;
    public Statement stmt1, stmt2;
    public SelectionStmt(int p, Exp e, Statement s1, Statement s2){pos=p;exp=e;stmt1=s1;stmt2=s2;}
}
