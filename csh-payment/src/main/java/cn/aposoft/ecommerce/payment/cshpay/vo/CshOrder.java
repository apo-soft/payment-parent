package cn.aposoft.ecommerce.payment.cshpay.vo;

/**
 * 彩生活支付请求接口bean
 * 
 * @author Yu Jinshui
 * @createTime 2016年4月23日 下午6:08:49
 */
public interface CshOrder {
	/**
	 * 商家编号，自动售货机在彩生活内部编号
	 *
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年4月23日 下午6:30:49
	 */
	String getBid();

	/**
	 * 交易金额，单位元，保留小数点后2位
	 *
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年4月23日 下午6:31:11
	 */
	String getMoney();

	/**
	 * 交易详情（商品名称，数量）
	 *
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年4月23日 下午6:31:33
	 */
	String getContent();

}
