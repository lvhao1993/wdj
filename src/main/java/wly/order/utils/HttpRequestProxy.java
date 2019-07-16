package wly.order.utils;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * HTTP请求代理类
 * 
 * @author 何春节
 * @version 1.0
 * @since 1.6
 *
 */
public class HttpRequestProxy {
	
	private static final Logger logger = Logger.getLogger(HttpRequestProxy.class);
	
	/**
     * 连接超时
     */
	private static int CONNECT_TIME_OUT = 6000;
	
	/**
     * 读取数据超时
     */
	private static int READ_TIME_OUT = 60000;
	
	/**
	 * 将参数组装成字符串
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private static String buildQueryStr(Map<String, String> paramMap, String encoding)
			throws UnsupportedEncodingException {
		StringBuilder params = new StringBuilder("");
		
		if (paramMap != null && !paramMap.isEmpty()) {
			for (Map.Entry<String, String> entry : paramMap.entrySet()) {
				if (StringUtils.hasText(params)) {
					params.append("&");
				}
				
				String val = URLEncoder.encode(entry.getValue(), encoding);
				params.append(entry.getKey()).append("=").append(val);
			}
		}
		
		return params.toString();
	}
	
	/**
	 * 将参数组装成字符串
	 * @param paramMap
	 * @param encoding
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static byte[] buildParamter(Map<String, String> paramMap, String encoding)
			throws UnsupportedEncodingException {
		return buildQueryStr(paramMap, encoding).getBytes(encoding);
	}
	
	/**
     * <pre>
     * 发送带参数的POST的HTTP请求
     * </pre>
     * 
     * @param reqUrl HTTP请求URL
     * @param parameters 参数映射表
     * @return HTTP响应的字符串
     */
    public static String post(String reqUrl, Map<String, String> parameters, String encoding) {
    	
    	HttpURLConnection conn = null;
		ByteArrayOutputStream bs = null;
		OutputStream os = null;
		InputStream is = null;

		byte[] bytes = new byte[1024];
    	try {   
            conn = (HttpURLConnection) new URL(reqUrl).openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setInstanceFollowRedirects(false);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.connect();
               
            byte[] b = buildParamter(parameters, encoding);
            if (b != null) {
            	os = conn.getOutputStream();
            	os.write(b, 0, b.length);
            	os.flush();
            }
            
            is = conn.getInputStream();
			bs = new ByteArrayOutputStream();
			
			int len = 0;
			while ((len = is.read(bytes)) != -1) {
				bs.write(bytes, 0, len);
			}
			
			return new String(bs.toByteArray(), encoding);
        }  catch (IOException e) {
        	logger.error("发送POST请求异常，原因：" + e.getMessage(), e);
        } finally {
        	
        	if (bs != null) IOUtils.closeQuietly(bs);
        	if (is != null) IOUtils.closeQuietly(is);
        	if (os != null) IOUtils.closeQuietly(os);
        	if (conn != null) {
        		conn.disconnect();
        	}
        }
    	
    	return null;
    }
	
	/**
	 * 发送带参数的GET的HTTP请求
	 * 
	 * @return
	 */
    public static String get(String url, String encoding) {
        
    	HttpURLConnection conn = null;
    	InputStream is = null;
		ByteArrayOutputStream bs = null;

		byte[] bytes = new byte[1024];
        try {
        	conn = (HttpURLConnection) new URL(url).openConnection();
        	conn.setRequestMethod("GET");
        	conn.setDoInput(true);
        	conn.setDoOutput(true);
        	conn.setUseCaches(false);
        	conn.setConnectTimeout(CONNECT_TIME_OUT);
        	conn.setReadTimeout(READ_TIME_OUT);
        	
        	is = conn.getInputStream();
			bs = new ByteArrayOutputStream();
			
			int len = 0;
			while ((len = is.read(bytes)) != -1) {
				bs.write(bytes, 0, len);
			}
			
			return new String(bs.toByteArray(), encoding);
        } catch (IOException e) {
            logger.error("发送GET请求异常，原因：" + e.getMessage(), e);
        } finally {
        	
        	if (bs != null) IOUtils.closeQuietly(bs);
        	
        	if (is != null) IOUtils.closeQuietly(is);
        	
            if (conn != null) {
            	conn.disconnect();
            }
        }
        
        return null;
    }
    
    /**
	 * <pre>
	 * 发送带参数的POST的HTTP请求
	 * </pre>
	 * 
	 * @param reqUrl
	 *          HTTP请求URL
	 *          参数映射表
	 * @return HTTP响应的字符串
	 */
	public static String postJson(String reqUrl, String json, String encoding) {

		HttpURLConnection conn = null;
		ByteArrayOutputStream bs = null;
		OutputStream os = null;
		InputStream is = null;

		byte[] bytes = new byte[1024];
		try {
			conn = (HttpURLConnection) new URL(reqUrl).openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setInstanceFollowRedirects(false);
//			conn.setConnectTimeout(CONNECT_TIME_OUT);
//			conn.setReadTimeout(READ_TIME_OUT);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.connect();

			byte[] b = json.getBytes(encoding);
			if (b != null) {
				os = conn.getOutputStream();
				os.write(b, 0, b.length);
				os.flush();
			}

			is = conn.getInputStream();
			bs = new ByteArrayOutputStream();

			int len = 0;
			while ((len = is.read(bytes)) != -1) {
				bs.write(bytes, 0, len);
			}

			return new String(bs.toByteArray(), encoding);
		} catch (Exception e) {
			logger.error("发送POST JSON请求异常，原因：" + e.getMessage(), e);
		} finally {
			IOUtils.closeQuietly(bs);
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
			if (conn != null) {
				conn.disconnect();
			}
		}
		return null;
	}
	
	/**
	 * 测试地址是否连通
	 * @param url
	 * @return
	 */
	public static boolean checkHttpReachable(String url) {
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setInstanceFollowRedirects(false);
			conn.setConnectTimeout(5000);
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.connect();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}
}
