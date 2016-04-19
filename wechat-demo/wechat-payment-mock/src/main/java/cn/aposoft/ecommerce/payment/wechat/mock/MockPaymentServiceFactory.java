/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.mock;

import cn.aposoft.ecommerce.payment.wechat.PaymentService;

/**
 * 测试用支付服务工厂
 * @author LiuJian
 *
 */
public class MockPaymentServiceFactory {
	/**
	 * 1.构建MockPaymentService
	 * 
	 * @author Jann Liu
	 */
	public PaymentService getService() {
		PaymentService service = new PaymentServiceImpl();
		return service;
	}
}
