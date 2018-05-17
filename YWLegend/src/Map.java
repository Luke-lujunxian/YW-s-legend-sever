public class Map {
    /*
        Planning: 使用二维军团数组表达地图格子。每一个玩家有一个地图，上面包括了所有的信息，但是根据可见形式显示给玩家
        1. 一个军团代表一个格子，如果为空格传入null。总共有两个有效军团格子
        2. 战争迷雾范围
        3. 群体攻击范围
        * *此地图为全局地图，军团可视化地图在军团类中单独同步
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
    Map(int n,Legion Player_1,Legion Player_2){//全局地图有参构造函数
        mapArray=new Legion[n][n];
        initial_MapArray(Player_1,Player_2);
        //setVisible();
    }
    private void initial_MapArray(Legion Player_1,Legion Player_2){//地图初始化，传入两个Player军团
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
        //对于玩家本身，其军团经历过的格子会变为可见；同时军团在mapArray数组上的位置会变动
        mapArray[changedLegion.Legion_pos[0]][changedLegion.Legion_pos[1]]=changedLegion;
        mapArray[changedLegion.temp_pos[0]][changedLegion.temp_pos[1]]=new Legion();
        int i=changedLegion.temp_pos[0];
        int j=changedLegion.temp_pos[1];
        mapArray[i][j].setVisible(true);
    }
    public Legion[][] display_Map(Legion Player){
        //针对玩家显示Map地图信息,判断主地图mapArray与玩家可见地图Legion_visibleMap的每一个方块
        Legion[][] temp_visible=new Legion[5][5];
        for(int i=0;i<mapArray.length;i++){
            for(int j=0;j<mapArray[0].length;j++){
                if(Player.getLegion_visibleMap()[i][j]) temp_visible[i][j]=mapArray[i][j];
                else temp_visible[i][j]=new Legion();
            }
        }
        return temp_visible;
    }
}
