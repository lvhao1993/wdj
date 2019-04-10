package wly.common.webmagic;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author lvhao
 * @date 2019/04/10
 */
@Component
public class MyPic {
	
	public  void download(String urlString, String filename,String savePath) throws Exception {    
        // 构造URL    
        URL url = new URL(urlString);    
        // 打开连接    
        URLConnection con = url.openConnection();    
        //设置请求超时为5s    
        con.setConnectTimeout(5*1000);    
        con.setRequestProperty("Cookie", "__cfduid=d4c9f1835ac863a91288ad3edb5b469711523515318; _ga=GA1.2.1760295557.1523515320; _gid=GA1.2.333315600.1523515320; wallhaven_session=eyJpdiI6IkxCRGgwUkdLQnJMajV3MENmTVRjYmhFVVN0QTNPTTVSZVIzUTZtUVB4N0E9IiwidmFsdWUiOiJTcTFBWWpYNUpzb0lRb3Z0ckI1eG9pXC9lZXhQVzlvNUhhcGdHVkRBK3psUE5Dd1dcL3IzSUcwY3QwT0IyaEhDa2lDTDFha3pObFBCV2Nwd2JzS3ltWG13PT0iLCJtYWMiOiJlYTEwZTQ5ZTk3ZTk5NDQxMDc2MjNhYzMzNDg2MTcxYzE2MDkzNDkwY2UyNWNiYTJjYWExYmM5Mjk1ZTRkN2UxIn0%3D");
        con.setRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        con.setRequestProperty("Accept-Encoding","gzip, deflate, sdch");
        con.setRequestProperty("Accept-Language","zh-CN,zh;q=0.8");
        con.setRequestProperty("Cache-Control","max-age=0");
        con.setRequestProperty("Connection","keep-alive");
        con.setRequestProperty("Upgrade-Insecure-Requests","1");
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.157 Safari/537.36");
        
        // 输入流    
        InputStream is = con.getInputStream();    
        
        // 1K的数据缓冲    
        byte[] bs = new byte[1024];    
        // 读取到的数据长度    
        int len;    
        // 输出的文件流    
       File sf=new File(savePath);    
       if(!sf.exists()){    
           sf.mkdirs();    
       }    
       OutputStream os = new FileOutputStream(sf.getPath()+"\\"+filename+".jpg");    
        // 开始读取    
        while ((len = is.read(bs)) != -1) {    
          os.write(bs, 0, len);    
        }    
        // 完毕，关闭所有链接    
        os.close();    
        is.close();    
    }     
	
}
