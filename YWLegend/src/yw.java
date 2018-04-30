/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lenovo
 */
public class yw {//鏈夊緟鎺ュ彛鍖�
    public String name;
    private String phyle;
    private String religion;
    private String saying;
    private int energy;
    private int blood;
    private int attack;
    private int attackRange;
    public yw(){
    }
    public yw(String yname,String yphyle,String yreligion){
        name = yname;
        phyle = yphyle;
        religion = yreligion;
        if (name=="muslim"){
            energy = 10;
            blood = 100;
            attack = 5;
            attackRange = 1;
            //ability 寰呭疄鐜�
            saying = "鎴戠殑涔岀帥锛屾洐鍏夊凡鐜�";}
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
    public int getAttack(){
        return this.attack;
    }
    public int getAttackRange(){
        return this.attackRange;
    }
    public String getInfo(){//瀹為檯鏁版嵁鎶曞奖
        return name+" ("+energy+"/"+blood+"/"+attack+"/"+attackRange+")";
    }
    public String die(){//闃典骸
        return saying;
    }
    public void getHurt(int hurt){//鍙椾激
        blood-=hurt;
    }
    public void getRecure(int newBlood,int newAttack){//鍥炲
        blood+=newBlood;
        attack+=newAttack;
    }

}
