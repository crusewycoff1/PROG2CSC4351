package Absyn;

public class EnumeratorList extends Dec{
    public Exp exp;
    public EnumeratorList enumls;

    public EnumeratorList(int p, Exp e , EnumeratorList ls) {pos=p; exp=e; enumls=ls;}
}