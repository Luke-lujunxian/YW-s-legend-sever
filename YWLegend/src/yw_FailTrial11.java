public class yw_FailTrial11 extends yw {
    public String name;
    private String phyle;
    //public Religions religion;
    private String saying;
    private int energy;
    private int blood;
    private int attack;
    private int attackRange;
    private int aRm;
    private Character owner;
    private String skillInitializedTime="";//StartRound, InRound, EndRound

    public yw_FailTrial11(){
        name = "FailTrial11";
        phyle = "";
        //religion = ""
        energy = 200;
        attack = 4;
        blood = 5;
        attackRange = 2;
        aRm = 5;
        //ability 待实现
        saying = "我的乌玛，曙光已现";
        skillInitializedTime="InRound";
    }
}
