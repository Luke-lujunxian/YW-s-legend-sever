public class yw_StrangeAltar extends yw
{
    public String name;
    private String phyle;
    public Religions religion;
    public Skill skill;
    private String saying;
    private int energy;
    private int blood;
    private int attack;
    private int attackRange;
    private int aRm;
    private Character owner;

    public yw_StrangeAltar(Character new_owner){
        name = "奇怪的祭坛";
        phyle = "唤魔";
        religion = new Reli_Godnism();
        energy = 75;
        attack = 0;
        blood = 3;
        attackRange = 0;
        aRm = attackRange;
        saying = "我的乌玛，曙光已现";
       // skill = SkillFactory.createSkill(1,)
    }

    //public void Skill() {skill.hurtYouCrops();}
}
