import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageDecipher extends SubThread{
    public MessageDecipher(){

    }
    private static boolean Attack(Character attacter,Character endurer){
        endurer.set("currentHP",endurer.get("currentHP")-attacter.get("currentATK"));
        if(endurer.get("currentHP")<=0) return false;
        else return true;
    }
    private static void ywPlacement(){

    }
    private static void moving(Legion A,int[] new_pos){
        A.changePosition(new_pos[0],new_pos[1]);
    }

    public static void decipher(String[] code,String[] ywList,Player_1 A,Player_2 B,Socket connection){
        if(code[0].equals("ywPlacement")){
            if(code[1].equals(A.myLegion.getLeader().getIDname())){
                for(int i=0;i<A.myLegion.getCharacters().length;i++){
                    if(code[2].equals(A.myLegion.getCharacters()[i])){
                        int yw_pos=Integer.valueOf(code[3]);
                        //暂时不实现
                    }
                }
            }
        }
        else if(code[0].equals("Attack")){
            if(code[1].equals(A.myLegion.getLeader().getIDname())){
                if(code[2].equals("999")){
                    if(code[3].equals(A.myLegion.getLeader().getIDname())){
                        Character a=A.myLegion.getLeader();
                        Character b=A.myLegion.getLeader();
                        Attack(a,b);
                    }else{
                        Character a=A.myLegion.getLeader();
                        Character b=B.myLegion.getLeader();
                        Attack(a,b);
                    }
                }
                else {
                    int yw_pos=Integer.valueOf(code[2]);
                    if(code[3].equals(A.myLegion.getLeader().getIDname())){
                        Character a=A.myLegion.getCharacters()[yw_pos];
                        Character b=A.myLegion.getCharacters()[yw_pos];
                        if(!Attack(a,b)) A.myLegion.getCharacters()[yw_pos]=new yw();
                    }else{
                        Character a=A.myLegion.getCharacters()[yw_pos];
                        Character b=B.myLegion.getCharacters()[yw_pos];
                        if(!Attack(a,b)) B.myLegion.getCharacters()[yw_pos]=new yw();
                    }
                }
            }
            else{
                if(code[2].equals("999")){
                    if(code[3].equals(A.myLegion.getLeader().getIDname())){
                        Character a=B.myLegion.getLeader();
                        Character b=A.myLegion.getLeader();
                        Attack(a,b);
                    }else{
                        Character a=B.myLegion.getLeader();
                        Character b=B.myLegion.getLeader();
                        Attack(a,b);
                    }
                }
                else{
                    int yw_pos=Integer.valueOf(code[2]);
                    if(code[3].equals(A.myLegion.getLeader().getIDname())){
                        Character a=B.myLegion.getCharacters()[yw_pos];
                        Character b=A.myLegion.getCharacters()[yw_pos];
                        if(!Attack(a,b)) A.myLegion.getCharacters()[yw_pos]=new yw();
                    }else{
                        Character a=B.myLegion.getCharacters()[yw_pos];
                        Character b=B.myLegion.getCharacters()[yw_pos];
                        if(!Attack(a,b)) B.myLegion.getCharacters()[yw_pos]=new yw();
                    }
                }
            }
        }
        else if(code[0].equals("Moving")){
            int pos_x=Integer.valueOf(code[1].substring(0,1));
            int pos_y=Integer.valueOf(code[1].substring(1,2));
            A.myLegion.changePosition(pos_x,pos_y);
        }

    }
}
