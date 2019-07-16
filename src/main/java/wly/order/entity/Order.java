package wly.order.entity;

/**
 * @ClassName Order
 * @Description 购物车
 * @Author lvhao@cloudwalk.cn
 * @Date 2019/7/16 10:33
 * @Version 1.0
 **/
public class Order {
    //id: 60368
    //num: 1
    //menu_id: 33262
    //mt: 4
    //reserve_date: 2019-07-16

    private String id;

    private String num ;

    private String menu_id ;

    private String mt;


    private String reserve_date;

    private String companyId;


    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
    }

    public String getMt() {
        return mt;
    }

    public void setMt(String mt) {
        this.mt = mt;
    }

    public String getReserve_date() {
        return reserve_date;
    }

    public void setReserve_date(String reserve_date) {
        this.reserve_date = reserve_date;
    }
}
