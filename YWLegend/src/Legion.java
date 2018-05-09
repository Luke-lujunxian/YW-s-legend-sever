public class Legion {
    public int[] chara_pos;//计划用数组来储存角色信息和yw信息
    public String[] specialChara_pos;
    public int[][] yw_pos;
    public String[][] specialYw_pos;//yw使用二维数组储存信息，一行为一个yw长度为yw成员变量个数，列数位yw个数

    Legion(){
        chara_pos=new int[3];
        yw_pos=new int[3][3];
        specialChara_pos=new String[2];
        specialYw_pos=new String[3][2];
    }
    Legion(yw character,yw placement_1,yw placement_2,yw placement_3,yw placement_4){
        chara_pos=new int[2];
        yw_pos=new int[3][3];
        specialChara_pos=new String[2];
        specialYw_pos=new String[3][2];
        initial_status(character,placement_1,placement_2,placement_3,placement_4);
    }
    public void initial_status(yw character,yw placement_1,yw placement_2,yw placement_3,yw placement_4){//初始化信息，欲待完善
        int i=0;
            chara_pos[i]=character.getAttack();
            chara_pos[i+1]=character.getAttackRange();
            chara_pos[i+2]=character.getBlood();
            for(int k=0;k<3;k++){//分别给三个yw赋值
                //yw_pos[k][i]=placement_1
            }
        for(int j=0;;){
            specialChara_pos[i]=placement_1.getInfo();
        }
    }
    public void detect_status(){//检测信息变化

    }
    public void change_status(){//改变对应信息

    }
}
