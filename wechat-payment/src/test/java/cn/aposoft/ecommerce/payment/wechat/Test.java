package cn.aposoft.ecommerce.payment.wechat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cn.aposoft.ecommerce.payment.wechat.impl.NotificationResult;
import cn.aposoft.ecommerce.payment.wechat.impl.PaymentServiceImpl;
import cn.aposoft.ecommerce.payment.wechat.impl.PropertiesConfig;
import cn.aposoft.ecommerce.payment.wechat.impl.ReflectEntityUtil;
import cn.aposoft.ecommerce.payment.wechat.impl.HttpClientUtilImpl;
import cn.aposoft.ecommerce.payment.wechat.util.DownloadBillResultParserTest;
import cn.aposoft.ecommerce.payment.wechat.util.EntityUtilTest;

public class Test {
	private static Config config = new PropertiesConfig("E:/environments/pay/wechat/wechatpay.properties", "utf-8");

	private static HttpClientUtil httpUtil = HttpClientUtilImpl.getInstance(config);
	private static EntityUtil entityUtil = ReflectEntityUtil.getInstance();

	private static PaymentService payService = new PaymentServiceImpl(config, httpUtil, entityUtil);

	public static void payInfo_1() {

		// OrderVo order = setValue(config);
		OrderVo order = setValue1(config);
		PayResponse result = payService.preparePay(order);
		System.out.println("app_id:" + result.getAppid());
		System.out.println("code_url:" + result.getCode_url());
		System.out.println("device_info:" + result.getDevice_info());
		System.out.println("return_code:" + result.getReturn_code());
		System.out.println("OK:" + result.getReturn_msg());
	}

	public static OrderVo setValue1(Config config) {

		OrderVo order = new OrderVo();
		order.setBody("电脑");
		order.setGoods_tag("no");
		order.setOut_trade_no("swrtjtdw");// 只要未支付，即可继续重复使用该单号
		order.setSpbill_create_ip("127.0.0.1");
		order.setTrade_type("NATIVE");
		order.setTotal_fee(43);
		// order.setAppid(config.appId());
		// order.setAttach(attach);
		// order.setDetail(detail);
		// order.setDevice_info("Device_info");
		// order.setFee_type(fee_type);
		// order.setOpenid(openid);
		// order.setProduct_id(product_id);
		// order.setTime_start(getTime());// 设定交易有效的时间范围
		// order.setTime_expire(getTime2());// 设定交易有效的时间范围

		return order;
	}

	static int i = 1;

	public static OrderVo setValue(Config config) {
		i++;
		OrderVo order = new OrderVo();
		order.setBody("iPhone 6s Plus 16GB 金色");
		order.setGoods_tag("no");
		order.setOut_trade_no("20160113_" + i);// 只要未支付，即可继续重复使用该单号
		order.setSpbill_create_ip("127.0.0.1");
		order.setTrade_type("NATIVE");
		order.setTotal_fee(100);
		// order.setAppid(config.appId());
		// order.setAttach(attach);
		// order.setDetail(detail);
		// order.setDevice_info("Device_info");
		// order.setFee_type(fee_type);
		// order.setOpenid(openid);
		// order.setProduct_id(product_id);
		// order.setTime_start(getTime());// 设定交易有效的时间范围
		// order.setTime_expire(getTime2());// 设定交易有效的时间范围

		return order;
	}

	/**
	 * 退款测试
	 * 
	 * @author Yujinshui
	 */
	public static void refundTest_1() {

		// 支付内容
		// OrderVo order = setValue(config, httpUtil);

		RefundVo refund = new RefundVo();

		// refund.setDevice_info("设备信息");

		refund.setNonce_str("201601141855");
		refund.setOp_user_id("wechat-1");
		refund.setOut_refund_no("1009160896201601142697805964");// 退款单号（支付单号）

		refund.setOut_trade_no("A7E7ABE0BAAB11E5B0E4B53447D52D06");
		refund.setRefund_fee(400);
		refund.setRefund_fee_type("CNY");
		refund.setTotal_fee(400);
		// refund.setTransaction_id("http://120.25.221.200:8087/svmservice/wechatpay/paySuccess");//
		// prepay_id
		// 微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
		RefundResponse result = payService.refund(refund);
		System.out.println(result.getTotal_fee());
		System.out.println(result.getReturn_code());
		System.out.println(result.getReturn_msg());
		System.out.println(result.getOut_trade_no());
		System.out.println(result.getErr_code());
		System.out.println(result.getErr_code_des());

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

		OrderQueryVo query = setQuery();
		OrderQueryResponse outquery = payService.query(query);
		System.out.println("订单信息展示：");
		System.out.println(outquery.getTransaction_id());
		System.out.println(outquery.getAppid());
		System.out.println(outquery.getTrade_state());
		System.out.println(outquery.getBank_type());
		System.out.println(outquery.getTrade_type());
		System.out.println(outquery.getDevice_info());
		System.out.println(outquery.getTotal_fee());
		System.out.println(outquery.getAttach());
		System.out.println(outquery.getOpenid());
		System.out.println(outquery.getTime_end());
		System.out.println(outquery.getOut_trade_no());
		System.out.println(outquery.getTrade_state_desc());
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
		query.setTransaction_id("1009250532201602153282119059");
		// query.setOut_trade_no("DE5773D0BDBD11E5ABE7F23AD07C9706");
		return query;
	}

	public static void refundQuery() {

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

		DownloadBill params = DownloadBillVo.demo();
		long begin = System.currentTimeMillis();
		DownloadBillResponse downloadBills = payService.downloadBill(params);
		long end = System.currentTimeMillis();

		System.out.println("elapse:" + (end - begin));
		System.out.println("对账单信息：");

		System.out.println(downloadBills.getReturn_code());
		System.out.println(downloadBills.getReturn_msg());
		// 判断是否有数据
		if (downloadBills.getData() == null || downloadBills.getData().isEmpty()) {
			return;
		}

		DownloadBillResultParserTest.print(downloadBills);
		// outputToFile(downloadBills.getData());
	}

	/**
	 * 输出到文件
	 * 
	 * @param data
	 *            待传输的文件内容
	 */
	public static void outputToFile(String data) {
		File file = new File("downloadbill-response.txt");
		try (Writer writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");) {
			writer.write(data);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createNotificationResultXmlTest() {
		NotificationResult notificationResult = new NotificationResult();
		notificationResult.setReturn_code("SUCCESS");
		notificationResult.setReturn_msg("OK");
		String xml = notificationResult.toXml();
		System.out.println(xml);
	}

	public static void main(String[] args) {
		// 生成的微信链接，只要不进行支付，在有效期内，就一直处于可用状态

		payInfo_1();// 支付测试

		// refundTest_1();// 退款测试
		// orderQuery();// 订单测试
		// refundQuery();// 退款查询测试
		// 下载对账单测试

		// createNotificationResultXmlTest();
		// downloadBill(); // 对账单测试
		try {
			payService.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
