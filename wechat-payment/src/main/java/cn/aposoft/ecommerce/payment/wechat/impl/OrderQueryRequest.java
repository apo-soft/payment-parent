/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.impl;

/**
 * 查询订单请求报文对象
 * 
 * <pre>
  	<xml>
	   <appid>wx2421b1c4370ec43b</appid>
	   <mch_id>10000100</mch_id>
	   <nonce_str>ec2316275641faa3aacf3cc599e8730f</nonce_str>
	   <transaction_id>1008450740201411110005820873</transaction_id>
	   <sign>FDD167FAA73459FD921B144BAF4F4CA2</sign>
	</xml>
 * </pre>
 * 
 * @author Yujinshui
 *
 */
public class OrderQueryRequest extends RequestBase {

	/**
	 * 微信订单号 [是] String(28)
	 */
	private String transaction_id;

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

}
