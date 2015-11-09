/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.util;

import java.io.Closeable;
import java.io.IOException;

import cn.aposoft.ecommerce.payment.wechat.Config;

/**
 * 实现对httpClient封装的接口用于发送http请求
 * 
 * @author LiuJian
 *
 */
public interface HttpClientUtil extends Closeable {
	/**
	 * 支付post
	 * 
	 * @param request
	 * @param config
	 * @param url
	 *            请求的url地址
	 * @return
	 * @author Yujinshui
	 * @throws IOException
	 */
	String post(String request, Config config, String url) throws IOException;

	/**
	 * 退款post
	 * 
	 * @param request
	 * @param config
	 * @param url
	 *            请求的url地址
	 * @return
	 * @throws Exception
	 * @author Yujinshui
	 */
	String keyCertPost(String request, Config config, String url) throws Exception;

}
