package wly.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @ClassName SockerClient
 * @Description TODO
 * @Author lvhao@cloudwalk.cn
 * @Date 2019/7/25 15:20
 * @Version 1.0
 **/
public class SockerClient {

    public static void initClient(){
        Socket s = null;
        try {
            // 建立连接
            s = new Socket("127.0.0.1", 9856);

            // 读取键盘输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // 端口输出
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

            String line = null;

            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
            s.close();
        }catch (Exception e){
        }finally {
            try {
                s.close();
            }catch (Exception e){

            }

        }
    }

    public static void main(String[] args) {
        initClient();
    }
}
