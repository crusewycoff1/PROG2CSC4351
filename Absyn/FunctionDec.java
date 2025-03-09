package Absyn;

public class FunctionDec extends Dec {
  public Var name;
  public FieldList params;
  public NameTy result;		/* optional */
  public Statement body;
  public FunctionDec(int p, Var n, FieldList a, NameTy r, Statement b) {
    pos=p; name=n; params=a; result=r; body=b;
  }
  public boolean leaf = false;
}
