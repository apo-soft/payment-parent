/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat;

/**
 * 订单支付查询参数
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
public class OrderQueryVo implements OrderQuery {

	@Override
	public String getTransaction_id() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOut_trade_no() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
