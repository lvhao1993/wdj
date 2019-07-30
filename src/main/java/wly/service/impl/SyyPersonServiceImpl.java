package wly.service.impl;

import org.springframework.stereotype.Service;
import wly.common.WdjResult;
import wly.entity.SyyPerson;
import wly.mapper.SyyPersonMapper;
import wly.service.SyyPersonService;
import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName SyyPersonServiceImpl
 * @Description TODO
 * @Author SYY@cloudwalk.cn
 * @Date 2019/7/30 12:57
 * @Version 1.0
 **/
@Service
public class SyyPersonServiceImpl implements SyyPersonService {
    @Resource
    private SyyPersonMapper syyPersonMapper;

    @Override
    public WdjResult add(SyyPerson syyPerson) {
        if(checkName(syyPerson)){
            syyPerson.setId(this.generateUUID());
            syyPersonMapper.insert(syyPerson);
            return WdjResult.success(syyPerson);
        }else{
            return WdjResult.fail("00000","存在相同的名字,请重新输入");
        }
    }

    @Override
    public WdjResult delete(String id) {
        SyyPerson person = new SyyPerson();
        person.setId(id);
        syyPersonMapper.del(person);
        return WdjResult.success(true);
    }

    @Override
    public WdjResult update(SyyPerson syyPerson) {
        syyPersonMapper.updateall(syyPerson);
        return WdjResult.success(true);
    }


    @Override
    public WdjResult<List<SyyPerson>> queryPerson(SyyPerson syyPerson) {
        List<SyyPerson> list = syyPersonMapper.queryall(syyPerson);
        return WdjResult.success(list);
       // return null;
    }



    /**
     * 判断name是否已经存在 （true：不存在  false：存在）
     * @param syyPerson
     * @return
     */
    public boolean checkName(SyyPerson syyPerson){
        SyyPerson checkUser = new SyyPerson();
        checkUser.setName(syyPerson.getName());
        return false;
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