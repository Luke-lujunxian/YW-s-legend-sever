public class Legion {
    /*
        Planning: 使用对象Array完成军团legion的组成
        1. 一个Array对象包括5个yw对象，其中一个为角色、4个为军团头领
        2. 构造函数负责初始化Array对象，分为无参default构造函数（全部数组对象为null）和有参构造函数，传入所有yw对象，如该位置没有，传入null对象
        3. 修改对象数组中内容的修改器，传入新的对象，重新指向新对象（其它对象内部的修改不需要修改器执行）
        4. 访问器根绝前端需求输出yw对象内部的成员量
     */
    public int[] Legion_pos={0,0};//军团位置（即为军团所处格子的位置）
    int[] temp_pos=new int[2];//军团改变前位置
    //public int[] chara_pos;//计划用数组来储存角色信息和yw信息
    //public String[] specialChara_pos;
    //public int[][] yw_pos;
    //public String[][] specialYw_pos;//yw使用二维数组储存信息，一行为一个yw长度为yw成员变量个数，列数位yw个数
    private boolean[][] Legion_visibleMap;
    private yw[] characters;//
    private Personage leader;//军团角色
    private boolean visible;//军团本身的格子是否于全局可见

    Legion(){//默认构造器，用于构造地图，默认为不可见
        /*
            chara_pos=new int[3];
            yw_pos=new int[3][3];
            specialChara_pos=new String[2];
            specialYw_pos=new String[3][2];
         */
        //Legion_pos={0,0};
        temp_pos=Legion_pos;
        Legion_visibleMap=new boolean[5][5];
        characters=new yw[4];
        /*for(int i=0;i<Legion_visibleMap.length;i++){
            for(int j=0;j<Legion_visibleMap[0].length;j++){
                Legion_visibleMap[i][j]=false;
            }
        }*/
        setLegion_visibleMap(temp_pos,Legion_pos);
        for(int i=0;i<characters.length;i++){
            characters[i]=null;
        }
        setVisible(false);//默认不可见
    }

    Legion(Personage character,yw placement_1,yw placement_2,yw placement_3,yw placement_4,int pos_x,int pos_y){
        /*
            chara_pos=new int[2];
            yw_pos=new int[3][3];
            specialChara_pos=new String[2];
            specialYw_pos=new String[3][2];
         */
        temp_pos=Legion_pos;
        Legion_visibleMap=new boolean[5][5];
        characters=new yw[4];
        setLegion_visibleMap(temp_pos,Legion_pos);
        initial_status(character,placement_1,placement_2,placement_3,placement_4,pos_x,pos_y);
        setVisible(true);
        output_status();
    }
    public void setLegion_visibleMap(int[] temp_pos,int[] Legion_pos){
        for(int i=0;i<Legion_visibleMap.length;i++){
            for(int j=0;j<Legion_visibleMap[0].length;j++){
                if(i==Legion_pos[0]&&j==Legion_pos[j]) Legion_visibleMap[i][j]=true;
                else if(i==temp_pos[0]&&j==temp_pos[j]) Legion_visibleMap[i][j]=true;
                else Legion_visibleMap[i][j]=false;
            }
        }
    }
    public boolean[][] getLegion_visibleMap(){
        return this.Legion_visibleMap;
    }
    public boolean getVisible(){//可见性访问器
        return this.visible;
    }
    public void setVisible(boolean visible){
        this.visible=visible;
    }
    private void initial_status(Character character,yw placement_1,yw placement_2,yw placement_3,yw placement_4,int pos_x,int pos_y){//初始化信息，欲待完善
        //characters[0]=character;
        if(character instanceof  Personage) leader=(Personage)character;
        //else throw new Exception("noPersoange");
        characters[0]=placement_1;
        placement_1.yw_pos=0;
        characters[1]=placement_2;
        placement_2.yw_pos=1;
        characters[2]=placement_3;
        placement_3.yw_pos=2;
        characters[3]=placement_4;
        placement_4.yw_pos=3;
        Legion_pos[0]=pos_x;
        Legion_pos[1]=pos_y;
    }
    private void output_status(){//输出内部信息根据前端要求做详细代码处理

    }
    private void detect_status(){//检测信息变化，现在发现这个好像没什么用

    }
    public void change_status(int n,int n_new,yw placement_n,int newPos_x,int newPos_y){//改变对应信息
        //characters[n]=placement_n;
        changePosition(newPos_x,newPos_y);
        //changeYwPosition(n,n_new);
        setLegion_visibleMap(temp_pos,Legion_pos);
    }
    public void changeYwPosition(int new_position,yw A){//设定军团中yw的位置
        //characters[old_position].yw_pos=new_position;
        A=new yw();
        characters[new_position].yw_pos=new_position;
        //yw temp=characters[old_position];
        //characters[old_position]=characters[new_position];
        //characters[new_position]=temp;
    }
    public void changePosition(int newPos_x,int newPos_y){//改变军团在Map类中的位置
        temp_pos[0]=Legion_pos[0];
        temp_pos[1]=Legion_pos[1];
        Legion_pos[0]=newPos_x;
        Legion_pos[1]=newPos_y;
        //return temp_pos;
    }

    public yw[] getCharacters(){
        return characters;
    }

    public void setCharacters(yw new_yw,int pos){
        characters[pos]=new_yw;
    }

    public Personage getLeader() {
        return leader;
    }
}
