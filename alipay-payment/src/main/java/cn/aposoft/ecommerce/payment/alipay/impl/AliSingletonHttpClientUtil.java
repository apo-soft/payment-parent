package cn.aposoft.ecommerce.payment.alipay.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.apache.log4j.Logger;

import cn.aposoft.ecommerce.payment.alipay.AliConfig;
import cn.aposoft.ecommerce.payment.alipay.AliHttpClientUtil;
import cn.aposoft.ecommerce.payment.alipay.httpClient.HttpProtocolHandler;
import cn.aposoft.ecommerce.payment.alipay.httpClient.HttpRequest;
import cn.aposoft.ecommerce.payment.alipay.httpClient.HttpResponse;
import cn.aposoft.ecommerce.payment.alipay.httpClient.HttpResultType;
import cn.aposoft.ecommerce.payment.alipay.util.MapUtil;

public class AliSingletonHttpClientUtil implements AliHttpClientUtil {
	public static Logger log = Logger.getLogger(AliSingletonHttpClientUtil.class);

	private static AliSingletonHttpClientUtil instance = new AliSingletonHttpClientUtil();

	private AliSingletonHttpClientUtil() {
	}

	public static final AliHttpClientUtil getInstance() {
		return instance;
	}

	/**
	 * 创建发送请求
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.AliHttpClientUtil#post(java.util.Map,
	 *      cn.aposoft.ecommerce.payment.alipay.AliConfig)
	 */
	@Override
	public String post(Map<String, String> params, AliConfig config) {
		return generalPost(params, config);
	}

	private String generalPost(Map<String, String> params, AliConfig config) {
		// System.out.println("\n======AliPay 请求统一下单 开始: 上行======\n");
		long start = System.currentTimeMillis();
		HttpProtocolHandler httpProtocolHandler = HttpProtocolHandler.getInstance();
		HttpRequest request = new HttpRequest(HttpResultType.BYTES);
		// 设置编码集
		request.setCharset(config.charset());
		request.setParameters(MapUtil.generatNameValuePair(params));
		request.setUrl(config.ali_gateway() + "?_input_charset=" + config.charset());
		HttpResponse response = null;
		try {
			response = httpProtocolHandler.execute(request, "", "");
		} catch (IOException e) {
			log.error("发送支付宝支付/退款请求失败:" + e.getMessage(), e);
			e.printStackTrace();
		}
		if (response == null) {
			return null;
		}
		String result = null;
		// System.out.println("\n======AliPay 请求统一下单 开始: 下行======\n");
		try {
			result = response.getStringResult(config.charset());
		} catch (UnsupportedEncodingException e) {
			log.error("支付宝请求下行协议获取异常：" + e.getMessage(), e);
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("请求消耗时间：" + (end - start));
		return result;
	}

	/**
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.AliHttpClientUtil#refund(java.util.Map,
	 *      cn.aposoft.ecommerce.payment.alipay.AliConfig)
	 */
	@Override
	public String refund(Map<String, String> params, AliConfig config) {
		return generalPost(params, config);
	}

}
