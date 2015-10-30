/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat;

/**
 * 异步接收微信服务器通知
 * 
 * @author LiuJian
 *
 */
public interface CallbackService {
	/**
	 * 异步接收微信服务器通知的服务
	 * <p>
	 * 
	 * @param xml
	 *            微信服务器返回的xml原始字符串表示
	 */
	public Notification recveiveNotification(String xml);
}
