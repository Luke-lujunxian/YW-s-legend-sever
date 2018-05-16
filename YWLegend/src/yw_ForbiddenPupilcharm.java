public class yw_ForbiddenPupilcharm extends yw{
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
    public yw_ForbiddenPupilcharm(){
        name = "禁忌的瞳术";
        phyle = "潜行";
        religion = new Reli_Godnism();
        energy = 200;
        attack = 0;
        blood = 25;
        attackRange = 0;
        aRm = attackRange;
        //ability 待实现
        saying = "我的乌玛，曙光已现";
    }
}
