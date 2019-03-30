package wly.service.impl;

import org.springframework.stereotype.Component;
import wly.service.WdjFileService;

import java.io.*;

/**
 * @ClassName WdjFileServiceImpl
 * @Description TODO
 * @Author lvhao@cloudwalk.cn
 * @Date 2019/3/30 16:14
 * @Version 1.0
 **/
@Component
public class WdjFileServiceImpl implements WdjFileService {
    @Override
    public String copyFile(String source,String dest) throws Exception {
        File destFile = new File(dest);
        if(!destFile.exists()){
            destFile.createNewFile();
        }
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } finally {
            input.close();
            output.close();
        }

        return dest;
    }
}
