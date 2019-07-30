package wly.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import wly.entity.SyyPerson;

@Mapper
public interface SyyPersonMapper {
    int insert( SyyPerson syyPerson);

    int insertList(List<SyyPerson> syyPersons);

    List<SyyPerson> queryall(SyyPerson syyperson);

    int updateall(SyyPerson syyPerson);

    int del(SyyPerson syyPerson);

}
