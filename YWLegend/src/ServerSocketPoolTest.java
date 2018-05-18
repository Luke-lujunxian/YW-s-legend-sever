
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
                service.submit(new SubThread(connection));
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



class SubThread extends Thread{
    private Socket connection;
    private Personage a;
    private String message;
    public SubThread(Socket conSocket){
        this.connection=conSocket;
    }

    public void run(){
        try {
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