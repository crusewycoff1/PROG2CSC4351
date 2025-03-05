package Absyn;
import Symbol.Symbol;
public class StructExp extends Exp {
   public Var var;
   public Exp e;
   public StructExp(int p, Var v, Exp ex) {pos=p; var=v; e=ex;}
}