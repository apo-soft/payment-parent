package cn.aposoft.ecommerce.payment.alipay.test;

import cn.aposoft.ecommerce.payment.alipay.AliConfig;
import cn.aposoft.ecommerce.payment.alipay.AliEntityUtil;
import cn.aposoft.ecommerce.payment.alipay.AliHttpClientUtil;
import cn.aposoft.ecommerce.payment.alipay.impl.AliPayResponse;
import cn.aposoft.ecommerce.payment.alipay.impl.AliPropertiesConfig;
import cn.aposoft.ecommerce.payment.alipay.impl.AliSimpleEntityUtil;
import cn.aposoft.ecommerce.payment.alipay.impl.AliSingletonHttpClientUtil;

import java.util.HashMap;
import java.util.Map;

public class AliTest {

	private Map<String,String> map = new HashMap<>();
	//	AliConfig config = new AliPropertiesConfig("E:/environments/properties/pay/ali/alipay.properties", "utf-8");
private AliConfig config = new AliPropertiesConfig();
	AliHttpClientUtil httpclient = AliSingletonHttpClientUtil.getInstance();
	AliEntityUtil entityUtil = new AliSimpleEntityUtil();

	public void pay() {
		PayDemo pay = new PayDemo(config, httpclient, entityUtil);
		AliPayResponse response = pay.payTest();

		System.out.println(response.getReturnXml());
		System.out.println(response.getIs_success());
		System.out.println("Result_code:" + response.getResult_code());
		System.out.println("url地址：" + response.getPic_url());
		System.out.println("二维码地址：" + response.getQr_code());
		System.out.println("支付宝返回签名：" + response.getSign());
		System.out.println("error:"+response.getError());
		System.out.println("error_code:" + response.getDetail_error_code());
		System.out.println("error_des:" + response.getDetail_error_des());
		System.out.println(response.getIsAliPay());
	}

	public void refund() {
		RefundDemo refund = new RefundDemo(config, httpclient, entityUtil);
		refund.refundTest();
	}

	// 异步回调地址：yangxinxin-163.6655.la:16834
	public static void main(String[] args) {
		AliTest ali = new AliTest();
//		ali.refund();
		 ali.pay();
	}

}
