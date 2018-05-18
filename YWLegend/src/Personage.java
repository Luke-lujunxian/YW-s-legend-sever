public class Personage extends Creature implements Character {
    /*
        Planning: 战争迷雾
     */
    private int power;
    private int HP;
    private int currentHP;
    private int ATK;
    private Skill firstSkill, secondSkill;
    private String name;

    public Skill getSecondSkill() {
        return secondSkill;
    }

    public void setSecondSkill(Skill secondSkill) {
        this.secondSkill = secondSkill;
    }

    public void set(String d,int v) {
        if(d.equals("power")) power=v;
        else if(d.equals("HP")) HP=v;
        else if(d.equals("currentHP")) currentHP=v;
        else if(d.equals("ATK")) ATK=v;
    }
    public int get(String d) {
        if(d.equals("power")) return power;
        else if(d.equals("HP")) return HP;
        else if(d.equals("currentHP")) return currentHP;
        else if(d.equals("ATK")) return ATK;
        return -1;
    }
}
