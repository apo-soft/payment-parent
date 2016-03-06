/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.service;

/**
 * 微信服务器完成时的回调使用
 * 
 * @author Jann Liu
 *
 */
public interface WechatCallbackService {

	/**
	 * 接收微信回调返回的xml报文,返回向微信服务发送的响应结果 处理支付请求
	 * 
	 * @param xml
	 *            微信服务器传回的Notification报文
	 * @return 回传给微信服务器的的结果
	 */
	String callback(String xml);

}
