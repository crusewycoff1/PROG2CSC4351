package Absyn;

public class FieldList extends Absyn {
   public Var name;
   public NameTy typ;
   public FieldList tail;
   public boolean escape = true;
   public FieldList(int p, NameTy t, Var n, FieldList x) 
   {pos=p; name=n; typ=t; tail=x;}
}
