public class yw_PuppetHate extends yw{
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
    public yw_PuppetHate(){
        name = "傀儡·恨";
        phyle = "潜行";
        religion=new Reli_Machinism();
        energy=125;
        attack=10;
        blood=3;
        attackRange=2;
        aRm=3;
        //ability 待实现
        saying = "我的乌玛，曙光已现";

    }
}
