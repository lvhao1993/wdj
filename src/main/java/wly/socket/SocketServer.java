package wly.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName SocketServer
 * @Description TODO
 * @Author lvhao@cloudwalk.cn
 * @Date 2019/7/25 15:38
 * @Version 1.0
 **/
public class SocketServer {


    public static void initServer(){
        ServerSocket ss = null;
        Socket s = null;
        try{
            System.out.println("---------------------服务开启-----------------------");
            // 建立端口，监听新的请求
            ss = new ServerSocket(9856);
            s = ss.accept();
            // 读取客户端输入的信息
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String line = null;
            // 进行输出
            while ((line = br.readLine()) != null) {
                System.out.println("-----客户端输入的信息是-----");
                System.out.println(line);
            }
            s.close();
        }catch (Exception e){
        }finally {
            try{
                ss.close();
            }catch (Exception e){

            }
        }
    }

    public static void main(String[] args) {
        initServer();
    }

}
