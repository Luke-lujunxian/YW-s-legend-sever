public class yw_CursedSeal extends yw{
    public String name;
    private String phyle;
    public Religions religion;
    private String saying;
    private int energy;
    private int blood;
    private int attack;
    private int attackRange;
    private int aRm;
    public yw_CursedSeal(){
        name = "被诅咒的封印";
        phyle = "唤魔";
        religion = new Reli_Godnism();
        energy = 500;
        attack = 0;
        blood = 25;
        attackRange = 0;
        aRm = attackRange;
        //ability 待实现
        saying = "我的乌玛，曙光已现";
    }
}
