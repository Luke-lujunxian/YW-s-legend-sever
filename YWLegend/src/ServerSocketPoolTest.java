
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

public class ServerSocketPoolTest  {
    public static void main(String[] args) {
        testCommon();
    }
    public static void testCommon(){
        ServerSocket serverSocket=null;
        //定义一个容量为50的线程  
        ExecutorService service = Executors.newFixedThreadPool(50);
        try {
            serverSocket = new ServerSocket(5556);
            while(true){
                Socket connection =null;
                connection=serverSocket.accept();
                service.submit(new SubThread(connection,1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (serverSocket!=null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



class SubThread extends Thread implements Runnable{
    private Socket connection;
    private Personage a;
    private String message;
    private int number;

    public SubThread(Socket conSocket, int new_number){
        this.connection=conSocket;
        number=new_number;
    }

    public String[] DecodeFromClient(String m){
        return m.split("\\u00A1");
    }

    public void Construct8YW(String[] ywNameList, yw[] ywList,Personage player){
        for(int i=0;i<8;i++){
            if(ywNameList[i]=="FailTrial1") ywList[i]=new yw_FailTrial1(player);
            if(ywNameList[i]=="FailTrial2") ywList[i]=new yw_FailTrial2(player);
            if(ywNameList[i]=="FailTrial3") ywList[i]=new yw_FailTrial3();
            if(ywNameList[i]=="FailTrial4") ywList[i]=new yw_FailTrial4();
            if(ywNameList[i]=="FailTrial5") ywList[i]=new yw_FailTrial5();
            if(ywNameList[i]=="FailTrial6") ywList[i]=new yw_FailTrial6();
            if(ywNameList[i]=="FailTrial7") ywList[i]=new yw_FailTrial7();
            if(ywNameList[i]=="FailTrial8") ywList[i]=new yw_FailTrial8(player);
            if(ywNameList[i]=="FailTrial9") ywList[i]=new yw_FailTrial9(player);
            if(ywNameList[i]=="FailTrial10") ywList[i]=new yw_FailTrial10();
            if(ywNameList[i]=="FailTrial11") ywList[i]=new yw_FailTrial11();
            if(ywNameList[i]=="FailTrial12") ywList[i]=new yw_FailTrial12();
        }
    }

    public void run(){
        try {
            /*
            客户端身份验证
            */
            message=readMessageFromClient(connection.getInputStream());
            if(message=="HelloIamClient"){
                writeMsgToClient(connection.getOutputStream(),"FuckYou");
            }
            /*
            * 初始人物
            * */
            Personage player1=null;
            Personage player2=null;

            /*
            * 传入玩家ID
            * */
            message=readMessageFromClient(connection.getInputStream());
            player1=new Personage(message);

            /*
            * 接受匹配请求
            * */
            message=readMessageFromClient(connection.getInputStream());
            if(message=="askformatching"){
                writeMsgToClient(connection.getOutputStream(),"matchingaccpt");
            }

            /*解码后String数组里面的内容
            * cardsetinfo
            * 角色名称   暂时只有一个，所以就直接调用了
            * yw1
            * yw2
            * yw3
            * yw4
            * yw5
            * yw6
            * yw7
            * yw8
            * */
            message=readMessageFromClient(connection.getInputStream());
            String[] decodeMessage=DecodeFromClient(message);
            player1= new Personage_UndefinedSpecies_UndefinedReligion_UndefinedName(player1.getIDname());

            /*
            军团成员初始化
             */
            String[] ywNameList=new String[8];
            for(int i=0;i<8;i++){
                ywNameList[i]=decodeMessage[i+1];
            }
            yw[] ywList=new yw[8];
            Construct8YW(ywNameList,ywList,player1);
            Legion hanLegion=null;
            if(number==1){
                hanLegion=new Legion(player1,null,null,null,null,0,0);
            }
            if(number==2){
                hanLegion=new Legion(player1,null,null,null,null,4,4);
            }







            writeMsgToClient(connection.getOutputStream(),"connected!");
            message=readMessageFromClient(connection.getInputStream());
            //初始化a，调用主类的初始化方法，传入一个客户端发送的String参数，代表初始化参数，返回一个personage对象
            //waiting to be implement
            writeMsgToClient(connection.getOutputStream(),"Initialized success!");
            while(true) {
                //接收客户端参数，需决定客户端传来什么类型的参数
                message=readMessageFromClient(connection.getInputStream());
                //调用主类的方法，传入一个personage对象和message作为参数，表示主类按照客户端发送的message对a进行处理，返回一个String,表示返回给客户端的参数
                //waiting to be implement

                //向客户端发送参数
                writeMsgToClient(connection.getOutputStream(),message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
                try {
                    connection .close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    /**
     * 读取客户端信息
     * @param inputStream
     */
    private static String readMessageFromClient(InputStream inputStream) throws IOException {
        Reader reader = new InputStreamReader(inputStream);
        BufferedReader br=new BufferedReader(reader);
        String a =new String(),b=null;
        while((b=br.readLine())!=null){
            a+=b;
        }
        return a;
    }

    /**
     * 响应客户端信息
     * @param outputStream
     * @param string
     */
    private static void writeMsgToClient(OutputStream outputStream, String string) throws IOException {
        Writer writer = new OutputStreamWriter(outputStream);
        writer.append(String.format("%4d",string.length()));
        writer.append(string);
        writer.flush();
    }
}


