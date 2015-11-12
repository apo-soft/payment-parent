package cn.aposoft.ecommerce.payment.alipay.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.NameValuePair;

import cn.aposoft.ecommerce.payment.alipay.config.PropertiesConfig;
import cn.aposoft.ecommerce.payment.alipay.httpClient.HttpProtocolHandler;
import cn.aposoft.ecommerce.payment.alipay.httpClient.HttpRequest;
import cn.aposoft.ecommerce.payment.alipay.httpClient.HttpResponse;
import cn.aposoft.ecommerce.payment.alipay.httpClient.HttpResultType;
import cn.aposoft.ecommerce.payment.alipay.inter.Config;
import cn.aposoft.ecommerce.payment.alipay.sign.Signature;
import cn.aposoft.ecommerce.payment.alipay.util.AlipayCore;
import cn.aposoft.ecommerce.payment.alipay.util.JsonUtil;
import cn.aposoft.ecommerce.payment.alipay.vo.instant.InstantCountRequest;

public class AliTest {

	Config config = new PropertiesConfig("E:/environments/pay/ali/alipay.properties", "utf-8");

	public void config() {

		System.out.println(config);

	}

	/**
	 * 订单参数设置
	 * 
	 * @param order
	 * @author Yujinshui
	 * @time 2015年11月12日 上午10:44:28
	 */
	public void setOrder(InstantCountRequest order) {
		order.setService("alipay.acquire.precreate");//目前属于固定参数，api无相关说明
		order.setPartner(config.pid());//
		order.set_input_charset(config.charset());//
		// order.setSign_type("MD5");
		order.setOut_trade_no("F6D8D840890B11E59840FC1C7E19F601");
		order.setSubject("测试商品");//
		// order.setPayment_type("1");
		order.setTotal_fee(0.10);
		// 以下参数三选一
		order.setSeller_id(config.pid());
		// order.setSeller_email(seller_email);
		// order.setSeller_account_name(seller_account_name);
		// order.setQr_pay_mode(config.qr_pay_mode());
	}

	/**
	 * 订单数据转换
	 * 
	 * @param params
	 * @author Yujinshui
	 * @time 2015年11月12日 上午10:24:37
	 */
	public void convertOrder2Map(Map<String, String> params, InstantCountRequest order) {
		// params.put("", order);
		// 基本参数
		params.put("service", order.getService());//
		params.put("partner", order.getPartner());//
		params.put("_input_charset", order.get_input_charset());//
		// 业务参数
		params.put("out_trade_no", order.getOut_trade_no());//
		params.put("subject", order.getSubject());//
		params.put("payment_type", order.getPayment_type());
		params.put("total_fee", order.getTotal_fee() + "");//
		params.put("seller_id", order.getSeller_id());
		// params.put("notify_url",
		// "http://123.57.147.240:8087/svmservice/alipay/paySuccess");
		// params.put("seller_email", order.getSeller_email());
		// params.put("seller_account_name", order.getSeller_account_name());
		// params.put("qr_pay_mode", order.getQr_pay_mode());
		params.put("product_code", "QR_CODE_OFFLINE");//目前属于固定参数，api无相关说明
	}

	/**
	 * 支付测试
	 * 
	 * @author Yujinshui
	 * @time 2015年11月12日 上午10:26:23
	 */
	public void payTest() {
		InstantCountRequest order = new InstantCountRequest();
		this.setOrder(order);

		Map<String, String> params = new HashMap<String, String>();
		this.convertOrder2Map(params, order);
		System.out.println(params);
		String output = JsonUtil.ObjectToJson(params);
		System.out.println(output);

		String resultXml = sendRequest(params);

		System.out.println(resultXml);
	}

	/**
	 * 发送请求
	 * 
	 * @param params
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月12日 上午11:29:42
	 */
	public String sendRequest(Map<String, String> params) {
		params = createMapRequest(params);
		System.out.println("\n======AliPay 请求统一下单 开始: 上行======\n");
		long start = System.currentTimeMillis();
		HttpProtocolHandler httpProtocolHandler = HttpProtocolHandler.getInstance();
		HttpRequest request = new HttpRequest(HttpResultType.BYTES);
		// 设置编码集
		request.setCharset(config.charset());
		request.setParameters(generatNameValuePair(params));
		request.setUrl(config.ali_gateway() + "?_input_charset=" + config.charset());
		HttpResponse response = null;
		try {
			response = httpProtocolHandler.execute(request, "", "");
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (response == null) {
			return null;
		}
		String result = null;
		System.out.println("\n======AliPay 请求统一下单 开始: 下行======\n");
		try {
			result = response.getStringResult(config.charset());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("消耗时间：" + (end - start));
		return result;
	};

	/**
	 * MAP类型数组转换成NameValuePair类型
	 * 
	 * @param properties
	 *            MAP类型数组
	 * @return NameValuePair类型数组
	 */
	private static NameValuePair[] generatNameValuePair(Map<String, String> properties) {
		NameValuePair[] nameValuePair = new NameValuePair[properties.size()];
		int i = 0;
		for (Map.Entry<String, String> entry : properties.entrySet()) {
			nameValuePair[i++] = new NameValuePair(entry.getKey(), entry.getValue());
		}

		return nameValuePair;
	}

	/**
	 * 对params进行排序，同时添加签名信息
	 * 
	 * @param params
	 * @author Yujinshui
	 * @return
	 * @time 2015年11月12日 上午11:32:32
	 */
	public Map<String, String> createMapRequest(Map<String, String> params) {
		// 除去数组中的空值和签名参数
		Map<String, String> paras = AlipayCore.paraFilter(params);
		String sign = Signature.requestSign_MD5(paras, config);
		paras.put("sign", sign);
		paras.put("sign_type", config.sign_type());
		return paras;
	}

	public static void main(String[] args) {
		AliTest ali = new AliTest();
		// ali.config();
		ali.payTest();
	}

}
