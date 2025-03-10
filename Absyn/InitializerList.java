package Absyn;

public class InitializerList extends Exp {
    public AssignExp assignExp;
    public InitializerList initls;

    public InitializerList(int p, AssignExp ae, InitializerList il) {
        pos = p;
        assignExp = ae;
        initls = il;
    }
}