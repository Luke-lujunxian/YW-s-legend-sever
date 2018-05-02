public class yw_DevourerLair extends yw{
    public String name;
    private String phyle;
    public Religions religion;
    private String saying;
    private int energy;
    private int blood;
    private int attack;
    private int attackRange;
    private int aRm;
    public yw_DevourerLair(){
        name = "吞噬者的巢穴";
        phyle = "唤魔";
        religion = new Reli_Magicism();
        energy = 350;
        attack = 0;
        blood = 0;
        attackRange = 0;
        aRm = attackRange;
        //ability 待实现
        saying = "我的乌玛，曙光已现";
    }
}
