/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat;

import cn.aposoft.ecommerce.payment.wechat.util.EntityUtil;
import cn.aposoft.ecommerce.payment.wechat.util.SimpleEntityUtil;

/**
 * 通知结果: 该对象表示的是回调报文解析方法对报文解析的处理结果.
 * <p>
 * 商户处理后同步返回给微信参数：
 * 
 * <pre>
   <xml>
	<return_code><![CDATA[SUCCESS]]></return_code>
	<return_msg><![CDATA[OK]]></return_msg>
   </xml>
 * </pre>
 * 
 * 
 * @author Jann Liu
 *
 */
public class NotificationResult {
	private static EntityUtil entityUtil = SimpleEntityUtil.getInstance();

	/**
	 * 返回状态码 return_code 是 String(16) SUCCESS
	 * 
	 * SUCCESS/FAIL
	 * 
	 * SUCCESS表示商户接收通知成功并校验成功
	 */
	private String return_code;
	/**
	 * 返回信息 return_msg 否 String(128) OK
	 * 
	 * 返回信息，如非空，为错误原因：
	 * 
	 * 签名失败
	 * 
	 * 参数格式校验错误
	 */
	private String return_msg;

	/**
	 * 读取返回码
	 * 
	 * @return 返回码
	 */
	public String getReturn_code() {
		return return_code;
	}

	/**
	 * 设置返回码
	 * 
	 * @param return_code
	 *            返回码
	 */
	public void setReturn_code(String return_code) {
		changed = true;
		this.return_code = return_code;
	}

	/**
	 * 读取返回消息
	 * 
	 * @return 返回消息
	 */
	public String getReturn_msg() {
		return return_msg;
	}

	/**
	 * 设置返回消息
	 * 
	 * @param return_msg
	 *            返回消息
	 */
	public void setReturn_msg(String return_msg) {
		changed = true;
		this.return_msg = return_msg;
	}

	// 数据发生变更
	private boolean changed = true;
	// xml格式数据报文
	private String xml;

	/*
	 * 创建xml缓存
	 */
	private void createXml() {
		//xml = ""; // TODO 实现方法
		xml = entityUtil.createNotificationResultXml(this);
		changed = false;
	}

	/**
	 * 用于返回给微信服务器的报文
	 * 
	 * @return 报文内容
	 */
	public String toXml() {
		if (changed) {
			createXml();
		}
		return xml;
	}

}
