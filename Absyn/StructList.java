package Absyn;

public class StructList extends Dec{
    public Var name;
    public FieldList tail;

    public StructList(int p, Var n , FieldList f) {pos=p; name=n; tail=f;}
}