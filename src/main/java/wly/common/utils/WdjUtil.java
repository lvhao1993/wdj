package wly.common.utils;

import java.util.UUID;

/**
 * @ClassName WdjUtil
 * @Description 工具类
 * @Author lvhao@cloudwalk.cn
 * @Date 2019/4/2 20:52
 * @Version 1.0
 **/
public class WdjUtil {

    /**
     * 随机生成UUID
     * @return
     */
    public static String generateUUID() {
        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号
        return uuid.replaceAll("-", "");
    }
}
