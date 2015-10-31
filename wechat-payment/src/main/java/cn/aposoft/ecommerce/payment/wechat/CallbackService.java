/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat;

/**
 * 异步接收微信服务器通知服务
 * 
 * 
 * @author LiuJian
 *
 */
public interface CallbackService {
	/**
	 * 异步接收微信服务器通知的服务
	 * <p>
	 * {@link https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_7}
	 * 
	 * @param xml
	 *            原始报文xml格式文件
	 * @return 通知消息对象
	 */
	public Notification recveiveNotification(String xml);
}
