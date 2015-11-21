package cn.aposoft.ecommerce.payment.alipay.test;

import java.math.BigDecimal;

import cn.aposoft.ecommerce.payment.alipay.Config;
import cn.aposoft.ecommerce.payment.alipay.EntityUtil;
import cn.aposoft.ecommerce.payment.alipay.HttpClientUtil;
import cn.aposoft.ecommerce.payment.alipay.PaymentService;
import cn.aposoft.ecommerce.payment.alipay.impl.PaymentServiceImpl;
import cn.aposoft.ecommerce.payment.alipay.impl.RefundResponse;

/**
 * 退款数据信息
 * 
 * @author Yujinshui
 *
 */
public class RefundDemo {
	Config config;
	HttpClientUtil httpclient;
	EntityUtil entityUtil;

	/**
	 * 初始化所需参数
	 * 
	 * @param config
	 * @param httpclient
	 * @param entityUtil
	 */
	public RefundDemo(Config config, HttpClientUtil httpclient, EntityUtil entityUtil) {
		this.config = config;
		this.httpclient = httpclient;
		this.entityUtil = entityUtil;

	}

	public String refundTest() {
		RefundVo fund = setValue();
		PaymentService ps = new PaymentServiceImpl(httpclient, entityUtil, config);
		RefundResponse response = ps.refund(fund);
		System.out.println(response.getReturnXml());
		System.out.println("Is_success:" + response.getIs_success());
		System.out.println("商户网站唯一订单号 :" + response.getOut_trade_no());
		System.out.println("退款金额（元）：" + response.getRefund_fee());
		System.out.println("支付宝返回签名 :" + response.getSign());
		System.out.println("签名类型：" + response.getSign_type());
		System.out.println("支付宝交易号：" + response.getTrade_no());
		System.out.println("退款处理结果响应码。:" + response.getResult_code());
		System.out.println("退款时间：" + response.getGmt_refund_pay());
		System.out.println("错误码 ：" + response.getDetail_error_code());
		System.out.println("错误描述:" + response.getDetail_error_des());
		System.out.println("sign校验结果：" + response.getIsAliPay());
		return null;
	}

	/**
	 * 赋值测试数据
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月16日 上午11:21:05
	 */
	private RefundVo setValue() {
		RefundVo fund = new RefundVo();
		fund.setService("alipay.acquire.refund");
		fund.setOut_trade_no("F6D8D840890B11E59840FC1C7E19F60_3");
		BigDecimal b = new BigDecimal(0.01);
		fund.setRefund_amount(b);

		return fund;
	}
}
