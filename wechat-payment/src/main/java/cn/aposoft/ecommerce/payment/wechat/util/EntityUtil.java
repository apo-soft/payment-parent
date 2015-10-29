/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.util;

import cn.aposoft.ecommerce.payment.wechat.CloseOrder;
import cn.aposoft.ecommerce.payment.wechat.CloseOrderResponse;
import cn.aposoft.ecommerce.payment.wechat.Config;
import cn.aposoft.ecommerce.payment.wechat.DownloadBill;
import cn.aposoft.ecommerce.payment.wechat.DownloadBillResponse;
import cn.aposoft.ecommerce.payment.wechat.Notification;
import cn.aposoft.ecommerce.payment.wechat.Order;
import cn.aposoft.ecommerce.payment.wechat.OrderQuery;
import cn.aposoft.ecommerce.payment.wechat.OrderQueryResponse;
import cn.aposoft.ecommerce.payment.wechat.PayResponse;
import cn.aposoft.ecommerce.payment.wechat.Refund;
import cn.aposoft.ecommerce.payment.wechat.RefundQuery;
import cn.aposoft.ecommerce.payment.wechat.RefundQueryResponse;
import cn.aposoft.ecommerce.payment.wechat.RefundResponse;

/**
 * 支付与退款的过程封装
 * 
 * @author LiuJian
 *
 */
public interface EntityUtil {
	/**
	 * 根据order和config创建待发送的支付信息xml字符串
	 * 
	 * @param order
	 *            订单信息
	 * @param config
	 *            配置内容
	 * @return
	 */
	String generatePayXml(Order order, Config config);

	/**
	 * 根据refund和config创建退款信息xml字符串
	 * 
	 * @param refund
	 *            退款信息
	 * @param config
	 *            配置内容
	 * @return
	 * @author Yujinshui
	 */
	String generateRefundXml(Refund refund, Config config);

	/**
	 * [支付]将返回的map结果解析成PayResponse-javabean
	 * 
	 * @param xml
	 * @return
	 */
	PayResponse parsePayResponseXml(String xml);

	/**
	 * 将支付成功后返回的结果进行javabean格式化
	 * 
	 * @param xml
	 * @return
	 */
	Notification parseNotificationXml(String xml);

	/**
	 * [退款]将返回的map结果解析成javabean
	 * 
	 * @param xml
	 * @return
	 * @author Yujinshui
	 */
	RefundResponse parseRefundResponseXml(String xml);

	/**
	 * 创建订单查询xml字符串
	 * 
	 * @param params
	 * @param config
	 * @return
	 * @author Yujinshui
	 * @time 2015年10月26日 下午10:30:40
	 */
	String generateOrderQueryXml(OrderQuery params, Config config);

	/**
	 * 解析订单查询字符结果，并返回OrderQueryResponse对象
	 * 
	 * @param responseText
	 * @return
	 * @author Yujinshui
	 * @time 2015年10月26日 下午10:31:20
	 */
	OrderQueryResponse parseOrderQueryResponseXml(String responseText);

	/**
	 * 构建"关闭订单"业务xml格式字符串
	 * 
	 * @param params
	 *            传入的关闭订单参数对象
	 * @param config
	 *            商户配置信息
	 * @return "关闭订单"业务xml格式字符串
	 * 
	 *         <pre>
					<xml>
						<appid>wx2421b1c4370ec43b</appid>
						<mch_id>10000100</mch_id>
						<nonce_str>4ca93f17ddf3443ceabf72f26d64fe0e</nonce_str>
						<out_trade_no>1415983244</out_trade_no>
						<sign>59FF1DF214B2D279A0EA7077C54DD95D</sign>
					</xml>
	 *         </pre>
	 */
	String generateCloseOrderXml(CloseOrder params, Config config);

	/**
	 * 解析关闭订单返回结果响应对象实例
	 * 
	 * @param xml
	 *            微信服务器返回的订单结果响应报文
	 * 
	 *            <pre>
					<xml>
					   <return_code><![CDATA[SUCCESS]]></return_code>
					   <return_msg><![CDATA[OK]]></return_msg>
					   <appid><![CDATA[wx2421b1c4370ec43b]]></appid>
					   <mch_id><![CDATA[10000100]]></mch_id>
					   <nonce_str><![CDATA[BFK89FC6rxKCOjLX]]></nonce_str>
					   <sign><![CDATA[72B321D92A7BFA0B2509F3D13C7B1631]]></sign>
					   <result_code><![CDATA[SUCCESS]]></result_code>
					</xml>
	 *            </pre>
	 * 
	 * @return "关闭订单"结果响应的对标实例
	 */
	CloseOrderResponse parseCloseOrderResponseXml(String xml);

	/**
	 * 构建退款查询请求xml报文信息
	 * 
	 * @param params
	 *            退款查询请求参数
	 * @param config
	 *            商户配置信息
	 * @return 退款查询请求的xml报文内容
	 */
	String generateRefundQueryXml(RefundQuery params, Config config);

	/**
	 * 构建退款查询响应的Xml文件
	 * 
	 * @param xml
	 *            退款查询返回的报文协议文本
	 * @return 退款查询响应实体
	 */
	RefundQueryResponse parseRefundQueryResponseXml(String xml);

	/**
	 * 生成下载对账单的xml请求报文
	 * 
	 * @param params
	 *            对账单查询参数
	 * @param config
	 *            商户配置信息
	 * @return 发送到微信端的请求报文
	 */
	String generateDownloadBillXml(DownloadBill params, Config config);

	/**
	 * 微信对账单返回信息的定制查询
	 * 
	 * @param responseText
	 *            响应报文
	 * @return 响应信息的实例对象
	 */
	DownloadBillResponse parseDownloadBillResponseXml(String responseText);
}
