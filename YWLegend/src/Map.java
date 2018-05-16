public class Map {
    /*
        Planning: 使用二维军团数组表达地图格子。每一个玩家有一个地图，上面包括了所有的信息，但是根据可见形式显示给玩家
        1. 一个军团代表一个格子，如果为空格传入null。总共有两个有效军团格子
        2. 战争迷雾范围
        3. 群体攻击范围
     */
    public Legion[][] mapArray;

    Map(){
        mapArray=new Legion[5][5];
        for(int i=0;i<mapArray.length;i++){
            for(int j=0;j<mapArray[0].length;j++){
                mapArray[i][j]=null;
            }
        }
    }
    Map(int n,Legion Player_1,Legion Player_2){//玩家1为主玩家
        mapArray=new Legion[n][n];
        initial_MapArray(Player_1,Player_2);
        //setVisible();
    }
    private void initial_MapArray(Legion Player_1,Legion Player_2){
        for(int i=0;i<mapArray.length;i++){
            for(int j=0;j<mapArray[0].length;j++){
                //检索Legion对象，赋值
                if(Player_1.Legion_pos[0]==i&&Player_1.Legion_pos[1]==j) mapArray[i][j]=Player_1;
                else if(Player_2.Legion_pos[0]==i&&Player_2.Legion_pos[1]==j) mapArray[i][j]=Player_2;
                else mapArray[i][j]=new Legion();
            }
        }
    }
    public void change_MapArray(Legion changedLegion){
        int i=changedLegion.temp_pos[0];
        int j=changedLegion.temp_pos[1];
        mapArray[i][j].setVisible(true);
    }
    public void display_Map(){//Map地图显示信息

    }
}
