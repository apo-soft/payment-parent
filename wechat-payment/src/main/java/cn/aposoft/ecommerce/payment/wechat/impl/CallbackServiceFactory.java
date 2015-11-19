/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.impl;

import cn.aposoft.ecommerce.payment.wechat.CallbackService;

/**
 * 支付成功后的回调接口启用
 * 
 * @author Jann Liu
 *
 */
public class CallbackServiceFactory {

	/**
	 * CallbackService.recveiveNotification
	 * 
	 * @return
	 * @author Yujinshui
	 */
	public CallbackService getService() {
		CallbackService service = new CallbackServiceImpl(SimpleEntityUtil.getInstance());
		return service;
	}

}
