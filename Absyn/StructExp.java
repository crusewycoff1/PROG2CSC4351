package Absyn;

public class StructExp extends Exp {
   public Var var;
   public Exp e;
   boolean arrow;
   public StructExp(int p, Var v, Exp ex, boolean airo) {pos=p; var=v; e=ex; arrow=airo;}
}