package wly.service;


/**
 * @ClassName WdjFileService
 * @Description 文件测试
 * @Author lvhao@cloudwalk.cn
 * @Date 2019/3/30 16:13
 * @Version 1.0
 **/
public interface WdjFileService {

    /**
     * 文件copy测试
     * @param source 来源文件路径
     * @param dest 复制后的文件路径
     * @return
     * @throws Exception
     */
    String copyFile(String source,String dest) throws Exception;

}
