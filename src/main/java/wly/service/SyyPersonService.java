package wly.service;

import wly.common.WdjResult;
import wly.entity.SyyPerson;
import wly.entity.lh.Person;

import java.util.List;

/**
 * @ClassName SyyPersonService
 * @Description TODO
 * @Author SYY@cloudwalk.cn
 * @Date 2019/7/30 10:53
 * @Version 1.0
 **/
public interface SyyPersonService {
    WdjResult add(SyyPerson syyPerson);

    WdjResult delete(int id);

    WdjResult update(SyyPerson syyPerson);

    WdjResult<List<Person>> select(SyyPerson syyPerson);


    WdjResult<List<SyyPerson>> querySyyPerson(SyyPerson person);
}
