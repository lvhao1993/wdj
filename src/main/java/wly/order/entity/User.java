package wly.order.entity;

/**
 * @ClassName User
 * @Description TODO
 * @Author lvhao@cloudwalk.cn
 * @Date 2019/6/20 15:40
 * @Version 1.0
 **/
public class User {

    private String phone;

    private String password;

    private String api_token;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }
}



