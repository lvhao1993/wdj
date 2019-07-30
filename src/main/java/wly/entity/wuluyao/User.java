package wly.entity.wuluyao;

/**
 * @ClassName User
 * @Description TODO
 * @Author wuluyao@cloudwalk.cn
 * @Date 2019/4/2 18:56
 * @Version 1.0
 **/
public class User {

    private String id;

    private String name;

    private int age;

    public String getId(){return id;}

    public void setId(String id){this.id = id;}

    public String getName(){return name;}

    public void setName(String name){this.name = name;}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}