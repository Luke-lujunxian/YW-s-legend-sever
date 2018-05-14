public class ChangePower implements Skill{
    private Skill basic;
    private int addPower;
    public ChangePower(Skill bs,int p) {
        basic=bs;
        addPower=p;
    }
    public void startSkill() {
        basic.startSkill();
        yw target=(yw)basic.getTarget();
        target.setEnergy(target.getEnergy()+addPower);
    }
    public Character getTarget() {return basic.getTarget();}
}
