package wly.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

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
    public Person insert(Person person){
        person.setId(this.generateUUID());
        personMapper.insert(person);
        return person;
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
