public class yw_PuppetLove extends yw {
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
    public yw_PuppetLove(){
        name = "傀儡·爱";
        phyle = "潜行";
        religion=new Reli_Machinism();
        energy=125;
        attack=3;
        blood=10;
        attackRange=2;
        aRm=5;
        //ability 待实现
        saying = "我的乌玛，曙光已现";

    }
}
