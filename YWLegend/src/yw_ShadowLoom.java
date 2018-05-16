public class yw_ShadowLoom extends yw {
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
    public yw_ShadowLoom(){
        name = "暗影织布机";
        phyle = "潜行";
        religion=new Reli_Godnism();
        energy=175;
        attack=0;
        blood=0;
        attackRange=0;
        aRm=attackRange;
        //ability 待实现
        saying = "我的乌玛，曙光已现";

    }
}
