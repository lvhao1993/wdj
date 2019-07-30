package wly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import wly.common.WdjResult;
import wly.entity.SyyPerson;
import wly.service.SyyPersonService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
     * 增加
     **/

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public WdjResult<SyyPerson> addPerson(SyyPerson person){
        try {
            return syyPersonService.add(person);
        }catch (Exception e){
            return  WdjResult.fail("2","添加失败");
        }
    }




    @RequestMapping(value = "/toIndex",method = RequestMethod.GET)
    public String toIndex(HttpServletRequest request, HttpServletResponse response){
        return INDEX_HTML;
    }


    /**
     * 查询人员
     * @param person
     * @return
     */
    @RequestMapping(value = "/querySyyPerson",method = RequestMethod.POST)
    public WdjResult<List<SyyPerson>> querySyyPerson(SyyPerson person){
        try {
            return syyPersonService.querySyyPerson(person);
        }catch (Exception e){
            return  WdjResult.fail("3","添加失败");
        }
    }










}