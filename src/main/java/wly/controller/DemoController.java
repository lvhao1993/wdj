package wly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wly.entity.FlieCopy;
import wly.service.WdjFileService;

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


    @Autowired
    private WdjFileService wdjFileService;


    @RequestMapping(value = "/h",method = RequestMethod.GET)
    public String test(@RequestParam String id){
        System.out.println("nni");
        System.out.println(id);
        return "吴大姐今年---"+id+"---岁了";
    }

    @PostMapping("/copy")
    public String copy(@RequestBody FlieCopy flieCopy){
        try {
            wdjFileService.copyFile(flieCopy.getSource(),flieCopy.getDest());
            return "success";
        }catch (Exception e){
            return "fail";
        }

    }

}
