/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
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
import cn.aposoft.ecommerce.payment.wechat.HttpClientUtil;

/**
 * 
 * 只进行post提交
 * <p>
 * 当应用关闭时应调用 {@code client.close();} 以释放全部client资源.
 * 
 * <p>
 * 原来的SimgletonUtil具有较大的整体资源管理问题,变更为普通的可注入Util,单例可以作为共享资源使用,也可以多次注入到独立的service中,
 * 每个服务独立控制自己资源的关闭
 * 
 * @author LiuJian
 *
 */

public class HttpClientUtilImpl implements HttpClientUtil {
	// 单一主机最大并发连接数:默认为2,这里增大到200,避免高并发时,因此导致支付阻塞.
	private int connectionPerRoute = 200;
	private AtomicLong sequence = new AtomicLong(0L);
	public static Logger log = Logger.getLogger(HttpClientUtilImpl.class);

	// 用于发送普通http连接的client
	private CloseableHttpClient client = null;

	// 用于发送https带有证书的连接client
	private final ConcurrentMap<String, CloseableHttpClient> httpsClients = new ConcurrentHashMap<String, CloseableHttpClient>();

	private HttpClientUtilImpl() {
		this(200);
	}

	/**
	 * @param connectionPerRoute
	 *            单一Client的最大可以连接数
	 * 
	 */
	private HttpClientUtilImpl(int connectionPerRoute) {
		this.connectionPerRoute = connectionPerRoute;
		client = createHttpClient();
	}

	/**
	 * 返回HttpUtil工具类实例
	 * 
	 * @param config
	 *            配置项 读取clientPerRoute的设置
	 * @return {@code HttpClientUtil}
	 */
	public static final HttpClientUtil getInstance(Config config) {
		int connectionPerRoute = 200;
		// 此处有NullPointerException
		if (config.connectionsPerRoute() != null) {
			try {
				connectionPerRoute = Integer.valueOf(config.connectionsPerRoute());
			} catch (Exception e) {
				// just ignore
			}
		}
		return new HttpClientUtilImpl(connectionPerRoute);
	}

	private CloseableHttpClient createHttpClient() {
		// 因微信的服务器响应延时大约为500ms~~1.5s,因此有必要增加单一点对点最大连接数,在下一步优化中应放入配置文件里
		CloseableHttpClient client = HttpClients.custom().setMaxConnPerRoute(connectionPerRoute)
				.setMaxConnTotal(connectionPerRoute).build();
		return client;
	}

	/**
	 * 返回配置微信商户的p12文件的加密连接客户端
	 * 
	 * @param config
	 *            微信商户的mchId和加密秘钥文件位置
	 * @return 加密客户端,当加载配置失败时,返回null.
	 */
	private CloseableHttpClient getHttpsClient(Config config) {
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
	private CloseableHttpClient getPkcs12Client(Config config) throws Exception {
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		FileInputStream instream = new FileInputStream(new File(config.pkcs12()));
		try {
			keyStore.load(instream, config.mchId().toCharArray());
		} finally {
			instream.close();
		}
		// Trust own CA and all self-signed certs
		// 私有key在微信中默认以mchId作为密钥
		SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, config.mchId().toCharArray()).build();
		// Allow TLSv1 protocol only
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null,
				SSLConnectionSocketFactory.getDefaultHostnameVerifier());
		CloseableHttpClient httpclient = HttpClients.custom().setMaxConnPerRoute(connectionPerRoute)
				.setMaxConnTotal(connectionPerRoute).setSSLSocketFactory(sslsf).build();

		return httpclient;
	}

	/**
	 * 保持httpClient仅拥有一个实例,完成微信支付,向服务器发送支付订单信息的服务
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.HttpClientUtil#setPost(java.lang
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
		return generalPost(request, url, client);
	}

	/**
	 * 发送使用私有key双向认证的https请求
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.HttpClientUtil#setPost(java.lang
	 *      .String)
	 * @param request
	 *            待发送的xml字符串信息
	 * @param config
	 *            商户配置信息
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
	public String keyCertPost(String request, Config config, String url) {
		return generalPost(request, url, getHttpsClient(config));
	}

	private String generalPost(String request, String url, CloseableHttpClient httpsClient) {
		long seq = sequence.incrementAndGet();
		HttpPost httpPost = createHttpPost(request, url);
		String result = "";
		try {
			log.info("Request:{id:" + seq + " ,url:" + url + ", body: " + request + "}");
			result = execute(seq, httpsClient, httpPost);
			log.info("Response:{id:" + seq + " ,url:" + url + ", body: " + result + "}");
		} catch (ParseException e) {
			log.error(
					"Exception:{id:" + seq + " , message: WeChatPay 请求远程服务时发生 ParseException! " + e.getMessage() + "}",
					e);
		} catch (IOException e) {
			log.error("Exception:{id:" + seq + " , message: WeChatPay 请求远程服务时发生 IOException! " + e.getMessage() + "}",
					e);
		}
		return result;
	}

	private HttpPost createHttpPost(String request, String url) {
		// 定义POST请求
		HttpPost httpPost = new HttpPost(url);

		StringEntity postEntity = new StringEntity(request, "UTF-8");
		httpPost.addHeader("Content-Type", "text/xml");
		httpPost.setEntity(postEntity);
		return httpPost;
	}

	/*
	 * @param seq 用于记录执行序列号的自增标记
	 * 
	 * @param httpClient 用于发送请求的传入{@link CloseableHttpClient}
	 * 
	 * @param httpPost
	 */
	private String execute(long seq, CloseableHttpClient httpClient, HttpPost httpPost)
			throws ParseException, IOException {
		String result;
		// 模拟POST请求并接受服务响应
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(httpPost);
			// 处理响应
			HttpEntity entity = response.getEntity();
			result = getEntity(entity);
			return result;
		} finally {
			// 关闭响应
			try {
				if (response != null)
					response.close();
			} catch (IOException e) {
				StringBuilder builder = new StringBuilder();
				builder.append("Exception:{id:").append(seq).append(", message: WeChatPay 关闭远程服务请求时发生 IOException!--")
						.append(e.getMessage()).append("}");
				log.error(builder.toString(), e);
			}
		}
	}

	/*
	 * @param entity
	 * 
	 * @return
	 * 
	 * @throws IOException
	 * 
	 * @throws ParseException
	 */
	private String getEntity(HttpEntity entity) throws ParseException, IOException {
		return EntityUtils.toString(entity, "UTF-8");
	}

	/**
	 * 当应用停止时,应调用此方法,避免由未释放资源需要释放
	 */
	@Override
	public void close() throws IOException {
		IOException ex = null;
		try {
			if (client != null) {
				client.close();
			}
		} catch (IOException e) {
			ex = e;
		}
		for (CloseableHttpClient client1 : httpsClients.values()) {
			if (client1 != null) {
				try {
					client1.close();
				} catch (IOException e) {
					if (ex == null) {
						ex = e;
					}
				}
			}
		}
		if (ex != null) {
			throw ex;
		}
	}

}
