package wly.service.impl;

import org.springframework.stereotype.Service;
import wly.common.WdjResult;
import wly.entity.SyyPerson;
import wly.entity.lh.Person;
import wly.service.SyyPersonService;

import java.util.List;

/**
 * @ClassName SyyPersonServiceImpl
 * @Description TODO
 * @Author SYY@cloudwalk.cn
 * @Date 2019/7/30 12:57
 * @Version 1.0
 **/
@Service
public class SyyPersonServiceImpl implements SyyPersonService {

    @Override
    public WdjResult add(SyyPerson syyPerson) {
        //int i = mapper.add;
        return WdjResult.success(syyPerson);
    }

    @Override
    public WdjResult delete(int id) {
        return null;
    }

    @Override
    public WdjResult update(SyyPerson syyPerson) {
        return null;
    }

    @Override
    public WdjResult<List<Person>> select(SyyPerson syyPerson) {
        return null;
    }

    @Override
    public WdjResult<List<SyyPerson>> querySyyPerson(SyyPerson person) {
        return null;
    }
}