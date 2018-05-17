import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket服务器端测试类 
 * @author zzj
 * @date Jul 14, 2016 11:35:32 AM 
 */
public class SeverSocketTest {

    public static void main(String[] args) {
        testCommon();
    }

    /**
     * 1.测试普通的server 
     * @author zzj
     */
    public static void testCommon(){
        ServerSocket serverSocket=null;
        try {
            serverSocket = new ServerSocket(5556);
            while(true){
                System.out.println("wait receive message from client...");
                //接收客户端连接的socket对象  
                Socket connection =null;
                try {
                    //接收客户端传过来的数据，会阻塞  
                    connection=serverSocket.accept();

                    System.out.println("****received message from client******");

                    //向客户端写入数据
                    writeMsgToClient(connection.getOutputStream(),"123456789");

                    //读取客户端传过来的数据  
                    readMessageFromClient(connection.getInputStream());

                    System.out.println("****received message from client end******\n");


                    connection.getInputStream().close();
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally{
                    if (connection!=null) {
                        connection .close();
                    }
                }
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

    /**
     * 读取客户端信息 
     * @param inputStream
     */
    private static void readMessageFromClient(InputStream inputStream) throws IOException {
        Reader reader = new InputStreamReader(inputStream);
        BufferedReader br=new BufferedReader(reader);
        String a = null;
        while((a=br.readLine())!=null){
            System.out.println(a);
        }

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
        //writer.close();
    }
}