public class yw_EvilEnergyCollector extends yw{
    public String name;
    private String phyle;
    public Religions religion;
    private String saying;
    private int energy;
    private int blood;
    private int attack;
    private int attackRange;
    private int aRm;
    public yw_EvilEnergyCollector(){
        name = "邪能收集台";
        phyle = "唤魔";
        religion = new Reli_Magicism();
        energy = 25;
        attack = 0;
        blood = 5;
        attackRange = 0;
        aRm = attackRange;
        //ability 待实现
        saying = "我的乌玛，曙光已现";
    }
}
