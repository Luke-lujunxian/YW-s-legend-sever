import java.util.Scanner;

public class Map {
    /*
        Planning: 使用二维军团数组表达地图格子，一个军团代表一个格子，如果为空格传入null
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
    Map(int n){
        mapArray=new Legion[n][n];
        for(int i=0;i<mapArray.length;i++){
            for(int j=0;j<mapArray[0].length;j++){
                //检索Legion对象
                mapArray[i][j]=null;//未完成
            }
        }
    }
    public void display_Map(){//Map地图显示信息

    }
}
