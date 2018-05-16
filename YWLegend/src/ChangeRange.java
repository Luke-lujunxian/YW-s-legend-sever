public class ChangeRange implements Skill{
    /*
    Planning:
     */
    private Skill basic;
    private int addRange;
    public ChangeRange(Skill bs, int d) {
        basic=bs;
        addRange=d;
    }
    public void startSkill() {
        basic.startSkill();
        yw target=(yw)basic.getTarget();
        target.setAttackRange(target.getAttackRange()+addRange);
    }
    public Character getTarget() {return basic.getTarget();}
}
