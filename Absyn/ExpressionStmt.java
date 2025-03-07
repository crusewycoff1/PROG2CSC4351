package Absyn;

public class ExpressionStmt extends Statement{
    public Exp exp;
    public ExpressionStmt(int p, Exp e){pos=p; exp=e;}
}
