public class ChangeATK implements Skill {
    private Skill basic;
    private int addATK;
    public ChangeATK(Skill bs,int atk) {
        basic=bs;
        addATK=atk;
    }
    public void startSkill() {
        basic.startSkill();
        basic.getTarget().set("ATK",basic.getTarget().get("ATK")+addATK);
    }
    public Character getTarget() {return basic.getTarget();}
}
