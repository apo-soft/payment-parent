/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.impl;

import cn.aposoft.ecommerce.payment.wechat.CallbackService;
import cn.aposoft.ecommerce.payment.wechat.Notification;
import cn.aposoft.ecommerce.payment.wechat.util.EntityUtil;

/**
 * @author Jann Liu
 *
 */
public class CallbackServiceImpl implements CallbackService {
	EntityUtil entityUtil;

	public CallbackServiceImpl(EntityUtil entityUtil) {
		this.entityUtil = entityUtil;
	}

	/**
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.CallbackService#recveiveNotification(java.lang.String)
	 */
	@Override
	public Notification recveiveNotification(String rawText) {
		Notification notification = null;
		notification = entityUtil.parseNotificationXml(rawText);
		return notification;
	}
}
