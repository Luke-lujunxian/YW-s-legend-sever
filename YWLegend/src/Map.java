public class Map {
    /*
        Planning: 使用二维军团数组表达地图格子。
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
    Map(int n,Legion Player_1,Legion Player_2){
        mapArray=new Legion[n][n];
        setMapArray(Player_1,Player_2);
    }
    private void setMapArray(Legion Player_1,Legion Player_2){
        for(int i=0;i<mapArray.length;i++){
            for(int j=0;j<mapArray[0].length;j++){
                //检索Legion对象
                if(Player_1.Legion_pos[0]==i&&Player_1.Legion_pos[1]==j) mapArray[i][j]=Player_1;
                else if(Player_2.Legion_pos[0]==i&&Player_2.Legion_pos[1]==j) mapArray[i][j]=Player_2;
                else mapArray[i][j]=null;//未完成
            }
        }
    }
    public void display_Map(){//Map地图显示信息

    }
}
