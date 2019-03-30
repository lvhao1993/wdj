package wly.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DemoController
 * @Description TODO
 * @Author lvhao@cloudwalk.cn
 * @Date 2019/3/30 15:38
 * @Version 1.0
 **/
@RestController
@RequestMapping("/test")
public class DemoController {

    @RequestMapping(value = "/h",method = RequestMethod.GET)
    public String test(@RequestParam String id){
        System.out.println("nni");
        System.out.println(id);
        return "吴大姐今年---"+id+"---岁了";
    }


}
