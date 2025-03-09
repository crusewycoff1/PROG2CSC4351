package Absyn;

public class PostfixExp extends Exp{
    public Exp exp1;
    public Exp exp2;
    public PostfixExp(int p, Exp e1, Exp e2){pos = p; exp1 = e1; exp2 = e2;}

}