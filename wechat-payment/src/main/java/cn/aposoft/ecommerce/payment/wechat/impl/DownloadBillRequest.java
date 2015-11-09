/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.impl;

/**
 * 下载对账单请求信息请求传输对象
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
public class DownloadBillRequest extends RequestBase {
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
