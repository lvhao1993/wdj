package wly.service.webmagic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import wly.common.webmagic.MyPic;

import java.util.List;
import java.util.Random;

/**
 * @author lvhao
 * @date 2019/04/10
 */
@Component
public class ToutiaoService implements PageProcessor {
	
	private Site site = null ;
	
	@Autowired
	private MyPic mypic;
	
	public ToutiaoService() {
		site = Site.me().setDomain("toutiao.com").setRetryTimes(3).setSleepTime(1000*new Random().nextInt(2)+3)
				.setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/21.0.1180.77 Safari/537.31")
				;
	}
	
	@Override
	public void process(Page page) {
			String url = page.getUrl().toString();
			Html html = page.getHtml();
			List<String> urllist = html.xpath("//div[@id='thumbs']/section/ul/li/figure/img/@data-src").all();
			urllist.forEach(imgurl ->{
				try {
					mypic.download(imgurl, String.valueOf(System.currentTimeMillis()),"D:/cs/mypic" );
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int pagenum = Integer.valueOf(url.replace("https://alpha.wallhaven.cc/toplist?page=", "")); 
			if(pagenum<143){
				page.addTargetRequest("https://alpha.wallhaven.cc/toplist?page="+(pagenum+1));
			}
		
		
	}

	@Override
	public Site getSite() {
		return site;
	}

}
