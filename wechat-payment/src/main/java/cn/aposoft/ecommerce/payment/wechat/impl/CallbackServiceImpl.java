/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.impl;

import cn.aposoft.ecommerce.payment.wechat.CallbackService;
import cn.aposoft.ecommerce.payment.wechat.EntityUtil;
import cn.aposoft.ecommerce.payment.wechat.Notification;

/**
 * 支付结果返回处理服务
 * 
 * 
 * @author Jann Liu
 *
 */
public class CallbackServiceImpl implements CallbackService {
	EntityUtil entityUtil;

	public CallbackServiceImpl(EntityUtil entityUtil) {
		this.entityUtil = entityUtil;
	}

	/**
	 * 解析微信支付的支付接口回调消息报文
	 * <p>
	 * {@link https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_7}
	 * 
	 * @param xml
	 *            原始报文xml格式文件
	 * @return 通知消息对象
	 * @see cn.aposoft.ecommerce.payment.wechat.CallbackService#recveiveNotification(java.lang.String)
	 */
	@Override
	public Notification recveiveNotification(String xml) {
		Notification notification = null;
		notification = entityUtil.parseNotificationXml(xml);
		return notification;
	}
}
