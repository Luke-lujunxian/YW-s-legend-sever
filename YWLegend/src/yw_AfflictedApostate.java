public class yw_AfflictedApostate extends yw{
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
    public yw_AfflictedApostate(){
        name = "被折磨的弃教者";
        phyle = "唤魔";
        religion = new Reli_Magicism();
        energy = 100;
        attack = 2;
        blood = 10;
        attackRange = 2;
        aRm = 3;
        //ability 待实现
        saying = "我的乌玛，曙光已现";
    }
}
