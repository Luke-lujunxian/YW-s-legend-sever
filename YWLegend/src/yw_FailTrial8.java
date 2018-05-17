public class yw_FailTrial8 extends yw {
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

    public yw_FailTrial8(Character new_owner){
        name = "FailTrial8";
        phyle = "";
        //religion = ""
        energy = 100;
        attack = 2;
        blood = 3;
        attackRange = 2;
        aRm = attackRange;
        //ability 待实现
        owner = new_owner;
        skill = SkillFactory.createSkill(26,owner,null,null);
        saying = "我的乌玛，曙光已现";
    }
    public void Skill() {
        skill.startSkill();
    }
}
