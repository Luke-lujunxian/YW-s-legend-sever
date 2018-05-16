public class yw_ShadowSpawn extends yw {
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

    public yw_ShadowSpawn() {
        name = "残影制造术";
        phyle = "潜行";
        religion = new Reli_Magicism();
        energy = 159;
        attack = 0;
        blood = 0;
        attackRange = 0;
        aRm = attackRange;
        //ability 待实现
        saying = "我的乌玛，曙光已现";
    }
}
