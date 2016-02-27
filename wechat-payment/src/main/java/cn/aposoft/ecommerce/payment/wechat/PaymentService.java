/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat;

import java.io.Closeable;

/**
 * 主动向微信支付服务器发送各种订单业务相关请求
 * {@link https://pay.weixin.qq.com/wiki/doc/api/index.html}
 * <p>
 * ATTENTION: 有关商户的基本配置信息,应当在支付服务的具体实现中进行加载
 * <ul>
 * <li>1. {@code preparePay} 定义微信支付的统一下单接口封装</li>
 * <li>2. {@code refund} 定义微信支付的申请退款接口</li>
 * <li>3. {@code query} 定义微信支付的订单查询接口</li>
 * <li>4. {@code closeOrder} 定义微信支付的关闭订单接口</li>
 * <li>5. {@code refundQuery} 定义微信支付的退款查询接口</li>
 * <li>6. {@code downloadBill} 定义下载对账单接口</li>
 * </ul>
 * 
 * @author Jann Liu
 * 
 */
public interface PaymentService extends Closeable {

	/**
	 * 统一下单 {@code preparePay(Order order)}完成向微信支付服务器发送预处理订单并处理响应结果
	 * {@link https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_1}
	 * 
	 * 应用场景
	 * 
	 * 除被扫支付场景以外，商户系统先调用该接口在微信支付服务后台生成预支付交易单，返回正确的预支付交易回话标识后再按扫码、JSAPI、
	 * APP等不同场景生成交易串调起支付。
	 * 
	 * <p>
	 * URL地址：https://api.mch.weixin.qq.com/pay/unifiedorder
	 * <p>
	 * 不需要证书
	 * 
	 * @param order
	 *            待支付订单交易信息
	 * @return 订单预支付处理结果
	 * @author Jann Liu
	 */
	public PayResponse preparePay(Order order);

	/**
	 * 生成退款信息并发送请求到微信退款服务器
	 * {@link https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_4}
	 * 
	 * 当交易发生之后一段时间内，由于买家或者卖家的原因需要退款时，卖家可以通过退款接口将支付款退还给买家，微信支付将在收到退款请求并且验证成功之后，
	 * 按照退款规则将支付款按原路退到买家帐号上。
	 * 
	 * 注意：
	 * 
	 * 1、交易时间超过半年的订单无法提交退款；
	 * 
	 * 2、微信支付退款支持单笔交易分多次退款，多次退款需要提交原支付订单的商户订单号和设置不同的退款单号。一笔退款失败后重新提交，要采用原来的退款单号。
	 * 总退款金额不能超过用户实际支付金额。
	 * <p>
	 * 接口链接：https://api.mch.weixin.qq.com/secapi/pay/refund
	 * <p>
	 * 需要双向认证证书
	 * 
	 * @param refund
	 *            退款请求信息
	 * @return 退款结果响应信息
	 * @author Yujinshui
	 */

	public RefundResponse refund(Refund refund);

	/**
	 * 文档连接：
	 * {@link https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_2}
	 * <p>
	 * 接口连接： https://api.mch.weixin.qq.com/pay/orderquery
	 * 
	 * @param params
	 *            订单查询条件参数对象
	 * @return 订单查询结果响应对象
	 * @author Yujinshui
	 * @time 2015年10月26日 下午9:29:00
	 */
	public OrderQueryResponse query(OrderQuery params);

	/**
	 * * 文档连接：
	 * {@link https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_3 }
	 * <p>
	 * 注意：订单生成后不能马上调用关单接口，最短调用时间间隔为5分钟。
	 * <p>
	 * 接口地址: https://api.mch.weixin.qq.com/pay/closeorder
	 * 
	 * @param params
	 *            关闭订单参数对象
	 * @return 关闭订单请求的返回结果
	 * @author Jann Liu
	 */
	public CloseOrderResponse closeOrder(CloseOrder params);

	/**
	 * 退款查询服务接口:
	 * {@link https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_5}
	 * <p>
	 * 接口地址: https://api.mch.weixin.qq.com/pay/refundquery
	 * <p>
	 * 
	 * @param params
	 *            退款查询参数对象
	 * @return 退款查询返回结果
	 * @author Jann Liu
	 */
	public RefundQueryResponse refundQuery(RefundQuery params);

	/**
	 * 下载对账单
	 * {@link https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_6}
	 * <p>
	 * 接口链接 : https://api.mch.weixin.qq.com/pay/downloadbill
	 * 
	 * @param params
	 *            对账单查询参数
	 * @return 下载的对账单响应结果
	 * @author Jann Liu
	 */
	public DownloadBillResponse downloadBill(DownloadBill params);

}
