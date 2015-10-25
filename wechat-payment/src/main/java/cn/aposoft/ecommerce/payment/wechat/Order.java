/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat;

/**
 * 订单信息[完成]<br>
 * 
 * 
 * @author LiuJian
 *
 */
public interface Order {
	/**
	 * 商品ID
	 * 
	 * @return
	 */
	String getProduct_id();

	/**
	 * <font color=red>必需</font>-商品商品或支付单简要描述[demo:Ipad mini 16G 白色]
	 * 
	 * @return
	 */
	String getBody();

	/**
	 * <font color=red>必需</font>-商品价格,只能为整数
	 * 
	 * @return
	 */
	Integer getTotal_fee();

	/**
	 * 商品订单详情
	 * 
	 * @return
	 */
	String getDetail();

	/**
	 * 交易开始时间
	 * 
	 * @return
	 */
	String getTime_start();

	/**
	 * 交易结束时间
	 * 
	 * @return
	 */
	String getTime_expire();

	/**
	 * 附加说明
	 * 
	 * @return
	 */
	String getAttach();

	/**
	 * 商品标记[商品标记，代金券或立减优惠功能的参数，说明详见代金券或立减优惠]
	 * 
	 * @return
	 */
	String getGoods_tag();

	/**
	 * <font color=red>必需</font>-商户订单号
	 * 
	 * @return
	 */
	String getOut_trade_no();

	/**
	 * <font color=red>必需</font>-返回支付类型
	 * 
	 * @return
	 */
	String getTrade_type();

	/**
	 * <font color=red>必需</font>-APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
	 * 
	 * @return
	 */
	String getSpbill_create_ip();

	/**
	 * 设备类型
	 * 
	 * @return
	 */
	String getDevice_info();

	/**
	 * 货币类型
	 * 
	 * @return
	 */
	String getFee_type();

	/**
	 * 接收微信支付异步通知回调地址
	 * 
	 * @return
	 * @author Yujinshui
	 */
	String getNotify_url();

}
