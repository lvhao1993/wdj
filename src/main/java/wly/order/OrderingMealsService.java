package wly.order;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import wly.order.entity.AddOrder;
import wly.order.entity.Order;
import wly.order.entity.User;
import wly.order.utils.HttpRequestProxy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @ClassName OrderingMealsService
 * @Description 自动点饭
 * @Author lvhao@cloudwalk.cn
 * @Date 2019/6/20 15:31
 * @Version 1.0
 **/
@Component
public class OrderingMealsService {

    public static Logger logger = LoggerFactory.getLogger(OrderingMealsService.class);

    public static final String LOGIN_URL = "http://api.platform.xixiang000.com/login/";

    /**
     * 点餐账号
     */
    @Value("${user.userName}")
    private String userName;

    /**
     * 点餐密码
     */
    @Value("${user.passWord}")
    private String passWord;

    /**
     * 公司名称
     */
    public static final String COMPANY_ID = "246";

    @Scheduled(cron = "0 0 11 * * ?")
    //@Scheduled(fixedRate = 3600*1000)
    public void startOrderingMeals(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = simpleDateFormat.format(date);
        logger.info("开始点饭");
        User user = new User();
        user.setPhone(userName);
        user.setPassword(passWord);
        JSONObject loginJson = sendPostJsonRequest(LOGIN_URL,JSON.toJSON(user).toString(),JSONObject.class);
        logger.info("------账号登入成功------");
        //api_token
        JSONObject data = getData(loginJson);
        String api_token = data.getString("api_token");
        //获取第一个商家
        //http://api.platform.xixiang000.com/list/?api_token=5d0b371b715fb&mt=4&companyId=246&menu_date=2019-06-20
        JSONObject businessInfo =  sendGetJsonRequest("http://api.platform.xixiang000.com/list/?api_token="+api_token+"&mt=4&companyId="+
                        COMPANY_ID+"&menu_date="+today+""
                ,JSONObject.class);
        JSONArray jsonArray = businessInfo.getJSONArray("data");
        JSONObject bData = jsonArray.getJSONObject(0);
        //商家ID
        String business_id = bData.get("business_id").toString();
        //获取第一个菜
        //http://api.platform.xixiang000.com/cookbook/?api_token=5d0b371b715fb&busid=723&mt=4&companyId=246&menu_date=2019-06-20
        JSONObject cookbook =  sendGetJsonRequest("http://api.platform.xixiang000.com/cookbook/?api_token="+api_token+"&busid="+business_id+"&mt=4&companyId="+
                        COMPANY_ID+"&menu_date="+today+""
                ,JSONObject.class);

        JSONObject cookBooks = cookbook.getJSONObject("data");
        JSONArray cookBookList = cookBooks.getJSONArray("1458");

        //随机点餐
        Random randScore = new Random();
        int random =  (randScore.nextInt(5));
        JSONObject cook = cookBookList.getJSONObject(random);
        JSONObject cookbookOrder = cook.getJSONObject("cookbook");
        String menu_name = cookbookOrder.getString("menu_name");
        logger.info("------您点的是："+menu_name+"------");
        String id = cook.getString("id");
        String menu_id =  cook.getString("menu_id");
        String mt = cook.getString("menu_type");
        Order order = new Order();
        order.setId(id);
        order.setMenu_id(menu_id);
        order.setMt(mt);
        order.setNum("1");
        order.setReserve_date(today);
        order.setCompanyId(COMPANY_ID);
        //加入购物车
        JSONObject object = sendPostJsonRequest("http://api.platform.xixiang000.com/cart/add/?api_token="+api_token,JSON.toJSON(order).toString(),JSONObject.class);
        logger.info("------您的晚饭已经加入购物车了------");
        //添加购物车 http://api.platform.xixiang000.com/cart/add/?api_token=5d28355d0b8ba  post companyId: 246
        //id: 60368
        //num: 1
        //menu_id: 33262
        //mt: 4
        //reserve_date: 2019-07-16

        //点饭下订单  http://api.platform.xixiang000.com/order/add/?api_token=5d28355d0b8ba
//        address_id: 330
//        reserveDate: 2019-07-16
//        companyId: 246
//        menuType: 4
//        is_balance_pay: 0
//        isTableware: 1
//        tablewareStatus: 2

        //自动结算购物车中的商品
        AddOrder addOrder = new AddOrder();
        addOrder.setAddress_id("330");
        addOrder.setCompanyId(COMPANY_ID);
        addOrder.setIs_balance_pay("0");
        addOrder.setIsTableware("1");
        addOrder.setMenuType(mt);
        addOrder.setReserveDate(today);
        addOrder.setTablewareStatus("2");
        JSONObject result = sendPostJsonRequest("http://api.platform.xixiang000.com/order/add/?api_token="+api_token,JSON.toJSON(addOrder).toString(),JSONObject.class);

        logger.info("------您的晚饭下单成功了------");
        logger.info(result.toJSONString());


    }


    /**
     * 发送HTTP的POST请求(json)
     * @param url
     * @param param
     * @return
     * @return
     */
    private static <T> T sendPostJsonRequest(String url,String param, Class<T> clz) {
        String ret = HttpRequestProxy.postJson(url, param, "UTF-8");
        return JSONArray.parseObject(ret, clz);
    }

    private static <T> T sendGetJsonRequest(String url, Class<T> clz) {
        String ret = HttpRequestProxy.get(url, "UTF-8");
        return JSONArray.parseObject(ret, clz);
    }

    public static JSONObject getData(JSONObject object){

        JSONObject returnJsonObj = object.getJSONObject("data");
        return returnJsonObj;
    }


    public static void main(String[] args) {
        //startOrderingMeals();
    }

}
