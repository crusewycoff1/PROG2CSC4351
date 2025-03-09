package Absyn;

public class DecList extends Exp {
   public Dec head;
   public DecList tail;
   public DecList(Dec h, DecList t) {head=h; tail=t;}
}
