public class yw_FailTrial9 extends yw {
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

    public yw_FailTrial9(Character new_owner){
        name = "FailTrial9";
        phyle = "";
        //religion = ""
        energy = 100;
        attack = 5;
        blood = 6;
        attackRange = 2;
        aRm = 3;
        owner = new_owner;
        //ability 待实现
        saying = "我的乌玛，曙光已现";
        skill = SkillFactory.createSkill(27,owner,null,null);
        skillInitializedTime="EndRound";
    }

    public void Skill() {
        skill.startSkill();
    }
}
