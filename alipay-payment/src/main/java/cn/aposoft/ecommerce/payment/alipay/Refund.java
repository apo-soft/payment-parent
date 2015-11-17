package cn.aposoft.ecommerce.payment.alipay;

import java.math.BigDecimal;

/**
 * 退款接口，仅提供必需参数返回值
 * 
 * @author Yujinshui
 *
 */
public interface Refund {

	/********* 基本参数 *************/
	/**
	 * 接口名称*
	 * <p>
	 * 接口名称。真实param<br>
	 * param_demo:refund_fastpay_by_platform_pwd
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月16日 上午10:57:23
	 */
	public String getService();

	/**
	 * 合作者身份ID*
	 * <p>
	 * 签约的支付宝账号对应的 支付宝唯一用户号。 以 2088 开头的 16 位纯数 字组成。 <br>
	 * param_demo:2088101008267254
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月16日 上午10:57:39
	 */
	public String getPartner();

	/**
	 * 参数编码字符集*
	 * <p>
	 * 商户网站使用的编码格式， 如 utf-8、 gbk、 gb2312 等。<br>
	 * param_demo:GBK
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月16日 上午10:57:39
	 */
	public String get_input_charset();

	/**
	 * 签名方式*
	 * <p>
	 * DSA、 RSA、 MD5 三个值 可选，必须大写。<br>
	 * param_demo:MD5
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月16日 上午10:57:39
	 */
	public String getSign_type();

	public String getAlipay_ca_request();

	/**
	 * 商户网站唯一订单号*
	 * <p>
	 * 支付宝合作商户网站唯一订单号。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午4:47:08
	 */
	public String getOut_trade_no();

	/**
	 * 退款金额*
	 * <p>
	 * 退款金额不能大于订单金 额，全额退款必须与订单金额一致。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午4:47:30
	 */
	public BigDecimal getRefund_amount();

	public String getTrade_no();

	public String getOut_request_no();

	public String getOperator_type();

	public String getOperator_id();

	public String getRefund_reason();

	public String getRef_ids();

	public String getExtend_params();

}
