import javax.security.auth.Subject;
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

public class Main {





    public static String middleTurn (String request, Object a, Object b, Object c, Object d, Object e) {
        switch (request){
            case "la": {

            }
            case "ba": {

            }
        }
        return null;
    }


    public static void ServerSocketOnlyAcceptTwo(SubThread new_playerOne, SubThread new_playerTwo){
        ServerSocket serverSocket = null;
        ExecutorService service = Executors.newFixedThreadPool(2);
        try{
            System.out.println("***Begin receiving client's message***");
            serverSocket=new ServerSocket(8818);
            for(int i=0;i<=1;i++) {
                Socket connection =serverSocket.accept();
                if(i==0){
                    new_playerOne=new Player_1(connection,1);
                    service.submit(new_playerOne);
                }
                if(i==1){
                    new_playerTwo=new Player_2(connection,2);
                    service.submit(new_playerTwo);
                }
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main (String[] args) {
        System.out.println("\u00A1  i");
        System.out.println("***This is sever!***");
        System.out.println("***Sever is now active!***");
        SubThread playerOne=null;
        SubThread playerTwo=null;
        SubThread mainThread=null;
        ServerSocketOnlyAcceptTwo(playerOne,playerTwo);
        mainThread = new Main_Thread(playerOne,playerTwo);
        Player_1.setMainThread(mainThread);
        Player_2.setMainThread(mainThread);
    }

}
