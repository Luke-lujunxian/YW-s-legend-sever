public class ChangeHP implements Skill{
    /*
    Planning:
     */
    private Skill basic;
    private int addHP;
    public ChangeHP(Skill bs,int hp) {
        basic=bs;
        addHP=hp;
    }
    public void startSkill() {
        basic.startSkill();
        basic.getTarget().set("HP",basic.getTarget().get("HP")+addHP);
    }
    public Character getTarget() {return basic.getTarget();}
}
