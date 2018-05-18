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

    public static String beforeGameSelfChecking (String checkingWords) {
        if(checkingWords=="") return "LJXZDL";
        return "not good";
    }



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
            serverSocket=new ServerSocket(5556);
            for(int i=0;i<=1;i++) {
                Socket connection =serverSocket.accept();
                if(i==0){
                    new_playerOne=new SubThread(connection);
                    service.submit(new_playerOne);
                }
                if(i==1){
                    new_playerTwo=new SubThread(connection);
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
        ServerSocketOnlyAcceptTwo(playerOne,playerTwo);

    }

}
