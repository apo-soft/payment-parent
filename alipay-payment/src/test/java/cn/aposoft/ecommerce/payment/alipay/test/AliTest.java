package cn.aposoft.ecommerce.payment.alipay.test;

import cn.aposoft.ecommerce.payment.alipay.Config;
import cn.aposoft.ecommerce.payment.alipay.HttpClientUtil;
import cn.aposoft.ecommerce.payment.alipay.PaymentService;
import cn.aposoft.ecommerce.payment.alipay.SingletonHttpClientUtil;
import cn.aposoft.ecommerce.payment.alipay.impl.PayResponse;
import cn.aposoft.ecommerce.payment.alipay.impl.PaymentServiceImpl;
import cn.aposoft.ecommerce.payment.alipay.impl.PropertiesConfig;
import cn.aposoft.ecommerce.payment.alipay.impl.SimpleEntityUtil;
import cn.aposoft.ecommerce.payment.alipay.util.EntityUtil;

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
		order.setService("alipay.acquire.precreate");// 目前属于固定参数，api无相关说明
		order.setPartner(config.pid());//
		order.set_input_charset(config.charset());//
		// order.setSign_type("MD5");
		order.setOut_trade_no("F6D8D840890B11E59840FC1C7E19F60_1");
		order.setSubject("测试商品");//
		// order.setPayment_type("1");
		order.setTotal_fee(0.01);
		// 以下参数三选一
		order.setSeller_id(config.pid());
		// order.setSeller_email(seller_email);
		// order.setSeller_account_name(seller_account_name);
		// order.setQr_pay_mode(config.qr_pay_mode());
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

		// Map<String, String> params = new HashMap<String, String>();
		// this.convertOrder2Map(params, order);
		// System.out.println(params);
		HttpClientUtil httpclient = SingletonHttpClientUtil.getInstance();
		EntityUtil entityUtil = new SimpleEntityUtil();

		PaymentService ps = new PaymentServiceImpl(httpclient, entityUtil, config);
		// Map<String, String> result = ps.prepareMap(params);
		PayResponse response = ps.preparePay(order);

		System.out.println(response.getIs_success());
		System.out.println("Result_code:" + response.getResult_code());
		System.out.println("url地址：" + response.getPic_url());
		System.out.println("二维码地址：" + response.getQr_code());
		System.out.println("支付宝返回签名：" + response.getSign());
		System.out.println("error_code:" + response.getDetail_error_code());
		System.out.println("error_des:" + response.getDetail_error_des());

	}

	public static void main(String[] args) {
		AliTest ali = new AliTest();
		// ali.config();
		ali.payTest();
		// ali.subResult();
	}

}
