public class yw_FailTrial5 extends yw {
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

    public yw_FailTrial5(){
        name = "FailTrial5";
        phyle = "";
        //religion = ""
        energy = 100;
        attack = 4;
        blood = 5;
        attackRange = 2;
        aRm = 3;
        //ability 待实现
        saying = "我的乌玛，曙光已现";
        skillInitializedTime="InRound";
    }
}
