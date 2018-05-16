public class yw_WitheredDemonFlower extends yw{
    public String name;
    private String phyle;
    public Skill skill;
    public Religions religion;
    private String saying;
    private int energy;
    private int blood;
    private int attack;
    private int attackRange;
    private int aRm;
    private Character owner;
    public yw_WitheredDemonFlower(){
        name = "凋谢的恶魔之花";
        phyle = "唤魔";
        religion = new Reli_Machinism();
        energy = 125;
        attack = 5;
        blood = 5;
        attackRange = 2;
        aRm = 3;
        //ability 待实现
        saying = "我的乌玛，曙光已现";
    }
}
