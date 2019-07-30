package wly.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import wly.common.WdjResult;
import wly.entity.wuluyao.User;
import wly.mapper.UserMapper;
import wly.service.UserService;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName UserServicelmpl
 * @Description TODO
 * @Author wuluyao@cloudwalk.cn
 * @Date 2019/4/2 20:21
 * @Version 1.0
 **/
@Service
public class UserServicelmpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private UserMapper userMapper;

    @Override
    public WdjResult insert(User user) {
        if (checkName(user)){
            user.setId(this.generateUUID());
            userMapper.insert(user);
            logger.info("新增成功");
            return WdjResult.success(user);
        }else{
            return WdjResult.fail("555","存在相同的名字,重新输入");
        }
    }

    @Override
    public int insertSelective(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int insertList(List<User> user) {
        return userMapper.insertList(user);
    }

    @Override
    public int updateByPrimaryKeySelective(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<User> select(User user) {
        return userMapper.select(user);
    }

    @Override
    public WdjResult delUser(User user) {
        //TODO
       // userMapper.delUser(user);
        logger.info("删除成功");
        return WdjResult.success(true);
    }

    @Override
    public WdjResult editUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
        logger.info("编辑成功");
        return WdjResult.success(true);
    }

    /**
     * 判断name是否已经存在 （true：不存在  false：存在）
     * @param user
     * @return
     */
    public boolean checkName(User user){
        User checkUser = new User();
        checkUser.setName(user.getName());
        List<User> list = userMapper.select(checkUser);


        if(CollectionUtils.isEmpty(list)){
            return true;
        }else {
            return false;
        }

    }

    /**
     * 随机生成UUID
     * @return
     */
    private String generateUUID() {
        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号
        return uuid.replaceAll("-", "");
    }

}