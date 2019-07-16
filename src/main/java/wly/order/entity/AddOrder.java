package wly.order.entity;

/**
 * @ClassName AddOrder
 * @Description 下单
 * @Author lvhao@cloudwalk.cn
 * @Date 2019/7/16 10:46
 * @Version 1.0
 **/
public class AddOrder {

    /*address_id: 330
    reserveDate: 2019-07-16
    companyId: 246
    menuType: 4
    is_balance_pay: 0
    isTableware: 1
    tablewareStatus: 2*/

    private String address_id;
    private String reserveDate;
    private String companyId;
    private String menuType;
    private String is_balance_pay;
    private String isTableware;
    private String tablewareStatus;

    public String getAddress_id() {
        return address_id;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public String getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(String reserveDate) {
        this.reserveDate = reserveDate;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getIs_balance_pay() {
        return is_balance_pay;
    }

    public void setIs_balance_pay(String is_balance_pay) {
        this.is_balance_pay = is_balance_pay;
    }

    public String getIsTableware() {
        return isTableware;
    }

    public void setIsTableware(String isTableware) {
        this.isTableware = isTableware;
    }

    public String getTablewareStatus() {
        return tablewareStatus;
    }

    public void setTablewareStatus(String tablewareStatus) {
        this.tablewareStatus = tablewareStatus;
    }
}
