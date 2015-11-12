package cn.aposoft.ecommerce.payment.alipay.test;

import java.util.HashMap;
import java.util.Map;

import cn.aposoft.ecommerce.payment.alipay.config.PropertiesConfig;
import cn.aposoft.ecommerce.payment.alipay.inter.Config;
import cn.aposoft.ecommerce.payment.alipay.util.JsonUtil;
import cn.aposoft.ecommerce.payment.alipay.vo.instant.InstantCountRequest;

public class AliTest {

	Config config = new PropertiesConfig("E:/environments/pay/ali/alipay.properties", "utf-8");
	// Config configProject = new PropertiesConfig();

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
		order.setService("");// TODO 内容无法确定
		order.setPartner(config.pid());
		order.set_input_charset(config.charset());
		order.setSign_type("MD5");
		order.setOut_trade_no("2015-11-12_1055");
		order.setSubject("黄金AK_47");
		order.setPayment_type("1");
		order.setTotal_fee(0.10);
		// 以下参数三选一
		order.setSeller_id(config.pid());
		// order.setSeller_email(seller_email);
		// order.setSeller_account_name(seller_account_name);
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
		params.put("service", order.getService());
		params.put("partner", order.getPartner());
		params.put("_input_charset", order.get_input_charset());
		params.put("sign_type", order.getSign_type());
		params.put("sign", order.getSign());// TODO 不确定目前是否需要
		// 业务参数
		params.put("out_trade_no", order.getOut_trade_no());
		params.put("subject", order.getSubject());
		params.put("payment_type", order.getPayment_type());
		params.put("total_fee", order.getTotal_fee() + "");
		params.put("seller_id", order.getSeller_id());
		// params.put("seller_email", order.getSeller_email());
		// params.put("seller_account_name", order.getSeller_account_name());

	}

	/**
	 * 支付测试
	 * 
	 * @author Yujinshui
	 * @time 2015年11月12日 上午10:26:23
	 */
	public void voTest() {
		InstantCountRequest order = new InstantCountRequest();
		this.setOrder(order);

		Map<String, String> params = new HashMap<String, String>();
		this.convertOrder2Map(params, order);

		String output = JsonUtil.ObjectToJson(params);
		System.out.println(output);
	}

	public static void main(String[] args) {
		AliTest ali = new AliTest();
		// ali.config();
		ali.voTest();
	}

}
