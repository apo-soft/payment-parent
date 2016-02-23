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

	private String transaction_id;
	private String out_trade_no;

	/**
	 * 微信订单号
	 */
	@Override
	public String getTransaction_id() {
		return transaction_id;
	}

	/**
	 * 商户订单号
	 */
	@Override
	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public static OrderQuery demo1() {
		OrderQueryVo query = new OrderQueryVo();
		// query.setOut_trade_no("");
		// query.setTransaction_id("1005680240201510261343957061");
		query.setOut_trade_no("69396140B8F311E5A140936DEAF2531");
		return query;
	}

	public static OrderQuery demo2() {
		OrderQueryVo query = new OrderQueryVo();
		// query.setOut_trade_no("");
		query.setTransaction_id("1005680240201510261343957061");
		// query.setOut_trade_no("69396140B8F311E5A140936DEAF2531");
		return query;
	}
}
