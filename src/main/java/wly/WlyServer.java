package wly;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import wly.controller.webmagic.ToutiaoStart;
import wly.order.OrderingMealsService;

import javax.annotation.Resource;

/**
 * 启动类
 * @author lh
 * @date 2019/03/30
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"wly"})
@MapperScan("wly.mapper")
@EnableAsync
@EnableScheduling
public class WlyServer implements ApplicationRunner {

    @Autowired
    private ToutiaoStart toutiaoStart;

    @Resource
    private OrderingMealsService orderingMealsService;

    public static void main(String[] args) {
        System.out.println("开始启动...");
        SpringApplication.run(WlyServer.class,args);
        System.out.println("已启动...");
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        //toutiaoStart.start();
        //orderingMealsService.startOrderingMeals();
    }
}
