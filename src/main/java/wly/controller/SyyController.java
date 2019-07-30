package wly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import wly.common.WdjResult;
import wly.entity.SyyPerson;
import wly.service.SyyPersonService;
import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName SyyController
 * @Description TODO
 * @Author SYY@cloudwalk.cn
 * @Date 2019/7/30 10:51
 * @Version 1.0
 **/
@Controller
@RequestMapping("/syyperson")

public class SyyController {


    @Resource
    private SyyPersonService syyPersonService;
    private static final String INDEX_HTML = "user";

    /**
     * 增加人员信息
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public WdjResult<SyyPerson> addPerson(SyyPerson syyPerson){
        try {
            return syyPersonService.add(syyPerson);
        }catch (Exception e){
            return  WdjResult.fail("00000","添加失败");
        }
    }

    @RequestMapping(value = "/toIndex",method = RequestMethod.GET)
    public ModelAndView toIndex(){
        ModelAndView mv=new ModelAndView(INDEX_HTML);
        return mv;
    }
    /**
     * 删除人员信息
     */
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public WdjResult<SyyPerson> deletePerson(){
        try{
            return syyPersonService.delete("");
        }catch(Exception e){
            return WdjResult.fail("00000","添加失败");
        }
    }


    /**
     * 改动人员信息
     */
    @RequestMapping(value = "/upd",method = RequestMethod.POST)
    public WdjResult<SyyPerson> updatePerson(SyyPerson syyPerson){
        try{
            return syyPersonService.update(syyPerson);
        }catch(Exception e){
            return WdjResult.fail("00000","添加失败");
        }
    }


    /**
     * 查询人员信息
     */
    @RequestMapping(value = "/que",method = RequestMethod.POST)
    @ResponseBody
    public WdjResult<List<SyyPerson>> queryPerson(@RequestBody  SyyPerson syyPerson){
        try {
            return syyPersonService.queryPerson(syyPerson);
        }catch (Exception e){
            System.out.println(e);
            return  WdjResult.fail("00000","添加失败");
        }
    }


}