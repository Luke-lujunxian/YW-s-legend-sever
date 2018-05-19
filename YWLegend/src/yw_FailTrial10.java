public class yw_FailTrial10 extends yw {
    public String name;
    private String phyle;
    //public Religions religion;
    private String saying;
    private int energy;
    private int blood;
    private int attack;
    private int attackRange;
    private int aRm;
    private Character owner;
    private Skill skill;
    private String skillInitializedTime="";//StartRound, InRound, EndRound

    public yw_FailTrial10(){
        name = "FailTrial10";
        phyle = "";
        //religion = ""
        energy = 500;
        attack = 0;
        blood = 0;
        attackRange = 0;
        aRm = attackRange;
        //ability 待实现
        saying = "我的乌玛，曙光已现";
        skillInitializedTime="InRound";
    }

    public void skill(yw soonDead) {
        soonDead=null;
    }
}
