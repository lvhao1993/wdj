package wly.controller.lh;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wly.common.MyFirstAnnotation;
import wly.common.WdjResult;
import wly.entity.lh.Person;
import wly.service.PersonService;

/**
 * @ClassName PersonController
 * @Description 人
 * @Author lvhao@cloudwalk.cn
 * @Date 2019/4/1 20:22
 * @Version 1.0
 **/
@RestController
@RequestMapping("/person")
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);


    @Autowired
    private PersonService personService;

    /**
     * 增
     * @param person
     * @return
     */
    @ApiOperation(value="新增人员", notes="根据Person对象创建用户")
    @ApiImplicitParam(name = "person", value = "用户详细实体person", required = true, dataType = "Person")
    @PostMapping("/add")
    public WdjResult addPerson(@RequestBody Person person){

        logger.info(person.getName());
        try {
            return personService.insert(person);
        }catch (Exception e){
            logger.error(e.getMessage());
            return WdjResult.fail("555","失败了");
        }
    }

    /**
     * 查
     * @param person
     * @return
     */
    @ApiOperation(value = "获取人员信息" ,notes = "根据人员姓名或者年龄")
    @PostMapping("/get")
    public WdjResult getPerson(@RequestBody Person person){

        try {
            return WdjResult.success(personService.select(person));
        }catch (Exception e){
            logger.error(e.getMessage());
            return WdjResult.fail("555","失败了");
        }
    }

    /**
     * 删
     * @param person
     * @return
     */
    @ApiOperation(value = "删除人员",notes = "根据人员ID删除人员")
    @PostMapping("/del")
    public WdjResult delPerson(@RequestBody Person person){
        try {
            return personService.delPerson(person);
        }catch (Exception e){
            return WdjResult.fail("555","删除失败");
        }
    }

    /**
     * 改
     * @param person
     * @return
     */
    @ApiOperation(value = "编辑人员",notes = "编辑人员信息")
    @PostMapping("/edit")
    public WdjResult editPerson (@RequestBody Person person){
        try {
            return personService.editPerson(person);
        }catch (Exception e){
            return WdjResult.fail("555","编辑失败");
        }
    }

}
