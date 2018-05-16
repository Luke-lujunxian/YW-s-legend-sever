public class yw_PuppetPassion extends yw {
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
    public yw_PuppetPassion(){
        name = "傀儡·情";
        phyle = "潜行";
        religion=new Reli_Machinism();
        energy=225;
        attack=0;
        blood=0;
        attackRange=1;
        aRm=5;
        //ability 待实现
        saying = "我的乌玛，曙光已现";

    }
}
