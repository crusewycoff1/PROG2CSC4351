package Absyn;

public class ForStmt extends IterationStmt{
    public Exp exp1,exp2,exp3;
    public Statement stmt;
    public boolean first;
    public boolean second;
    public boolean third;
    public ForStmt(int p, Exp e1, Exp e2, Exp e3, Statement s, boolean fst, boolean scd, boolean thd)
    {pos=p; exp1=e1; exp2=e2; exp3=e3; stmt=s;first=fst;second=scd;third=thd;}
}
