/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import cn.aposoft.ecommerce.payment.wechat.Config;

/**
 * 只进行post提交
 * 
 * @author LiuJian
 *
 */
public class SingletonHttpClientUtil implements HttpClientUtil {

	private static SingletonHttpClientUtil instance = new SingletonHttpClientUtil();
	public static Logger log = Logger.getLogger(SingletonHttpClientUtil.class);
	private static CloseableHttpClient httpclient = HttpClients.createDefault();

	private SingletonHttpClientUtil() {
	}

	public static final HttpClientUtil getInstance() {
		return instance;
	}

	/**
	 * 保持httpClient仅拥有一个实例,完成微信支付,向服务器发送支付订单信息的服务
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.util.HttpClientUtil#setPost(java.lang
	 *      .String)
	 * @param request
	 *            待发送的xml字符串信息
	 * @param config
	 * @param url
	 *            请求的url地址
	 * @return
	 * @author Yujinshui
	 */
	@Override
	public String post(String request, Config config, String url) {
		// 请求结果
		String result = "";
		// CloseableHttpClient httpclient = HttpClients.createDefault();
		// 定义POST请求
		HttpPost httpPost = new HttpPost(url);

		StringEntity postEntity = new StringEntity(request, "UTF-8");
		httpPost.addHeader("Content-Type", "text/xml");
		httpPost.setEntity(postEntity);
		// 模拟POST请求并接受服务响应
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpPost);
			// 处理响应
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭响应
			try {
				response.close();
			} catch (IOException e) {
				log.error("WeChatPay 统一下单请求 IOException!" + e.getMessage());
				e.printStackTrace();
			}
		}

		return result;
	}

	/**
	 * 保持httpClient仅拥有一个实例,完成微信支付,向服务器发送支付订单信息的服务
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.util.HttpClientUtil#setPost(java.lang
	 *      .String)
	 * @param request
	 *            待发送的xml字符串信息
	 * @param config
	 * @param url
	 *            请求的url地址
	 * @return
	 * @author Yujinshui
	 * @throws Exception
	 */
	@Override
	public String refundPost(String request, Config config, String url) throws Exception {
		// 请求结果
		String result = "";
		/*************** 证书认证部分 ****************/
		httpclient = CommonUtil.getPkcs12(config);
		/*************** 证书认证部分 ****************/
		// 定义POST请求
		HttpPost httpPost = new HttpPost(url);

		StringEntity postEntity = new StringEntity(request, "UTF-8");
		httpPost.addHeader("Content-Type", "text/xml");
		httpPost.setEntity(postEntity);
		// 模拟POST请求并接受服务响应
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpPost);
			// 处理响应
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭响应
			try {
				response.close();
			} catch (IOException e) {
				log.error("WeChatPay 统一下单请求 IOException!" + e.getMessage());
				e.printStackTrace();
			}
		}

		return result;
	}

}
