package wly.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
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
    public int insert(Person person){
        return personMapper.insert(person);
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
}
