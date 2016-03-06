/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.service;

import cn.aposoft.ecommerce.payment.wechat.OrderBusinessException;
import cn.aposoft.ecommerce.payment.wechat.bean.OrderBill;
import cn.aposoft.ecommerce.payment.wechat.bean.OrderPayment;

/**
 * 订单服务:实现订单从生成,到支付完成跳转需要的全部方法
 * 
 * 1. 接收生成订单请求 createOrder <br/>
 * 2. 生成预付款单 createPayment <br/>
 * 3. 客户端轮询订单支付结果 getPayState <br/>
 * 4. 生成自增订单号 nextSeq <br/>
 * 
 * @author Jann Liu
 *
 */
public interface OrderService {
	/**
	 * 根据用户输入生成订单信息
	 * 
	 * @param inputOrder
	 *            客户输入的信息
	 * @return 补齐的完整的订单
	 * @throws 生成订单异常时,抛出订单业务异常
	 */
	OrderBill createOrder(OrderBill inputBill) throws OrderBusinessException;

	/**
	 * 生成预付款单,并调用微信支付完成预付款单的提交,获取支付二维码地址
	 * 
	 * @param inputBill
	 *            待生成预付款单的订单
	 * @return 生成的预付款单
	 * @throws 生成预支付单或向微信服务器提交预支付单时出错,抛出此异常
	 * 
	 */
	OrderPayment createPayment(OrderBill inputBill) throws OrderBusinessException;

	/**
	 * 根据订单编号和付款id查询付款状态
	 * 
	 * @param orderNo
	 *            订单编号
	 * @param paymentId
	 *            付款单id
	 * @return 付款信息
	 * @throws 当查询付款信息出错时,抛出此异常
	 */
	OrderPayment getPayState(String orderNo, String paymentId) throws OrderBusinessException;

}
