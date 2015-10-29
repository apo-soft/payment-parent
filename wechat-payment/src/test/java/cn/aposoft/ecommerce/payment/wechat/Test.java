package cn.aposoft.ecommerce.payment.wechat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cn.aposoft.ecommerce.payment.wechat.impl.PropertiesConfig;
import cn.aposoft.ecommerce.payment.wechat.impl.PaymentServiceImpl;
import cn.aposoft.ecommerce.payment.wechat.util.EntityUtil;
import cn.aposoft.ecommerce.payment.wechat.util.EntityUtilTest;
import cn.aposoft.ecommerce.payment.wechat.util.HttpClientUtil;
import cn.aposoft.ecommerce.payment.wechat.util.SimpleEntityUtil;
import cn.aposoft.ecommerce.payment.wechat.util.SingletonHttpClientUtil;

public class Test {
	private static Config config = new PropertiesConfig("E:/environments/pay/wechat/wechatpay.properties", "utf-8");

	/**
	 * 退款测试
	 * 
	 * @author Yujinshui
	 */
	public static void refundTest_1() {

		HttpClientUtil httpUtil = SingletonHttpClientUtil.getInstance();
		EntityUtil entityUtil = SimpleEntityUtil.getInstance();

		// 支付内容
		OrderVo order = setValue(config, httpUtil);

		PaymentService payService = new PaymentServiceImpl(config, httpUtil, entityUtil);

		RefundVo refund = new RefundVo();

		// refund.setDevice_info("设备信息");

		refund.setNonce_str("1098415178");
		refund.setOp_user_id("op_user_id 操作员 于津水");
		refund.setOut_refund_no("1002240240201510251334363255");// 退款单号（支付单号）
		refund.setOut_trade_no("20151025_1");
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
		// order.setAppid(config.appId());
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
		order.setOut_trade_no("20151027_1");// 只要未支付，即可继续重复使用该单号
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

	/**
	 * 订单查询
	 * 
	 * <pre>
	 <xml>
	<appid><![CDATA[123]]></appid>
	<cash_fee><![CDATA[10]]></cash_fee>
	<mch_id><![CDATA[123]]></mch_id>
	<nonce_str><![CDATA[123]]></nonce_str>
	<out_refund_no_0><![CDATA[123]]></out_refund_no_0>
	<out_trade_no><![CDATA[123]]></out_trade_no>
	<refund_channel_0><![CDATA[ORIGINAL]]></refund_channel_0>
	<refund_count>1</refund_count>
	<refund_fee>10</refund_fee>
	<refund_fee_0>10</refund_fee_0>
	<refund_id_0><![CDATA[123]]></refund_id_0>
	<refund_status_0><![CDATA[SUCCESS]]></refund_status_0>
	<result_code><![CDATA[SUCCESS]]></result_code>
	<return_code><![CDATA[SUCCESS]]></return_code>
	<return_msg><![CDATA[OK]]></return_msg>
	<sign><![CDATA[F9C4881F5F6DFF73714D6601B1926F37]]></sign>
	<total_fee><![CDATA[10]]></total_fee>
	<transaction_id><![CDATA[1002240240201510251334363255]]></transaction_id>
	</xml>
	 * </pre>
	 * 
	 * @author Yujinshui
	 * @time 2015年10月27日 下午10:40:06
	 */
	public static void orderQuery() {
		HttpClientUtil httpUtil = SingletonHttpClientUtil.getInstance();
		EntityUtil entityUtil = SimpleEntityUtil.getInstance();

		OrderQueryVo query = setQuery();
		PaymentService payService = new PaymentServiceImpl(config, httpUtil, entityUtil);
		OrderQueryResponse outquery = payService.query(query);
		System.out.println("订单信息展示：");
		System.out.println(outquery.getAppid());
		System.out.println(outquery.getTrade_state());
		System.out.println(outquery.getBank_type());
		System.out.println(outquery.getTrade_type());
		System.out.println(outquery.getDevice_info());
		System.out.println(outquery.getTotal_fee());
		System.out.println(outquery.getAttach());
	}

	/**
	 * 订单查询
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年10月27日 下午11:00:15
	 */
	public static OrderQueryVo setQuery() {
		OrderQueryVo query = new OrderQueryVo();
		// query.setOut_trade_no("");
		query.setTransaction_id("1005680240201510261343957061");
		return query;
	}

	public static void refundQuery() {

		HttpClientUtil httpUtil = SingletonHttpClientUtil.getInstance();
		EntityUtil entityUtil = SimpleEntityUtil.getInstance();

		PaymentService payService = new PaymentServiceImpl(config, httpUtil, entityUtil);
		RefundQuery params = RefundQueryVo.demo();

		long begin = System.currentTimeMillis();
		RefundQueryResponse response = payService.refundQuery(params);
		long end = System.currentTimeMillis();
		System.out.println("elapse:" + (end - begin));
		EntityUtilTest.printRefundQueryResponseResult(response);
	}

	/**
	 * 下载对账单测试用例
	 */
	public static void downloadBill() {
		HttpClientUtil httpUtil = SingletonHttpClientUtil.getInstance();
		EntityUtil entityUtil = SimpleEntityUtil.getInstance();

		PaymentService payService = new PaymentServiceImpl(config, httpUtil, entityUtil);
		DownloadBill params = DownloadBillVo.demo();
		long begin = System.currentTimeMillis();
		DownloadBillResponse downloadBills = payService.downloadBill(params);
		long end = System.currentTimeMillis();
		System.out.println("elapse:" + (end - begin));
		System.out.println("对账单信息：");
		System.out.println(downloadBills.getReturn_code());
		System.out.println(downloadBills.getReturn_msg());
		char c = downloadBills.getData().charAt(0);

		System.out.printf("%x\r\n%s\r\n", (int) c, downloadBills.getData().substring(1, 5));
		System.out.println(downloadBills.getData());
	}

	public static void main(String[] args) {
		// 生成的微信链接，只要不进行支付，在有效期内，就一直处于可用状态
		// payInfo_1();//支付测试
		// refundTest_1();//退款测试
		// orderQuery();// 订单测试
		refundQuery();// 退款查询测试
		// 下载对账单测试
		// downloadBill(); // 对账单测试

	}

}
