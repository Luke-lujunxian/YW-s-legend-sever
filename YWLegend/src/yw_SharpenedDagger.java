public class yw_SharpenedDagger extends yw{
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
    public yw_SharpenedDagger(){
        name = "尖锐的匕首";
        phyle = "潜行";
        religion=new Reli_Machinism();
        energy=250;
        attack=0;
        blood=9;
        attackRange=0;
        aRm=attackRange;
        //ability 待实现
        saying = "我的乌玛，曙光已现";

    }
}
