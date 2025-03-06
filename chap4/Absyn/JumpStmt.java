package Absyn;

public class JumpStmt extends Statement{
    public Var var;
    public Exp exp;
    public JumpStmt(int p, Var v){pos=p; var=v;}
    public JumpStmt(int p, Exp e){pos=p; exp=e;}
}
