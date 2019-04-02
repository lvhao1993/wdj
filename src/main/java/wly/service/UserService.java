package wly.service;

import wly.common.WdjResult;
import wly.entity.wuluyao.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author wuluyao@cloudwalk.cn
 * @Date 2019/4/2 19:56
 * @Version 1.0
 **/
public interface UserService {
    /**
     * 增
     * @param user
     * @return
     */
   WdjResult insert(User user);

    /**
     * 选择增
     * @param user
     * @return
     */
   int insertSelective(User user);

    /**
     * 批量增
     * @param user
     * @return
     */
   int insertList(List<User> user);

    /**
     * 更新
     * @param user
     * @return
     */
   int updateByPrimaryKeySelective(User user);

    /**
     * 查询
     * @param user
     * @return
     */
   List<User> select(User user);

    /**
     * 删除人员
     * @param user
     * @return
     */
   WdjResult delUser(User user);

    /**
     * 修改人员
     * @param user
     * @return
     */
   WdjResult editUser(User user);
}