package cn.aposoft.ecommerce.payment.alipay;

import java.math.BigDecimal;

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

	/**
	 * 签名 *
	 * <p>
	 */
	public String getSign();

	/**
	 * 服务器异步通知页面路径
	 * <p>
	 * 支付宝服务器主动通知商户网站里指定的页面http路径。
	 */

	public String getNotify_url();

	/**
	 * 页面跳转同步通知页面路径
	 * <p>
	 * 支付宝处理完请求后，当前页面自动跳转到商户网站里指定页面的http路径。
	 */

	public String getReturn_url();

	/**
	 * 请求出错时的通知页面路径
	 * <p>
	 * 当商户通过该接口发起请求时，如果出现提示报错，支付宝会根据请求出错时的通知错误码通过异步的方式发送通知给商户。<br>
	 * 该功能需要联系支付宝开通。
	 */

	public String getError_notify_url();

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
	 * 默认值为：1-商品购买 <br>
	 * 1-商品购买;4-捐赠;47-电子卡券<br>
	 * 注意：支付类型为“47”时，公共业务扩展参数（extend_param）中必须包含凭证号（
	 * evoucheprod_evouche_id）参数名和参数值。
	 */

	public String getPayment_type();

	/**
	 * 交易金额 *
	 * <p>
	 * 该笔订单的资金总额，单位为RMB-Yuan。取值范围为[0.01，100000000.00]，精确到小数点后两位。
	 */
	public BigDecimal getTotal_fee();

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

	/**
	 * 买家支付宝用户号
	 * <p>
	 * 买家支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字。
	 */

	public String getBuyer_id();

	/**
	 * 买家支付宝账号
	 * <p>
	 * 买家支付宝账号，格式为邮箱或手机号。
	 */

	public String getBuyer_email();

	/**
	 * 买家别名支付宝账号
	 * <p>
	 * 买家别名支付宝账号。<br>
	 * 买家信息优先级：buyer_id>buyer_account_name>buyer_email。
	 */

	public String getBuyer_account_name();

	/**
	 * 商品单价
	 * <p>
	 * 单位为：RMB Yuan。取值范围为[0.01，100000000.00]，精确到小数点后两位。此参数为单价<br>
	 * 规则：price、quantity能代替total_fee。即存在total_fee，就不能存在price和quantity；存在price、
	 * quantity，就不能存在total_fee。
	 */
	public BigDecimal getPrice();

	/**
	 * 购买数量
	 * <p>
	 * price、quantity能代替total_fee。即存在total_fee，就不能存在price和quantity；存在price、
	 * quantity，就不能存在total_fee。
	 */
	public BigDecimal getQuantity();

	/**
	 * 商品描述
	 * <p>
	 * 对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
	 */

	public String getBody();

	/**
	 * 商品展示网址
	 * <p>
	 * 收银台页面上，商品展示的超链接。
	 */

	public String getShow_url();

	/**
	 * 默认支付方式
	 * <p>
	 * 取值范围： <br>
	 * creditPay（信用支付）<br>
	 * directPay（余额支付）<br>
	 * 
	 * 如果不设置，默认识别为余额支付。<br>
	 * 
	 * 说明：<br>
	 * 
	 * 必须注意区分大小写。<br>
	 */

	public String getPaymethod();

	/**
	 * 支付渠道
	 * <p>
	 * 用于控制收银台支付渠道显示，该值的取值范围请参见支付渠道。
	 * 
	 * 可支持多种支付渠道显示，以“^”分隔
	 */

	public String getEnable_paymethod();

	/**
	 * 网银支付时是否做CTU校验
	 * <p>
	 * 商户在配置了支持CTU（支付宝风险稽查系统）校验权限的前提下，可以选择本次交易是否需要经过CTU校验。
	 * 
	 * <br>
	 * Y：做CTU校验；<br>
	 * N：不做CTU校验。<br>
	 */

	public String getNeed_ctu_check();

	/**
	 * 防钓鱼时间戳
	 * <p>
	 * 通过时间戳查询接口获取的加密支付宝系统时间戳。 <br>
	 * 如果已申请开通防钓鱼时间戳验证，则此字段必填。
	 */

	public String getAnti_phishing_key();

	/**
	 * 客户端IP
	 * <p>
	 * 用户在创建交易时，该用户当前所使用机器的IP。
	 * 
	 * <br>
	 * 如果商户申请后台开通防钓鱼IP地址检查选项，此字段必填，校验用。
	 */

	public String getExter_invoke_ip();

	/**
	 * 公用回传参数
	 * <p>
	 * 如果用户请求时传递了该参数，则返回给商户时会回传该参数。
	 */

	public String getExtra_common_param();

	/**
	 * 公用业务扩展参数
	 * <p>
	 * 用于商户的特定业务信息的传递，只有商户与支付宝约定了传递此参数且约定了参数含义，此参数才有效。 <br>
	 * 参数格式：参数名1^参数值1|参数名2^参数值2|……<br>
	 * 
	 * 多条数据用“|”间隔。<br>
	 * 
	 * 支付类型（payment_type）为47（电子卡券）时，需要包含凭证号（evoucheprod_evouche_id）参数名和参数值。
	 */

	public String getExtend_param();

	/**
	 * 超时时间
	 * <p>
	 * 设置未付款交易的超时时间，一旦超时，该笔交易就会自动被关闭。
	 * 
	 * 取值范围：1m～15d。<br>
	 * 
	 * m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。<br>
	 * 
	 * 该参数数值不接受小数点，如1.5h，可转换为90m。
	 */

	public String getIt_b_pay();

	/**
	 * 自动登录标识
	 * <p>
	 * 用于标识商户是否使用自动登录的流程。如果和参数buyer_email一起使用时，就不会再让用户登录支付宝，即在收银台中不会出现登录页面。
	 * 
	 * 取值有以下情况：<br>
	 * 
	 * Y代表使用<br>
	 * N代表不使用<br>
	 * 
	 * 该功能需要联系支付宝配置。
	 */

	public String getDefault_login();

	/**
	 * 商户申请的产品类型
	 * <p>
	 * 用于针对不同的产品，采取不同的计费策略。
	 * 
	 * 如果开通了航旅垂直搜索平台产品，请填写CHANNEL_FAST_PAY；如果没有，则为空。
	 */

	public String getProduct_type();

	/**
	 * 快捷登录授权令牌
	 * <p>
	 * 如果开通了快捷登录产品，则需要填写；如果没有开通，则为空。
	 */

	public String getToken();

	/**
	 * 商户买家签约号
	 * <p>
	 * 用于唯一标识商户买家。
	 * 
	 * 如果本参数不为空，则sign_name_ext不能为空。
	 */

	public String getSign_id_ext();

	/**
	 * 商户买家签约名
	 * <p>
	 * 商户买家唯一标识对应的名字。
	 */

	public String getSign_name_ext();

	/**
	 * 扫码支付方式
	 * <p>
	 * 扫码支付的方式，支持前置模式和跳转模式。
	 * 
	 * 前置模式是将二维码前置到商户的订单确认页的模式。需要商户在自己的页面中以iframe方式请求支付宝页面。具体分为以下3种：<br>
	 * 
	 * 0：订单码-简约前置模式，对应iframe宽度不能小于600px，高度不能小于300px；<br>
	 * 1：订单码-前置模式，对应iframe宽度不能小于300px，高度不能小于600px；<br>
	 * 3：订单码-迷你前置模式，对应iframe宽度不能小于75px，高度不能小于75px。<br>
	 * 
	 * 跳转模式下，用户的扫码界面是由支付宝生成的，不在商户的域名下。<br>
	 * 
	 * 2：订单码-跳转模式
	 */

	public String getQr_pay_mode();
}
