package cn.aposoft.ecommerce.payment.wechat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cn.aposoft.ecommerce.payment.wechat.impl.PropertiesConfig;
import cn.aposoft.ecommerce.payment.wechat.impl.PaymentServiceImpl;
import cn.aposoft.ecommerce.payment.wechat.util.EntityUtil;
import cn.aposoft.ecommerce.payment.wechat.util.HttpClientUtil;
import cn.aposoft.ecommerce.payment.wechat.util.SimpleEntityUtil;
import cn.aposoft.ecommerce.payment.wechat.util.SingletonHttpClientUtil;

public class Test {

	/**
	 * 退款测试
	 * 
	 * @author Yujinshui
	 */
	public static void refundTest_1() {

		Config config = new PropertiesConfig("E:/environments/pay/wechat/wechatpay.properties");
		HttpClientUtil httpUtil = SingletonHttpClientUtil.getInstance();
		EntityUtil entityUtil = SimpleEntityUtil.getInstance();

		// 支付内容
		OrderVo order = setValue(config, httpUtil);

		PaymentService payService = new PaymentServiceImpl(config, httpUtil, entityUtil);

		RefundVo refund = new RefundVo();
		refund.setAppid(config.appId());
		// refund.setDevice_info("设备信息");
		refund.setMch_id("1242048202");
		;
		refund.setNonce_str("1098415178");
		refund.setOp_user_id("op_user_id 操作员 于津水");
		refund.setOut_refund_no("1010090240201510231298712127");// 退款单号（支付单号）
		refund.setOut_trade_no("20151023_2");
		refund.setRefund_fee(order.getTotal_fee());
		refund.setRefund_fee_type("CNY");
		refund.setTotal_fee(order.getTotal_fee());
		// refund.setTransaction_id("http://120.25.221.200:8087/svmservice/wechatpay/paySuccess");//
		// prepay_id
		// 微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
		RefundResponse result = payService.refund(refund);
		System.out.println(result.getReturn_code());
		System.out.println(result.getReturn_msg());
		System.out.println(result.getErr_code());
		System.out.println(result.getErr_code_des());

	}

	public static OrderVo setValue(Config config, HttpClientUtil httpUtil) {
		OrderVo order = new OrderVo();
		order.setAppid(config.appId());
		// order.setAttach(attach);
		order.setBody("Ipad mini  16G  白色1023_2");
		// order.setDetail(detail);
		// order.setDevice_info("Device_info");
		// order.setFee_type(fee_type);
		order.setGoods_tag("no");
		order.setMch_id(config.mchId());
		order.setNonce_str("1234567890321");
		order.setNotify_url("http://shuijiayou.tunnel.mobi/count/pay/paySuccess");
		// order.setOpenid(openid);
		order.setOut_trade_no("20151023_2");//只要未支付，即可继续重复使用该单号
		// order.setProduct_id(product_id);
		order.setSpbill_create_ip("127.0.0.1");
		// order.setTime_start(getTime());//设定交易有效的时间范围
		// order.setTime_expire(getTime2());//设定交易有效的时间范围
		order.setTotal_fee(10);
		order.setTrade_type("NATIVE");

		return order;
	}

	public static String getTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
	}

	public static String getTime2() {
		Calendar time = Calendar.getInstance();
		time.add(Calendar.MINUTE, 1);
		Date date = time.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
	}

	public static void payInfo_1() {
		Config config = new PropertiesConfig("E:/environments/pay/wechat/wechatpay.properties","utf-8");
		HttpClientUtil httpUtil = SingletonHttpClientUtil.getInstance();
		EntityUtil entityUtil = SimpleEntityUtil.getInstance();

		OrderVo order = setValue(config, httpUtil);
		PaymentService payService = new PaymentServiceImpl(config, httpUtil, entityUtil);
		PayResponse result = payService.preparePay(order);
		System.out.println(result.getAppid());
		System.out.println(result.getCode_url());
		System.out.println(result.getDevice_info());
		System.out.println(result.getReturn_code());
		System.out.println(result.getReturn_msg());
	}
 
	public static void main(String[] args) {
		//生成的微信链接，只要不进行支付，在有效期内，就一直处于可用状态
		payInfo_1();
//		 refundTest_1();

	}

}
