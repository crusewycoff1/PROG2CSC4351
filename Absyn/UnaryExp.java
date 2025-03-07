package Absyn;

public class UnaryExp extends Exp {
   public Exp exp;
   public int oper;
   public boolean prefix;
   public UnaryExp(int p, int o, Exp e, boolean location) {pos=p; exp=e; oper=o; prefix=location;}
   public final static int INCREMENT=0, DECREMENT=1, PLUS=2, MINUS=3, BITWISEAND=4, MUL=5, TILDE=6, NOT=7;
}