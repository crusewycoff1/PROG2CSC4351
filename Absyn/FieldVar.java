package Absyn;

public class FieldVar extends Dec {
   public NameTy var;
   public Var field;
   public FieldVar(int p, NameTy v, Var f) {pos=p; var=v; field=f;}
}
