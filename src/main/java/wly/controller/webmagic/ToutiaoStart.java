package wly.controller.webmagic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import wly.service.webmagic.ToutiaoService;

/**
 * @author lvhao
 * @date 2019/04/10
 */
@Component
public class ToutiaoStart {
	
	@Autowired
	private ToutiaoService service;

	/**
	 * 壁纸
	 */
	public void start(){
		
		String url = "https://alpha.wallhaven.cc/toplist?page=1";
		Spider spider = new Spider(service);
		spider.addUrl(url);
		spider.thread(5).run();
	}
	
}
