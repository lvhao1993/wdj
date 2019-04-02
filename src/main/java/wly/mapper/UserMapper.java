package wly.mapper;

import java.util.List;
import wly.entity.wuluyao.User;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author wuluyao@cloudwalk.cn
 * @Date 2019/4/2 19:06
 * @Version 1.0
 **/
public interface UserMapper {
    /**
     * 增
     * @param user
     * @return
     */
    int insert (User user);

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
     * 删除
     * @param user
     * @return
     */

    int delUser(User user);
}