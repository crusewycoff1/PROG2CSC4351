package Absyn;

public class VarDec extends Dec {
   public Var name;
   public boolean escape = true;
   public NameTy typ; /* optional */
   public Exp init;
   public VarDec(int p, Var n, NameTy t, Exp i) {pos=p; name=n; typ=t; init=i;}
}
