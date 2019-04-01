package wly.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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


    @PostMapping("/add")
    public WdjResult addPerson(@RequestBody Person person){

        logger.info(person.getName());
        try {
            Person p = personService.insert(person);
            return WdjResult.success(p);
        }catch (Exception e){
            logger.error(e.getMessage());
            return WdjResult.fail("555","失败了");
        }
    }

    @PostMapping("/get")
    public WdjResult getPerson(@RequestBody Person person){

        try {
            return WdjResult.success(personService.select(person));
        }catch (Exception e){
            logger.error(e.getMessage());
            return WdjResult.fail("555","失败了");
        }
    }

}
