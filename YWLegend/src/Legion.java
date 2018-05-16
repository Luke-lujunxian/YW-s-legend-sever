public class Legion {
    /*
        Planning: 使用对象Array完成军团legion的组成
        1. 一个Array对象包括5个yw对象，其中一个为角色、4个为军团头领
        2. 构造函数负责初始化Array对象，分为无参default构造函数（全部数组对象为null）和有参构造函数，传入所有yw对象，如该位置没有，传入null对象
        3. 修改对象数组中内容的修改器，传入新的对象，重新指向新对象（其它对象内部的修改不需要修改器执行）
        4. 访问器根绝前端需求输出yw对象内部的成员量
     */
    public int[] Legion_pos={0,0};//军团位置（即为军团所处格子的位置）
    //public int[] chara_pos;//计划用数组来储存角色信息和yw信息
    //public String[] specialChara_pos;
    //public int[][] yw_pos;
    //public String[][] specialYw_pos;//yw使用二维数组储存信息，一行为一个yw长度为yw成员变量个数，列数位yw个数
    private yw[] characters;
    private Personage leader;

    Legion(){
        /*
            chara_pos=new int[3];
            yw_pos=new int[3][3];
            specialChara_pos=new String[2];
            specialYw_pos=new String[3][2];
         */
        //Legion_pos={0,0};
        characters=new yw[5];
        for(int i=0;i<characters.length;i++){
            characters[i]=null;
        }
    }
    Legion(Personage character,yw placement_1,yw placement_2,yw placement_3,yw placement_4,int pos_x,int pos_y){
        /*
            chara_pos=new int[2];
            yw_pos=new int[3][3];
            specialChara_pos=new String[2];
            specialYw_pos=new String[3][2];
         */
        characters=new yw[4];
        initial_status(character,placement_1,placement_2,placement_3,placement_4,pos_x,pos_y);
        output_status();
    }
    public void initial_status(Personage character,yw placement_1,yw placement_2,yw placement_3,yw placement_4,int pos_x,int pos_y){//初始化信息，欲待完善
        //characters[0]=character;
        leader=character;
        characters[0]=placement_1;
        characters[1]=placement_2;
        characters[2]=placement_3;
        characters[3]=placement_4;
        Legion_pos[0]=pos_x;
        Legion_pos[1]=pos_y;
    }
    public void output_status(){//输出内部信息根据前端要求做详细代码处理

    }
    public void detect_status(){//检测信息变化，现在发现这个好像没什么用

    }
    public void change_status(int n,yw placement_n,int newPos_x,int newPos_y){//改变对应信息
        characters[n]=placement_n;
        Legion_pos[0]=newPos_x;
        Legion_pos[1]=newPos_y;
    }
}
