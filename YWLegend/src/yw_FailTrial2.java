public class yw_FailTrial2 extends yw {
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

    public yw_FailTrial2(Character new_owner){
        name = "FailTrial2";
        phyle = "";
        //religion = ""
        energy = 50;
        attack = 0;
        blood = 3;
        attackRange = 0;
        aRm = attackRange;
        //ability 待实现
        saying = "我的乌玛，曙光已现";
        owner=new_owner;
        skill = SkillFactory.createSkill(25,owner,null,null);
        skillInitializedTime="StartRound";
    }
    public void Skill() {
        skill.startSkill();
    }
}
