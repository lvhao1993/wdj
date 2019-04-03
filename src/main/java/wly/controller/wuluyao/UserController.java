package wly.controller.wuluyao;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import wly.common.WdjResult;
import wly.entity.wuluyao.User;
import wly.service.UserService;
import wly.service.impl.UserServicelmpl;

import javax.annotation.PostConstruct;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author wuluyao@cloudwalk.cn
 * @Date 2019/4/3 16:32
 * @Version 1.0
 **/
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;


    /**
     * 新增人员
     * @param user
     * @return
     */
    @ApiOperation(value="新增人员",notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体person",required = true,dataType = "User")
    @PostMapping("/add")
    public WdjResult addUser(@RequestBody User user){

        logger.info(user.getName());
        try {

            return userService.insert(user);
        }catch(Exception e){
            logger.error(e.getMessage());
            return WdjResult.fail("555","失败了");
        }
    }


    /**
     * 获取人员信息
     * @param user
     * @return
     */
    @ApiOperation(value = "获取人员信息",notes = "根据人员姓名或者年龄")
    @PostMapping("/get")
    public WdjResult getUser(@RequestBody User user){

        try {
            return WdjResult.success(userService.select(user));
        }catch(Exception e){
            logger.error(e.getMessage());
            return WdjResult.fail("555","失败了");

        }
    }


    /**
     * 删除人员
     * @param user
     * @return
     */
    @ApiOperation(value = "删除人员",notes = "根据人员ID删除人员")
    @PostMapping("/del")
    public WdjResult delUser(@RequestBody User user){
        try{
            return userService.delUser(user);
        }catch(Exception e){
            return WdjResult.fail("555","删除失败");
        }
    }


    /**
     * 编辑人员
     * @param user
     * @return
     */
    @ApiOperation(value = "编辑人员",notes = "编辑人员信息")
    @PostMapping("/edit")
    public WdjResult editUser(@RequestBody User user){
        try{
            return userService.editUser(user);
        }catch(Exception e){
            return WdjResult.fail("555","编辑失败");
        }
    }
}