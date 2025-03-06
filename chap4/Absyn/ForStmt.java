package Absyn;
import Symbol.Symbol;
public class ForStmt extends IterationStmt{
    public Exp exp1,exp2,exp3;
    public Statement stmt;
    public ForStmt(int p, Exp e1, Exp e2, Exp e3, Statement s){pos=p; exp1=e1; exp2=e2; exp3=e3; stmt=s;}
}
