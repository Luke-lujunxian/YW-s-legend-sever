public class ChangeCurrentHP implements Skill{
    /*
        Planning:
     */
    private Skill basic;
    private int addHP;
    public ChangeCurrentHP(Skill bs,int hp) {
        basic=bs;
        addHP=hp;
    }
    public void startSkill() {
        basic.startSkill();
        basic.getTarget().set("currentHP",basic.getTarget().get("currentHP")+addHP);
    }
    public Character getTarget() {return basic.getTarget();}
}
