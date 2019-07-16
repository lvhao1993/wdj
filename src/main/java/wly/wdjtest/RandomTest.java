package wly.wdjtest;

import java.util.Random;

/**
 * @ClassName RandomTest
 * @Description TODO
 * @Author lvhao@cloudwalk.cn
 * @Date 2019/5/24 15:02
 * @Version 1.0
 **/
public class RandomTest {


    public static void main(String[] args) {
        Random random = new Random();
        int randomTime = 10000;
        for (int i = 0; i < 1000; i++) {
            int sleepTime = random.nextInt(5)*randomTime;
            System.out.println("随机数---"+sleepTime);
        }

    }
}
