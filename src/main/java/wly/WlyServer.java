package wly;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 启动类
 * @author lh
 * @date 2019/03/30
 */
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"wly"})
@MapperScan("wly.mapper")
public class WlyServer {

    public static void main(String[] args) {
        System.out.println("开始启动...");
        SpringApplication.run(WlyServer.class,args);
        System.out.println("已启动...");
    }
}  
