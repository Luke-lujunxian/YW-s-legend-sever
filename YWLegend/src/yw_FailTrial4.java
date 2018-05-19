public class yw_FailTrial4 extends yw {
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

    public yw_FailTrial4(){
        name = "FailTrial4";
        phyle = "";
        //religion = ""
        energy = 75;
        attack = 3;
        blood = 4;
        attackRange = 1;
        aRm = 3;
        //ability 待实现
        saying = "我的乌玛，曙光已现";
        skillInitializedTime="InRound";
    }
}
