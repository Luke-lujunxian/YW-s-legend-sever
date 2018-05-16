public class yw implements Character{//有待接口化

    private Character character;
    public String name;
    private String phyle;
    private String religion;
    private String saying;
    private int energy;
    private int blood;
    private int attack;
    private int attackRange;
    private int currentHP;

    public yw(){
    }
    public yw(String yname,String yphyle,String yreligion){
        name = yname;
        phyle = yphyle;
        religion = yreligion;
            energy = 1;
            blood = 1;
            attack = 1;
            attackRange = 1;
            //ability 待实现
            saying = "这是一个尹巍（出现尹巍时请重启游戏并回报bug）";
            character = new Personage();
    }

    public String getPhyle(){
        return this.phyle;
    }
    public String getReligion(){
        return this.religion;
    }
    public int getBlood(){
        return this.blood;
    }
    public int getEnergy(){
        return this.energy;
    }
    public void setEnergy(int energy) { this.energy = energy; }
    public int getAttack(){
        return this.attack;
    }
    public int getAttackRange(){
        return this.attackRange;
    }
    public void setAttackRange(int attackRange) { this.attackRange = attackRange; }
    public String getInfo(){//实际数据投影
        return name+" ("+energy+"/"+blood+"/"+attack+"/"+attackRange+")";
    }
    public String die(){//阵亡
        return saying;
    }
    public void getHurt(int hurt){//受伤
        blood-=hurt;
    }
    public void getRecure(int newBlood,int newAttack){//回复
        blood+=newBlood;
        attack+=newAttack;
    }
    public void skill() {

    }
    public void set(String d,int v) {
        if(d.equals("power")) energy=v;
        else if(d.equals("HP")) blood=v;
        else if(d.equals("currentHP")) currentHP=v;
        else if(d.equals("ATK")) attack=v;
    }
    public int get(String d) {
        if(d.equals("power")) return energy;
        else if(d.equals("HP")) return blood;
        else if(d.equals("currentHP")) return currentHP;
        else if(d.equals("ATK")) return attack;
        return -1;
    }
}