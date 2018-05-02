public class yw_NaughtyImp extends yw {
    public String name;
    private String phyle;
    public Religions religion;
    private String saying;
    private int energy;
    private int blood;
    private int attack;
    private int attackRange;
    private int aRm;
    public yw_NaughtyImp(){
        name = "淘气的小鬼";
        phyle = "唤魔";
        religion = new Reli_Machinism();
        energy = 25;
        attack = 2;
        blood = 1;
        attackRange = 1;
        aRm = 2;
        //ability 待实现
        saying = "我的乌玛，曙光已现";
    }
}
