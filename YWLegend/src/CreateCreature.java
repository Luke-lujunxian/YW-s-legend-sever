<<<<<<< HEAD
public class CreateCreature implements Skill{
=======
public class CreateCreature {
    /*
        Planning:
     */
>>>>>>> a9f594b43f41593f6c0e936c49957ab3d085a89a
    private Skill basic;
    private Creature creature;
    public CreateCreature(Skill bs, Creature c) {
        basic=bs;
        creature=c;
    }
    public void startSkill() {
        basic.startSkill();
        //waiting to be implement
    }
    public Character getTarget() {return basic.getTarget();}
}
