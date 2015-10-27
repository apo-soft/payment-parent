/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
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
	public static Logger log = Logger.getLogger(SingletonHttpClientUtil.class);
	private static SingletonHttpClientUtil instance = new SingletonHttpClientUtil();

	// 用于发送普通http连接的client
	private CloseableHttpClient httpclient = HttpClients.createDefault();
	// 用于发送https带有证书的连接client
	private final ConcurrentMap<String, CloseableHttpClient> httpsClients = new ConcurrentHashMap<String, CloseableHttpClient>();

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
	 * @throws IOException 
	 */
	@Override
	public String post(String request, Config config, String url) throws IOException {
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
			throw e;
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
	 * @return 执行退款请求,并返回响应字符串
	 * @throws Exception
	 * @author Yujinshui
	 * @bugfix 2015/10/25
	 *         修改了httpClient在获取过程中对类的成员变量产生的影响,取消每次生成新的client的低效操作,改为缓存client操作.
	 * 
	 */
	@Override
	public String refundPost(String request, Config config, String url) throws Exception {
		// 请求结果
		String result = "";
		/*************** 证书认证部分 ****************/
		CloseableHttpClient httpsClient = getHttpsClients(config);
		/*************** 证书认证部分 ****************/
		// 定义POST请求
		HttpPost httpPost = new HttpPost(url);

		StringEntity postEntity = new StringEntity(request, "UTF-8");
		httpPost.addHeader("Content-Type", "text/xml");
		httpPost.setEntity(postEntity);
		// 模拟POST请求并接受服务响应
		CloseableHttpResponse response = null;
		try {
			response = httpsClient.execute(httpPost);
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
	 * 返回配置微信商户的p12文件的加密连接客户端
	 * 
	 * @param config
	 *            微信商户的mchId和加密秘钥文件位置
	 * @return 加密客户端,当加载配置失败时,返回null.
	 */
	private CloseableHttpClient getHttpsClients(Config config) {
		CloseableHttpClient httpsClient = httpsClients.get(config.mchId());
		if (httpsClient == null) {
			try {
				httpsClient = httpsClients.putIfAbsent(config.mchId(), getPkcs12Client(config));
				if (httpsClient == null) {
					httpsClient = httpsClients.get(config.mchId());
				}
			} catch (Exception e) {
				log.error("当执行微信交易过程中,尝试创建客户端失败,请检查.", e);
			}
		}
		return httpsClient;
	}

	/**
	 * 
	 * 创建配置了双向证书认证的https请求客户端
	 * 
	 * @param config
	 *            带有商户id和证书位置的配置信息
	 * @return 添加微信支付商户安全认证信息的http请求客户端
	 * @throws Exception
	 *             配置种可能产生多种异常.
	 * @author Yujinshui
	 * @bugfix Jann Liu 2015/10/25 修改在client中被deprecated的方法,使用官方推荐的标准方法
	 */
	private static CloseableHttpClient getPkcs12Client(Config config) throws Exception {
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		FileInputStream instream = new FileInputStream(new File(config.pkcs12()));
		try {
			keyStore.load(instream, config.mchId().toCharArray());
		} finally {
			instream.close();
		}
		// Trust own CA and all self-signed certs
		SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, config.mchId().toCharArray()).build();
		// Allow TLSv1 protocol only
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null,
				SSLConnectionSocketFactory.getDefaultHostnameVerifier());
		CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();

		return httpclient;
	}

}
