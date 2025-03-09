package Absyn;

public class DoWhileStmt extends IterationStmt{
    public Exp exp;
    public Statement stmt;
    public DoWhileStmt(int p, Statement s, Exp e){pos=p;exp=e;stmt=s;}
    
}