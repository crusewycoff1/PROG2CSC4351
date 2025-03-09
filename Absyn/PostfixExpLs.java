package Absyn;

public class PostfixExpLs extends Exp{
    public Exp exp1;
    public ArgExpList exp2;
    public PostfixExpLs(int p, Exp e1, ArgExpList e2){pos = p; exp1 = e1; exp2 = e2;}
}