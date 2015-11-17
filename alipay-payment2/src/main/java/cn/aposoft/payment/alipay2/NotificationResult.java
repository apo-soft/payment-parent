package cn.aposoft.payment.alipay2;

/**
 * 新版-通知结果: 该对象表示的是回调报文解析方法对报文解析的处理结果.
 * <p>
 * 当商户收到服务器异步通知并打印出success时，服务器异步通知参数notify_id才会失效。也就是说在支付宝发送同一条异步通知时（
 * 包含商户并未成功打印出success导致支付宝重发数次通知），服务器异步通知参数notify_id是不变的。
 * 
 * @author Yujinshui
 *
 */
public class NotificationResult {

	/**
	 * 接收结果返回值
	 */
	private String return_msg;

	/**
	 * 接收结果返回值
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月15日 上午11:27:45
	 */
	public String getReturn_msg() {
		return return_msg;
	}

	/**
	 * 接收结果返回值
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月15日 上午11:27:45
	 */
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	/**
	 * 接收成功
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月15日 上午11:26:37
	 */
	public NotificationResult successResult() {
		NotificationResult result = new NotificationResult();
		result.return_msg = "success";
		return result;

	}

	/**
	 * 接收失败
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月15日 上午11:27:07
	 */
	public NotificationResult failResult() {
		NotificationResult result = new NotificationResult();
		result.return_msg = "fail";
		return result;
	}

}
