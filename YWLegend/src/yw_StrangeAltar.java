public class yw_StrangeAltar extends yw
{
    public String name;
    private String phyle;
    public Religions religion;
    public Skill_yw_StrangeAltar skill;
    private String saying;
    private int energy;
    private int blood;
    private int attack;
    private int attackRange;
    private int aRm;
    public yw_StrangeAltar(){
        name = "奇怪的祭坛";
        phyle = "唤魔";
        religion = new Reli_Godnism();
        energy = 75;
        attack = 0;
        blood = 3;
        attackRange = 0;
        aRm = attackRange;
        //ability 待实现
        saying = "我的乌玛，曙光已现";
    }

    public void Skill() {
        skill.hurtYouCrops();
    }
}
