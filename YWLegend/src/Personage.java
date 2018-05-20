public class Personage extends Creature implements Character {
    /*
        Planning: 战争迷雾
     */
    private int power;
    private int HP;
    private int currentHP;
    private int ATK,currentATK;
    private Skill firstSkill, secondSkill;
    private String name;
    private String IDname;
    private String skillInitializedTime1="";//StartRound, InRound, EndRound
    private String skillInitializedTime2="";//StartRound, InRound, EndRound

    Personage(){

    }
    public String getName(){
        return name;
    }
    Personage(String new_IDname){
        IDname=new_IDname;
    }
    public Skill getSecondSkill() {
        return secondSkill;
    }

    public void setSecondSkill(Skill secondSkill) {
        this.secondSkill = secondSkill;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void set(String d, int v) {
        if(d.equals("power")) power=v;
        else if(d.equals("HP")) HP=v;
        else if(d.equals("currentHP")) currentHP=v;
        else if(d.equals("ATK")) ATK=v;
        else if(d.equals("currentATK")) currentATK=v;
    }
    public int get(String d) {
        if(d.equals("power")) return power;
        else if(d.equals("HP")) return HP;
        else if(d.equals("currentHP")) return currentHP;
        else if(d.equals("ATK")) return ATK;
        else if(d.equals("currentATK")) return currentATK;
        return -1;
    }

    public Skill getFirstSkill() {
        return firstSkill;
    }

    public String getSkillInitializedTime1() {
        return skillInitializedTime1;
    }
    public void setSkillInitializedTime1(String new_skillInitializedTime1){
        skillInitializedTime1=new_skillInitializedTime1;
    }
    public String getSkillInitializedTime2() {
        return skillInitializedTime2;
    }
    public void setSkillInitializedTime2(String new_skillInitializedTime2){
        skillInitializedTime2=new_skillInitializedTime2;
    }
    public String getIDname(){
        return IDname;
    }
}
