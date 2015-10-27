/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat;

/**
 * 主动向微信支付服务器发送各种订单业务相关请求
 * 
 * <p>
 * ATTENTION: 有关商户的基本配置信息,应当在支付服务的具体实现中进行加载
 * <ul>
 * <li>{@code preparePay} 定义微信支付的统一下单接口封装</li>
 * <li>{@code refund} 定义微信支付的申请退款接口</li>
 * <li>{@code query} 定义微信支付的订单查询接口</li>
 * <li>{@code closeOrder} 定义微信支付的关闭订单接口</li>
 * </ul>
 * 
 * @author Jann Liu
 * 
 */
public interface PaymentService {

	/**
	 * 生成账单信息并发送请求到微信支付服务器
	 * 
	 * @param order
	 *            支付订单信息
	 * @return 微信服务响应信息
	 */
	public PayResponse preparePay(Order order);

	/**
	 * 生成退款信息并发送请求到微信退款服务器
	 * 
	 * @param refund
	 * @return 退款
	 * @author Yujinshui
	 */
	public RefundResponse refund(Refund refund);

	/**
	 * 文档连接：
	 * {@link https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_2}
	 * <p>
	 * 接口连接： https://api.mch.weixin.qq.com/pay/orderquery
	 * 
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
	 * @return 关闭订单请求的返回结果
	 */
	public CloseOrderResponse closeOrder(CloseOrder params);

}
