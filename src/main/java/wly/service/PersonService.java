package wly.service;

import java.util.List;

import wly.common.WdjResult;
import wly.entity.lh.Person;

/**
 * 人接口
 * @author lh
 */
public interface PersonService{
    /**
     * 增
     * @param person
     * @return
     */
    WdjResult insert(Person person);
    /**
     * 选择增
     * @param person
     * @return
     */
    int insertSelective(Person person);
    /**
     * 批量增
     * @param persons
     * @return
     */
    int insertList(List<Person> persons);
    /**
     * 更新
     * @param person
     * @return
     */
    int updateByPrimaryKeySelective(Person person);


    /**
     * 查询
     * @param person
     * @return
     */
    List<Person> select(Person person);

    /**
     * 删除人员
     * @param person
     * @return
     */
    WdjResult delPerson(Person person);

    /**
     * 修改人员信息
     * @param person
     * @return
     */
    WdjResult editPerson(Person person);
}
