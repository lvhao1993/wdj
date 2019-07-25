package wly.mail;

import org.apache.commons.mail.HtmlEmail;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MailUtil {
	protected final static Logger log = Logger.getLogger(MailUtil.class);
	

    /**
     * 发送邮件（异常未捕获，直接抛出）. <br/>
     */
    public static void send(String user,String message) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        HtmlEmail email = new HtmlEmail(); // 发送email对象
        email.setHostName("smtp.exmail.qq.com"); // 这里是SMTP发送服务器的名字：163的如下："smtp.163.com"
        // 设置服务器端口（如果没有则使用默认端口）
        email.setSmtpPort(465);
        //邮箱支持ssl协议
        email.setSSLOnConnect(true); // 是否启用SSL
        email.setSslSmtpPort("465"); // 若启用，设置smtp协议的SSL端口号
        email.setSSLCheckServerIdentity(true);
        email.setCharset(MailBean.ENCODEING);            // 字符编码集的设置
        email.addTo(user);                 // 收件人的邮箱
        email.setFrom("lvhao@cloudwalk.cn"); // 发送人的邮箱
        email.setSubject(sdf.format(new Date())+"----订餐成功----");             // 的邮件主题
        
        
        // 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码  
        email.setAuthentication("lvhao@cloudwalk.cn", "Hh15221993540");
        // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签  
        email.setMsg(message);
        // 发送
        email.send();  
    }

    public static void main(String[] args) throws Exception{
        String user = "shenyunyun@cloudwalk.cn";
        String message = "测试邮件";
        send(user,message);
        System.out.println("success");

    }

}
