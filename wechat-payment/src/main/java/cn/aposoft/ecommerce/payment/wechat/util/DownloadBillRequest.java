/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.util;

/**
 * 下载对账单请求信息
 * 
 * <pre>
  <xml>
	  <appid>wx2421b1c4370ec43b</appid>
	  <bill_date>20141110</bill_date>
	  <bill_type>ALL</bill_type>
	  <mch_id>10000100</mch_id>
	  <nonce_str>21df7dc9cd8616b56919f20d9f679233</nonce_str>
	  <sign>332F17B766FC787203EBE9D6E40457A1</sign>
  </xml>
 * </pre>
 * 
 * @author Jann Liu
 *
 */
public class DownloadBillRequest {
	/**
	 * 公众账号ID appid 是 String(32) wx8888888888888888 微信分配的公众账号ID
	 */
	private String appid;

	/**
	 * 商户号 mch_id 是 String(32) 1900000109 微信支付分配的商户号
	 */
	private String mch_id;

	/**
	 * 设备号 device_info 否 String(32) 013467007045764
	 * 微信支付分配的终端设备号，填写此字段，只下载该设备号的对账单
	 */
	private String device_info;

	/**
	 * 随机字符串 nonce_str 是 String(32) 5K8264ILTKCH16CQ2502SI8ZNMTM67VS
	 * 随机字符串，不长于32位。推荐随机数生成算法
	 */
	private String nonce_str;

	/**
	 * 签名 sign 是 String(32) C380BEC2BFD727A4B6845133519F3AD6 签名，详见签名生成算法
	 */
	private String sign;

	/**
	 * 对账单日期 bill_date 是 String(8) 20140603 下载对账单的日期，格式：20140603
	 */
	private String bill_date;
	/**
	 * 账单类型 bill_type 否 String(8) ALL
	 * 
	 * ALL，返回当日所有订单信息，默认值
	 * 
	 * SUCCESS，返回当日成功支付的订单
	 * 
	 * REFUND，返回当日退款订单
	 * 
	 * REVOKED，已撤销的订单
	 */
	private String bill_type;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getBill_date() {
		return bill_date;
	}

	public void setBill_date(String bill_date) {
		this.bill_date = bill_date;
	}

	public String getBill_type() {
		return bill_type;
	}

	public void setBill_type(String bill_type) {
		this.bill_type = bill_type;
	}
}
