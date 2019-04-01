package wly.mapper;


import java.util.List;
import wly.entity.lh.Person;

/**
 * 人员mapper
 * @author lh
 */
public interface PersonMapper {
    /**
     * 增
     * @param person
     * @return
     */
    int insert( Person person);
    /**
     * 选择增
     * @param person
     * @return
     */
    int insertSelective( Person person);
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
    int updateByPrimaryKeySelective( Person person);

    List<Person> select(Person person);
}
