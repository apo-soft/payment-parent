/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat;

/**
 * 主动向微信服务器发送各种业务请求的服务
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
}
