/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat;

import java.io.Serializable;

/**
 * API说明文档链接地址：
 * {@link https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_2}
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
 * @author Jann Liu
 *
 */
public interface OrderQuery extends Serializable {
	public String getTransaction_id();

	public String getOut_trade_no();
}
