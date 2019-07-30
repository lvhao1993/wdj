package wly.entity;

import java.util.Date;

/**
 * @ClassName SyyPerson
 * @Description TODO
 * @Author SYY@cloudwalk.cn
 * @Date 2019/7/30 10:36
 * @Version 1.0
 **/
public class SyyPerson {

    private String id;

    private String name;

    private Integer age;

    private String gender;

    private Date birthday;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}