package wly.wdjtest;

import wly.service.WdjFileService;
import wly.service.impl.WdjFileServiceImpl;

import java.util.Date;

/**
 * @ClassName Test
 * @Description 测试
 * @Author lvhao@cloudwalk.cn
 * @Date 2019/3/30 16:17
 * @Version 1.0
 **/
public class Test {
    /**
     * 来源文件路径
     */
    public static final String SOURCE = "D:\\tool\\ceshi.txt";
    /**
     * 复制后的文件路径
     */
    public static final String DEST = "D:\\tool\\hhh.txt";

    public static void main(String[] args) {
        WdjFileServiceImpl wdjFileService = new WdjFileServiceImpl();
        try {
            wdjFileService.copyFile(SOURCE,DEST);
            System.out.println("复制成功，请查看");
        }catch (Exception e){
            System.out.println("复制失败，请查看"+e.getMessage());
        }
    }

}
