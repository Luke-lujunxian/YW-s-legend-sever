
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

class Player_1 extends SubThread implements Runnable{
    private static Main_Thread mainThread = new Main_Thread();
    private Player_2 player2Information=null;
    private Personage player1=null;
    public int breakNumber=0;
    private String victoryOrDeath="";

    public void setVictoryOrDeath(String victoryOrDeath) {
        this.victoryOrDeath = victoryOrDeath;
    }

    public Personage getPlayer1() {
        return player1;
    }


    public Player_2 getPlayer2Information() {
        return player2Information;
    }

    public void setPlayer2Information(Player_2 player2Information) {
        this.player2Information = player2Information;
    }

    public static void setMainThread(Main_Thread new_mainThread) {
        mainThread = new_mainThread;
    }

    public static SubThread getMainThread() {
        return mainThread;
    }
    public Player_1(){}

    public Player_1(Socket conSocket, int new_number){
        super(conSocket,new_number);
    }
    public Legion myLegion=null;
    public void run(){
        try {
            synchronized (mainThread){
                /**
                客户端身份验证
                */
                writeMsgToClient(getConnection().getOutputStream(),"connected!1");
                setMessage(readMessageFromClient(getConnection().getInputStream()));
                System.out.println(getMessage());
                if(getMessage().equals("HelloIamClient")){
                    writeMsgToClient(getConnection().getOutputStream(),"FuckYou");
                }else{
                    writeMsgToClient(getConnection().getOutputStream(),"youareplayer1");
                }
                /**
                 * 初始人物
                 * */


                /**
                 * 传入玩家ID
                 * */
                setMessage(readMessageFromClient(getConnection().getInputStream()));
                player1=new Personage(getMessage());

                /**
                 * 接受匹配请求
                 * */
                setMessage(readMessageFromClient(getConnection().getInputStream()));
                mainThread.notify();

                /**
                 * 等待player2准备好前序工作
                 * 等待时间为一分半
                 * */
                this.wait(90000);



                /**解码后String数组里面的内容
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
                setMessage(readMessageFromClient(getConnection().getInputStream()));
                String[] decodeMessage=DecodeFromClient(getMessage());
                player1= new Personage_UndefinedSpecies_UndefinedReligion_UndefinedName(player1.getIDname());

                /**
                *军团成员初始化
                *并设军团置默认初始位置
                * */
                String[] ywNameList=new String[8];
                for(int i=0;i<8;i++){
                    ywNameList[i]=decodeMessage[i+1];
                }
                yw[] ywList=new yw[8];
                Construct8YW(ywNameList,ywList,player1);
                yw yw1=new yw();
                yw yw2=new yw();
                yw yw3=new yw();
                yw yw4=new yw();
                myLegion=new Legion(player1,yw1,yw2,yw3,yw4,4,4);

                /**
                 * 等待传入player2的资料
                 * 传回player2的id和名字给player1的客户端
                 * */
                mainThread.notify();
                this.wait(90000);
                String[] outPutStringArray={"matchingaccpt",player2Information.getPlayer2().getIDname(),player2Information.getPlayer2().getName()};
                writeMsgToClient(getConnection().getOutputStream(),outputDataForm(outPutStringArray));

                /**
                 * 传入所选择的八个yw并保存
                 * */
                setMessage(readMessageFromClient(getConnection().getInputStream()));
                decodeMessage=DecodeFromClient(getMessage());
                String[] allSellectedYWName=new String[8];
                for(int k=2;k<10;k++){
                    allSellectedYWName[k-2]=decodeMessage[k];
                }

                /**
                 * 等待player2完成yw初始化
                 * */
                mainThread.notify();
                this.wait();

                /**
                 * 将初始化后己方军团和对方军团的位置发给客户端
                 * */
                String[] outPutStringArray2={"Mapinitialized",myLegion.Legion_pos[0]+""+myLegion.Legion_pos[1],player2Information.myLegion.Legion_pos[0]+""+player2Information.myLegion.Legion_pos[1],"1"};
                writeMsgToClient(getConnection().getOutputStream(),outputDataForm(outPutStringArray2));

                /**
                 * 等待客户端加载成功
                 * 也等待对手加载
                 * */
                setMessage(readMessageFromClient(getConnection().getInputStream()));
                mainThread.notify();
                this.wait();
                writeMsgToClient(getConnection().getOutputStream(),"BothPlayerReady");

                /**
                * 声明两个list来储存yw
                * 一个是中回合开始时运行的skill
                * 另一是中回合结束时运行的skill
                * */
                List<yw> startRoundSkill=new ArrayList<yw>();
                List<yw> endRoundSkill=new ArrayList<yw>();

                /**
                * 中回合开始
                * 循环直到有一个人物死亡为止
                * */
                while(true){

                    /**
                    * 中回合开始时运行的skill运行，并返回操作和结果给客户端
                    * 重置startRoundSkill 这个List
                    * */
                    for(yw a: startRoundSkill){
                        a.skill();
                        String[] lala={"SkillActivate",player1.getIDname(),"999"};//因为只会修改人物的信息所以暂时先这样写
                        writeMsgToClient(getConnection().getOutputStream(),outputDataForm(lala));
                        writeMsgToClient(getPlayer2Information().getConnection().getOutputStream(),outputDataForm(lala));
                    }

                    /**
                     * 返回所有军团的具体情况给客户端
                    * */
                    writeMsgToClient(getConnection().getOutputStream(),"AllSkillEndAndResult"+"\u00A1"+Map.reportOfAllMapComponents(this,getPlayer2Information()));
                    writeMsgToClient(getPlayer2Information().getConnection().getOutputStream(),"AllSkillEndAndResult"+"\u00A1"+Map.reportOfAllMapComponents(this,getPlayer2Information()));
                    writeMsgToClient(getConnection().getOutputStream(),"End");
                    writeMsgToClient(getPlayer2Information().getConnection().getOutputStream(),"End");
                    startRoundSkill=new ArrayList<yw>();

                    /**
                    * 接收每一次客户的请求，并返回对应的操作和结果给客户端
                    * */
                    while(true){
                        setMessage(readMessageFromClient(getConnection().getInputStream()));
                        String[] decodeAfter=DecodeFromClient(getMessage());

                        /**
                         * 若客户端传入TerminateMyturn，则会跳出此循环
                        * */
                        if(decodeAfter[0].equals("TerminateMyturn")){
                            writeMsgToClient(getConnection().getOutputStream(),"TerminateConfirmed");
                            break;
                        }
                        MessageDecipher.decipher(decodeAfter,this,getPlayer2Information(),startRoundSkill,endRoundSkill);
                    }

                    /**
                     * 中回合结束时运行的skill运行，并返回操作和结果给客户端
                     * 重置endRoundSkill 这个List
                     * */
                    for(yw a: endRoundSkill){
                        a.skill();
                        String[] lala={"SkillActivate",player1.getIDname(),"999"};//因为只会修改人物的信息所以暂时先这样写
                        writeMsgToClient(getConnection().getOutputStream(),outputDataForm(lala));
                        writeMsgToClient(getPlayer2Information().getConnection().getOutputStream(),outputDataForm(lala));
                    }

                    /**
                     * 返回所有军团的具体情况给客户端
                     * */
                    writeMsgToClient(getConnection().getOutputStream(),"AllSkillEndAndResult"+"\u00A1"+Map.reportOfAllMapComponents(this,getPlayer2Information()));
                    writeMsgToClient(getPlayer2Information().getConnection().getOutputStream(),"AllSkillEndAndResult"+"\u00A1"+Map.reportOfAllMapComponents(this,getPlayer2Information()));
                    writeMsgToClient(getConnection().getOutputStream(),"End");
                    writeMsgToClient(getPlayer2Information().getConnection().getOutputStream(),"End");
                    endRoundSkill=new ArrayList<yw>();

                    /**
                     * 传回主线程，并进行下一个玩家的turn
                     * */
                    mainThread.notify();
                    wait();
                    if(breakNumber!=0) break;
                }

                /**
                * 判断胜负
                * */
                if(victoryOrDeath.equals("Victory")) writeMsgToClient(getConnection().getOutputStream(),"Result"+"\u00A1"+"Victory");
                if(victoryOrDeath.equals("Lose")) writeMsgToClient(getConnection().getOutputStream(),"Result"+"\u00A1"+"Lose");


            }

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                getConnection().close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

class Player_2 extends SubThread implements Runnable{
    private static Main_Thread mainThread = new Main_Thread();
    private Player_1 player1Information=null;
    private Personage player2=null;
    public int breakNumber=0;
    private String victoryOrDeath="";

    public void setVictoryOrDeath(String victoryOrDeath) {
        this.victoryOrDeath = victoryOrDeath;
    }

    public Player_2(){}

    public Personage getPlayer2() {
        return player2;
    }

    public Player_1 getPlayer1Information() {
        return player1Information;
    }

    public void setPlayer1Information(Player_1 player1Information) {
        this.player1Information = player1Information;
    }



    public static void setMainThread(Main_Thread new_mainThread) {
        mainThread = new_mainThread;
    }

    public static SubThread getMainThread() {
        return mainThread;
    }
    public Player_2(Socket conSocket, int new_number){
        super(conSocket,new_number);
    }

    public Legion myLegion=null;
    public void run(){
        try {
            synchronized (mainThread){
                /**
            客户端身份验证
            */
                writeMsgToClient(getConnection().getOutputStream(),"connected!2");
                setMessage(readMessageFromClient(getConnection().getInputStream()));
                if(getMessage().equals("HelloIamClient")){
                    writeMsgToClient(getConnection().getOutputStream(),"FuckYou");
                }else{
                    writeMsgToClient(getConnection().getOutputStream(),"youareplayer2");
                }
                /**
                 * 初始人物
                 * */


                /**
                 * 传入玩家ID
                 * */
                setMessage(readMessageFromClient(getConnection().getInputStream()));
                player2=new Personage(getMessage());

                /**
                 * 接受匹配请求
                 * */
                setMessage(readMessageFromClient(getConnection().getInputStream()));
                mainThread.notify();

                /**
                 * 等待player1准备好前序工作
                 * 等待时间为一分半
                 * */
                this.wait(90000);
                writeMsgToClient(getConnection().getOutputStream(),"matchingaccpt");

                /**解码后String数组里面的内容
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
                setMessage(readMessageFromClient(getConnection().getInputStream()));
                String[] decodeMessage=DecodeFromClient(getMessage());
                player2= new Personage_UndefinedSpecies_UndefinedReligion_UndefinedName(player2.getIDname());

                /**
                 *军团成员初始化
                 *并设军团置默认初始位置
                 * */
                String[] ywNameList=new String[120];
                for(int i=0;i<8;i++){
                    ywNameList[i]=decodeMessage[i+1];
                }
                yw[] ywList=new yw[8];
                Construct8YW(ywNameList,ywList,player2);
                yw yw1=new yw();
                yw yw2=new yw();
                yw yw3=new yw();
                yw yw4=new yw();
                myLegion=new Legion(player2,yw1,yw2,yw3,yw4,4,4);

                /**
                 * 等待传入player1的资料
                 * 传回player1的id和名字给player2的客户端
                 * */
                mainThread.notify();
                this.wait(90000);
                String[] outPutStringArray1={"matchingaccpt",player1Information.getPlayer1().getIDname(),player1Information.getPlayer1().getName()};
                writeMsgToClient(getConnection().getOutputStream(),outputDataForm(outPutStringArray1));

                /**
                 * 传入所选择的八个yw并保存
                 * */
                setMessage(readMessageFromClient(getConnection().getInputStream()));
                decodeMessage=DecodeFromClient(getMessage());
                String[] allSellectedYWName=new String[8];
                for(int k=2;k<10;k++){
                    allSellectedYWName[k-2]=decodeMessage[k];
                }

                /**
                 * 等待player1完成yw初始化
                 * */
                mainThread.notify();
                this.wait();

                /**
                 * 将初始化后己方军团和对方军团的位置发给客户端
                 * */
                String[] outPutStringArray2={"Mapinitialized",myLegion.Legion_pos[0]+""+myLegion.Legion_pos[1],player1Information.myLegion.Legion_pos[0]+""+player1Information.myLegion.Legion_pos[1],"2"};
                writeMsgToClient(getConnection().getOutputStream(),outputDataForm(outPutStringArray2));

                /**
                 * 等待客户端加载成功
                 * 也等待对手加载
                 * */
                setMessage(readMessageFromClient(getConnection().getInputStream()));
                mainThread.notify();
                this.wait();
                writeMsgToClient(getConnection().getOutputStream(),"BothPlayerReady");

                /**
                 * player2是后手就会先wait
                 * */
                this.wait();
                if(breakNumber==0){
                    /**
                     * 声明两个list来储存yw
                     * 一个是中回合开始时运行的skill
                     * 另一是中回合结束时运行的skill
                     * */
                    List<yw> startRoundSkill=new ArrayList<yw>();
                    List<yw> endRoundSkill=new ArrayList<yw>();

                    /**
                     * 中回合开始
                     * 循环直到有一个人物死亡为止
                     * */
                    while(true){

                        /**
                         * 中回合开始时运行的skill运行，并返回操作和结果给客户端
                         * 重置startRoundSkill 这个List
                         * */
                        for(yw a: startRoundSkill){
                            a.skill();
                            String[] lala={"SkillActivate",player2.getIDname(),"999"};//因为只会修改人物的信息所以暂时先这样写
                            writeMsgToClient(getConnection().getOutputStream(),outputDataForm(lala));
                            writeMsgToClient(getPlayer1Information().getConnection().getOutputStream(),outputDataForm(lala));
                        }

                        /**
                         * 返回所有军团的具体情况给客户端
                         * */
                        writeMsgToClient(getConnection().getOutputStream(),"AllSkillEndAndResult"+"\u00A1"+Map.reportOfAllMapComponents(getPlayer1Information(),this));
                        writeMsgToClient(getPlayer1Information().getConnection().getOutputStream(),"AllSkillEndAndResult"+"\u00A1"+Map.reportOfAllMapComponents(getPlayer1Information(),this));
                        writeMsgToClient(getConnection().getOutputStream(),"End");
                        writeMsgToClient(getPlayer1Information().getConnection().getOutputStream(),"End");
                        startRoundSkill=new ArrayList<yw>();

                        /**
                         * 接收每一次客户的请求，并返回对应的操作和结果给客户端
                         * */
                        while(true){
                            setMessage(readMessageFromClient(getConnection().getInputStream()));
                            String[] decodeAfter=DecodeFromClient(getMessage());

                            /**
                             * 若客户端传入TerminateMyturn，则会跳出此循环
                             * */
                            if(decodeAfter[0].equals("TerminateMyturn")){
                                writeMsgToClient(getConnection().getOutputStream(),"TerminateConfirmed");
                                break;
                            }
                            MessageDecipher.decipher2(decodeAfter,this,getPlayer1Information(),startRoundSkill,endRoundSkill);
                        }

                        /**
                         * 中回合结束时运行的skill运行，并返回操作和结果给客户端
                         * 重置endRoundSkill 这个List
                         * */
                        for(yw a: endRoundSkill){
                            a.skill();
                            String[] lala={"SkillActivate",player2.getIDname(),"999"};//因为只会修改人物的信息所以暂时先这样写
                            writeMsgToClient(getConnection().getOutputStream(),outputDataForm(lala));
                            writeMsgToClient(getPlayer1Information().getConnection().getOutputStream(),outputDataForm(lala));
                        }

                        /**
                         * 返回所有军团的具体情况给客户端
                         * */
                        writeMsgToClient(getConnection().getOutputStream(),"AllSkillEndAndResult"+"\u00A1"+Map.reportOfAllMapComponents(getPlayer1Information(),this));
                        writeMsgToClient(getPlayer1Information().getConnection().getOutputStream(),"AllSkillEndAndResult"+"\u00A1"+Map.reportOfAllMapComponents(getPlayer1Information(),this));
                        writeMsgToClient(getConnection().getOutputStream(),"End");
                        writeMsgToClient(getPlayer1Information().getConnection().getOutputStream(),"End");
                        endRoundSkill=new ArrayList<yw>();

                        /**
                         * 传回主线程，并进行下一个玩家的turn
                         * */
                        mainThread.notify();
                        wait();
                        if(breakNumber!=0) break;
                    }

                }

                /**
                 * 判断胜负
                 * */
                if(victoryOrDeath.equals("Victory")) writeMsgToClient(getConnection().getOutputStream(),"Result"+"\u00A1"+"Victory");
                if(victoryOrDeath.equals("Lose")) writeMsgToClient(getConnection().getOutputStream(),"Result"+"\u00A1"+"Lose");

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                getConnection() .close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}

class Main_Thread extends SubThread implements Runnable{
    private Player_1 player1Information = new Player_1();

    private Player_2 player2Information = new Player_2();


     Main_Thread(){
      super();
    }

    Main_Thread(Player_1 player1,Player_2 player2){
        player1Information=player1;
        player2Information=player2;
    }
    public void run(){
        try {
            synchronized (player1Information){
                synchronized (player2Information){
                    /**
                     * 确认匹配成功，并传回去对手信息
                     * */
                    this.wait();
                    this.wait();
                    player1Information.notify();
                    player2Information.notify();
                    player1Information.setPlayer2Information(player2Information);
                    player2Information.setPlayer1Information(player1Information);

                    /**
                     * 确认生成军团成功
                     * */
                    this.wait();
                    this.wait();
                    player1Information.notify();
                    player2Information.notify();

                    /**
                     * 双方成功加载各自的yw
                     * */
                    this.wait();
                    this.wait();
                    player1Information.notify();
                    player2Information.notify();

                    /**
                     * 双方成功加载自己的地图
                     * */
                    this.wait();
                    this.wait();
                    player1Information.notify();
                    player2Information.notify();

                    /**
                    * 大回合循环
                    * 直到判断有一方死亡
                    * */
                    while(true){
                        this.wait();
                        if(player1Information.myLegion.getLeader().getCurrentHP()<=0||player2Information.myLegion.getLeader().getCurrentHP()<=0) break;
                        player2Information.notify();

                        this.wait();
                        if(player1Information.myLegion.getLeader().getCurrentHP()<=0||player2Information.myLegion.getLeader().getCurrentHP()<=0) break;
                        player1Information.notify();

                    }

                    /**
                    * 结束所有中回合
                    * */
                    player1Information.breakNumber=1;
                    player2Information.breakNumber=1;

                    /**
                    * 判断输赢
                    * */
                    if(player1Information.myLegion.getLeader().getCurrentHP()<=0){
                        player1Information.setVictoryOrDeath("Lose");
                        player2Information.setVictoryOrDeath("Victory");
                    }else{
                        player1Information.setVictoryOrDeath("Victory");
                        player2Information.setVictoryOrDeath("Lose");
                    }
                    player1Information.notify();
                    player2Information.notify();


                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return;
        }
    }
}

class SubThread extends Thread implements Runnable{
    private Socket connection;
    private Personage a;
    private String message;
    private int number;
    private static String importData="";
    public Legion myLegion=null;

    public SubThread(){}

    public static synchronized String outputDataForm(String[] new_importData){
        for(int i=0;i<new_importData.length;i++){
            if(i<new_importData.length-1) importData+=new_importData[i]+"\u00A1";
            else importData+=new_importData[i];
        }
        return importData;
    }

    public void setMessage(String new_message){
        message=new_message;
    }
    public synchronized String getMessage(){
        return this.message;
    }
    public int getNumber(){
        return this.number;
    }
    public synchronized Socket getConnection(){
        return this.connection;
    }
    public SubThread(Socket conSocket, int new_number){
        this.connection=conSocket;
        number=new_number;
    }

    public synchronized String[] DecodeFromClient(String m){
        return m.split("\\u00A1");
    }

    public synchronized void Construct8YW(String[] ywNameList, yw[] ywList,Personage player){
        for(int i=0;i<8;i++){
            if(ywNameList[i].equals("FailTrial1")) ywList[i]=new yw_FailTrial1(player);
            if(ywNameList[i].equals("FailTrial2")) ywList[i]=new yw_FailTrial2(player);
            if(ywNameList[i].equals("FailTrial3")) ywList[i]=new yw_FailTrial3();
            if(ywNameList[i].equals("FailTrial4")) ywList[i]=new yw_FailTrial4();
            if(ywNameList[i].equals("FailTrial5")) ywList[i]=new yw_FailTrial5();
            if(ywNameList[i].equals("FailTrial6")) ywList[i]=new yw_FailTrial6();
            if(ywNameList[i].equals("FailTrial7")) ywList[i]=new yw_FailTrial7();
            if(ywNameList[i].equals("FailTrial8")) ywList[i]=new yw_FailTrial8(player);
            if(ywNameList[i].equals("FailTrial9")) ywList[i]=new yw_FailTrial9(player);
            if(ywNameList[i].equals("FailTrial10")) ywList[i]=new yw_FailTrial10();
            if(ywNameList[i].equals("FailTrial11")) ywList[i]=new yw_FailTrial11();
            if(ywNameList[i].equals("FailTrial12")) ywList[i]=new yw_FailTrial12();
        }
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
    public static synchronized String readMessageFromClient(InputStream inputStream) throws IOException {
        Reader reader = new InputStreamReader(inputStream);
        BufferedReader br=new BufferedReader(reader);
        return br.readLine();
    }

    /**
     * 响应客户端信息
     * @param outputStream
     * @param string
     */
    public static synchronized void writeMsgToClient(OutputStream outputStream, String string) throws IOException {
        Writer writer = new OutputStreamWriter(outputStream);
        writer.append(String.format("%4d",string.length()));
        writer.append(string);
        writer.flush();
    }
}