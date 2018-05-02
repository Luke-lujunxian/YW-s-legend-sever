public class yw_Devourer extends yw_DevourerLair {
    public String name;
    private String phyle;
    public Religions religion;
    private String saying;
    private int energy;
    private int blood;
    private int attack;
    private int attackRange;
    private int aRm;
    public yw_Devourer(){
        name = "吞噬者";
        phyle = "唤魔";
        religion = new Reli_Magicism();
        energy = 25;
        attack = 3;
        blood = 2;
        attackRange = 2;
        aRm = attackRange;
        //ability 待实现
        saying = "我的乌玛，曙光已现";
    }
}
