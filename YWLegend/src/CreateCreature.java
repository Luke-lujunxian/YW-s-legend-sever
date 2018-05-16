public class CreateCreature {
    /*
        Planning:
     */
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
