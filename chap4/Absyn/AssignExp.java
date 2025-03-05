package Absyn;
import Symbol.Symbol;
public class AssignExp extends Exp {
   public Exp var;
   public Exp exp;
   public int oper;
   public AssignExp(int p, Exp v, int o, Exp e) {pos=p; var=v; exp=e; oper=o;}

   public final static int ASSIGN=18, ADDASSIGN=19, SUBASSIGN=20, 
   DIVASSIGN=21, MULASSIGN=22, MODASSIGN=23, BWISEANDASSIGN=24, BWISEORASSIGN=25, 
   BWISEXORASSIGN=26, LSHIFTASSIGN=27, RSHIFTASSIGN=28;
}
