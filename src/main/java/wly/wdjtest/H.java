package wly.wdjtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ClassName H
 * @Description TODO
 * @Author lvhao@cloudwalk.cn
 * @Date 2019/4/9 19:46
 * @Version 1.0
 **/
public class H {


    public static void main(String[] args) throws IOException {
       // C:\Users\yckj0906\Desktop
        String docUploadPath = "C:\\Users\\yckj0906\\Desktop\\info.json";
        try {
            byte[] refereeFileOriginalBytes = getFileDataByPath(docUploadPath);
            String UpFile = new String(refereeFileOriginalBytes, "UTF-8");
            System.out.println(UpFile);
        }catch (Exception e){

        }

    }


    public static byte[] getFileDataByPath(String filePath) {
        FileInputStream fis = null;
        try {
            File file = new File(filePath);
            if (file.exists()) {
                int size = (int) file.length();
                byte[] filedata = new byte[size];
                fis = new FileInputStream(file);
                if (fis != null)
                    fis.read(filedata, 0, size);
                return filedata;
            }
        } catch (Exception e) {
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                }
            }
        }
        return null;
    }

}
