public class yw_FlycuttingTrap extends yw {
    public String name;
    private String phyle;
    public Religions religion;
    private String saying;
    private int energy;
    private int blood;
    private int attack;
    private int attackRange;
    private int aRm;
    private Character owner;

    public yw_FlycuttingTrap() {
        name = "飞刀陷阱";
        phyle = "潜行";
        religion = new Reli_Magicism();
        energy = 300;
        attack = 0;
        blood = 0;
        attackRange = 0;
        aRm = attackRange;
        //ability 待实现
        saying = "我的乌玛，曙光已现";
    }
}
