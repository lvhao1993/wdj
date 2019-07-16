package wly.service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName TodayTest
 * @Description TODO
 * @Author lvhao@cloudwalk.cn
 * @Date 2019/7/16 10:55
 * @Version 1.0
 **/
public class TodayTest {

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = simpleDateFormat.format(date);
        System.out.println(today);
    }


}
