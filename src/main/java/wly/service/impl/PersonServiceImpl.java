package wly.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

import org.springframework.util.CollectionUtils;
import wly.common.WdjResult;
import wly.entity.lh.Person;
import wly.mapper.PersonMapper;
import wly.service.PersonService;

/**
 * 人
 * @author lh
 */
@Service
public class PersonServiceImpl implements PersonService{

    @Resource
    private PersonMapper personMapper;

    @Override
    public WdjResult insert(Person person){
        //判断name是否重复
        if(checkName(person)){
            person.setId(this.generateUUID());
            personMapper.insert(person);
            return WdjResult.success(person);
        }else{
            return WdjResult.fail("555","存在相同的名字,重新输入");
        }


    }

    @Override
    public int insertSelective(Person person){
        return personMapper.insertSelective(person);
    }

    @Override
    public int insertList(List<Person> persons){
        return personMapper.insertList(persons);
    }

    @Override
    public int updateByPrimaryKeySelective(Person person){
        return personMapper.updateByPrimaryKeySelective(person);
    }


    @Override
    public List<Person> select(Person person) {
        return personMapper.select(person);
    }

    @Override
    public WdjResult delPerson(Person person) {
        personMapper.delPerson(person);
        return WdjResult.success(true);
    }

    @Override
    public WdjResult editPerson(Person person) {
        personMapper.updateByPrimaryKeySelective(person);
        return WdjResult.success(true);
    }

    /**
     * 判断name是否已经存在 （true：不存在  false：存在）
     * @param person
     * @return
     */
    public boolean checkName(Person person){
        Person checkPerson = new Person();
        checkPerson.setName(person.getName());
        List<Person> list = personMapper.select(checkPerson);
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
