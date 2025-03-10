package Absyn;

public class JumpStmt extends Statement{
    public Var var;
    public Exp exp;
    public boolean returning;
    public boolean breaking;
    public boolean continuing;
    public boolean gotoing;
    public JumpStmt(int p, Var v, boolean returns, boolean breaks, boolean continues, boolean gotos)
    {pos=p; var=v; returning = returns; breaking=breaks; continuing=continues; gotoing=gotos;}
    public JumpStmt(int p, Exp e, boolean returns, boolean breaks, boolean continues, boolean gotos)
    {pos=p; exp=e; returning = returns; breaking=breaks; continuing=continues; gotoing=gotos;}
    public JumpStmt(int p, boolean returns, boolean breaks, boolean continues, boolean gotos)
    {pos=p; returning = returns; breaking=breaks; continuing=continues; gotoing=gotos;}
}
