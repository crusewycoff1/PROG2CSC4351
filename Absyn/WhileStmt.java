package Absyn;

public class WhileStmt extends IterationStmt{
    public Exp exp;
    public Statement stmt;
    public WhileStmt(int p, Exp e, Statement s){pos=p;exp=e;stmt=s;}
    
}
