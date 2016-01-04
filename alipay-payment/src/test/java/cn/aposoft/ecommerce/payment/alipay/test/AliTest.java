package cn.aposoft.ecommerce.payment.alipay.test;

import cn.aposoft.ecommerce.payment.alipay.Config;
import cn.aposoft.ecommerce.payment.alipay.EntityUtil;
import cn.aposoft.ecommerce.payment.alipay.HttpClientUtil;
import cn.aposoft.ecommerce.payment.alipay.impl.PayResponse;
import cn.aposoft.ecommerce.payment.alipay.impl.PropertiesConfig;
import cn.aposoft.ecommerce.payment.alipay.impl.SimpleEntityUtil;
import cn.aposoft.ecommerce.payment.alipay.impl.SingletonHttpClientUtil;

public class AliTest {

	Config config = new PropertiesConfig("E:/environments/pay/ali/alipay.properties", "utf-8");
	HttpClientUtil httpclient = SingletonHttpClientUtil.getInstance();
	EntityUtil entityUtil = new SimpleEntityUtil();

	public void pay() {
		PayDemo pay = new PayDemo(config, httpclient, entityUtil);
		PayResponse response = pay.payTest();

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
