package wly.service;

import wly.common.WdjResult;
import wly.entity.SyyPerson;

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

    WdjResult delete(String id);

    WdjResult update(SyyPerson syyPerson);

    WdjResult<List<SyyPerson>> queryPerson(SyyPerson syyPerson);
}


