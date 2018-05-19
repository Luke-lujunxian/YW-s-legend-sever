public class yw_FailTrial1 extends yw {
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

    public yw_FailTrial1(Character new_owner){
        name = "FailTrial1";
        phyle = "";
        //religion = ""
        energy = 25;
        attack = 0;
        blood = 3;
        attackRange = 0;
        aRm = attackRange;
        owner=new_owner;
        skill = SkillFactory.createSkill(24,owner,null,null);
        saying = "我的乌玛，曙光已现";
        skillInitializedTime="EndRound";
    }

    public void Skill() {
        skill.startSkill();
    }
}
