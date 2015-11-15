package cn.aposoft.ecommerce.payment.alipay;

/**
 * 公共请求参数
 * 
 * @author Yujinshui
 *
 */
public class PublicParamsRequest {
	/**
	 * 开发者的AppId*
	 * <p>
	 * 支付宝分配给开发者的应用Id <br>
	 * 2014072300007140
	 */
	private String app_id;
	/**
	 * 接口名称*
	 * <p>
	 * 接口名称 <br>
	 * alipay.trade.pay
	 */
	private String method;
	/**
	 * 参数字符编码*
	 * <p>
	 * 请求使用的编码格式，如utf-8,gbk,gb2312等 <br>
	 * utf-8
	 */
	private String charset;
	/**
	 * 签名类型*
	 * <p>
	 * 商户生成签名字符串所使用的签名算法类型，目前支持RSA<br>
	 * RSA
	 */
	private String sign_type;
	/**
	 * 签名*
	 * <p>
	 * 商户请求参数的签名串，详见签名 <br>
	 * 详见示例
	 */
	private String sign;
	/**
	 * 时间戳*
	 * <p>
	 * 发送请求的时间，格式“yyyy-MM-dd HH:mm:ss” <br>
	 * 2014/7/24 3:07
	 */
	private String timestamp;
	/**
	 * 接口版本号*
	 * <p>
	 * 调用的接口版本，固定为：1.0 <br>
	 * 1
	 */
	private String version;
	/**
	 * 接口异步通知url
	 * <p>
	 * 支付宝服务器主动通知商户服务器里指定的页面http路径。<br>
	 * http://api.test.alipay.net/atinterface/receive_notify.htm
	 */
	private String notify_url;
	/**
	 * 业务参数*
	 * <p>
	 * JSON格式，具体包含的内容参见各个接口的业务参数描述 <br>
	 * 详见各业务接口
	 */
	private Object biz_content;

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public Object getBiz_content() {
		return biz_content;
	}

	public void setBiz_content(Object biz_content) {
		this.biz_content = biz_content;
	}
}
