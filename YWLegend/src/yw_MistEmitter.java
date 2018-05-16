public class yw_MistEmitter extends yw {
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
    public yw_MistEmitter(){
        name = "迷雾释放者";
        phyle = "潜行";
        religion=new Reli_Magicism();
        energy=175;
        attack=0;
        blood=0;
        attackRange=0;
        aRm=attackRange;
        //ability 待实现
        saying = "我的乌玛，曙光已现";

    }
}
