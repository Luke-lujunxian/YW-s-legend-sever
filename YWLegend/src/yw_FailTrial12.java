public class yw_FailTrial12 extends yw {
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

    public yw_FailTrial12(){
        name = "FailTrial12";
        phyle = "";
        //religion = ""
        energy = 300;
        attack = 10;
        blood = 10;
        attackRange = 2;
        aRm = attackRange;
        //ability 待实现
        saying = "我的乌玛，曙光已现";
        skillInitializedTime="InRound";
    }
}
