public class yw_Ghost extends yw{
    public String name;
    private String phyle;
    public Religions religion;
    private String saying;
    private int energy;
    private int blood;
    private int attack;
    private int attackRange;
    private int aRm;
    public yw_Ghost(){
        name = "替死冤魂";
        phyle = "唤魔";
        religion = new Reli_Magicism();
        energy = 300;
        attack = 4;
        blood = 10;
        attackRange = 2;
        aRm = 3;
        //ability 待实现
        saying = "我的乌玛，曙光已现";
    }
}
