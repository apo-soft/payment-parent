package cn.aposoft.ecommerce.payment.alipay;

/**
 * 待支付订单接口
 * <p>
 * 实现必填参数内容即可
 * 
 * @author Yujinshui
 *
 */
public interface Order {
	/**
	 * 接口名称 *
	 * <p>
	 * 接口名称。
	 */
	public String getService();

	/**
	 * 合作者身份ID *
	 * <p>
	 * 签约的支付宝账号对应的支付宝唯一用户号。以2088开头的16位纯数字组成。
	 */
	public String getPartner();

	/**
	 * 参数编码字符集 *
	 * <p>
	 * 商户网站使用的编码格式，如utf-8、gbk、gb2312等。
	 */
	public String get_input_charset();

	/**
	 * 签名方式 *
	 * <p>
	 * DSA、RSA、MD5三个值可选，必须大写。
	 */
	public String getSign_type();

	/***** 以下为业务参数 *****/
	/**
	 * 商户网站唯一订单号 *
	 * <p>
	 * 支付宝合作商户网站唯一订单号。
	 */
	public String getOut_trade_no();

	/**
	 * 商品名称 *
	 * <p>
	 * 商品的标题/交易标题/订单标题/订单关键字等。<br>
	 * 该参数最长为128个汉字。
	 */
	public String getSubject();

	/**
	 * 支付类型 *
	 * <p>
	 * 默认值为：1（商品购买）。<br>
	 * 注意：支付类型为“47”时，公共业务扩展参数（extend_param）中必须包含凭证号（
	 * evoucheprod_evouche_id）参数名和参数值。
	 */
	public String getPayment_type();

	/**
	 * 交易金额 *
	 * <p>
	 * 该笔订单的资金总额，单位为RMB-Yuan。取值范围为[0.01，100000000.00]，精确到小数点后两位。
	 */
	public double getTotal_fee();

	// ==============以下内容三选一==================
	/**
	 * 卖家支付宝用户号 *
	 * <p>
	 * seller_id是以2088开头的纯16位数字。<br>
	 * seller_email是支付宝登录账号，格式一般是邮箱或手机号。<br>
	 * seller_account_name是卖家别名支付宝账号。三个参数至少必须传递一个。<br>
	 * 当签约账号就是收款账号时，请务必使用参数seller_id，即seller_id的值与partner的值相同。<br>
	 * 三个参数的优先级别是：seller_id>seller_account_name>seller_email。
	 */
	public String getSeller_id();

	/**
	 * 卖家支付宝账号 *
	 * <p>
	 * seller_id是以2088开头的纯16位数字。<br>
	 * seller_email是支付宝登录账号，格式一般是邮箱或手机号。<br>
	 * seller_account_name是卖家别名支付宝账号。三个参数至少必须传递一个。<br>
	 * 当签约账号就是收款账号时，请务必使用参数seller_id，即seller_id的值与partner的值相同。<br>
	 * 三个参数的优先级别是：seller_id>seller_account_name>seller_email。
	 */
	public String getSeller_email();

	/**
	 * 卖家别名支付宝账号 *
	 * <p>
	 * seller_id是以2088开头的纯16位数字。<br>
	 * seller_email是支付宝登录账号，格式一般是邮箱或手机号。<br>
	 * seller_account_name是卖家别名支付宝账号。三个参数至少必须传递一个。<br>
	 * 当签约账号就是收款账号时，请务必使用参数seller_id，即seller_id的值与partner的值相同。<br>
	 * 三个参数的优先级别是：seller_id>seller_account_name>seller_email。
	 */
	public String getSeller_account_name();

}
