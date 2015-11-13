package cn.aposoft.ecommerce.payment.alipay.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import cn.aposoft.ecommerce.payment.alipay.HttpClientUtil;
import cn.aposoft.ecommerce.payment.alipay.SingletonHttpClientUtil;
import cn.aposoft.ecommerce.payment.alipay.config.PropertiesConfig;
import cn.aposoft.ecommerce.payment.alipay.impl.PayResponse;
import cn.aposoft.ecommerce.payment.alipay.impl.PaymentServiceImpl;
import cn.aposoft.ecommerce.payment.alipay.impl.SimpleEntityUtil;
import cn.aposoft.ecommerce.payment.alipay.inter.Config;
import cn.aposoft.ecommerce.payment.alipay.inter.EntityUtil;
import cn.aposoft.ecommerce.payment.alipay.inter.PaymentService;
import cn.aposoft.ecommerce.payment.alipay.util.XMLUtil;

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
		params.put("product_code", "QR_CODE_OFFLINE");// 目前属于固定参数，api无相关说明
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
		System.out.println(response.getResult_code());
		System.out.println(response.getPic_url());
		System.out.println(response.getSign());
		System.out.println(response.getDetail_error_code());
		System.out.println(response.getDetail_error_des());
	}

	public static void main(String[] args) {
		AliTest ali = new AliTest();
		// ali.config();
		ali.payTest();
		// ali.subResult();
	}

}
