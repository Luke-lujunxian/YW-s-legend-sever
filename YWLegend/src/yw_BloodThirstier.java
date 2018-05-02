public class yw_BloodThirstier extends yw{
    public String name;
    private String phyle;
    public Religions religion;
    private String saying;
    private int energy;
    private int blood;
    private int attack;
    private int attackRange;
    private int aRm;
    public yw_BloodThirstier(){
        name = "嗜血者";
        phyle = "唤魔";
        religion = new Reli_Godnism();
        energy = 200;
        attack = 5;
        blood = 5;
        attackRange = 2;
        aRm = 3;
        //ability 待实现
        saying = "我的乌玛，曙光已现";
    }
}

