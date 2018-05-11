public class ChangeSkill {
    private Skill basic;
    private Skill newSkill;
    public ChangeSkill(Skill bs,Skill s) {
        basic=bs;
        newSkill=s;
    }
    public void startSkill() {
        basic.startSkill();
        Personage target=(Personage)basic.getTarget();
        target.setSecondSkill(newSkill);
    }
    public Character getTarget() {return basic.getTarget();}
}
