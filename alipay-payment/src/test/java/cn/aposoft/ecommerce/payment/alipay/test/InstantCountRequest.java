package cn.aposoft.ecommerce.payment.alipay.test;

import java.math.BigDecimal;

import cn.aposoft.ecommerce.payment.alipay.Order;

/**
 * 即时到账部分bean封装
 * 
 * <pre>
 * https://mapi.alipay.com/gateway.do?body=%C3%C0%B9%FA%D7%A8%D2%B5%BB%A4%CD%F3%CA%F3%B1%EA%B5%E6%2C%CA%E6%BB%BA%CA%BD%C4%FD%BD%BA%C8%ED%B5%E6%C4%A3%C4%E2%CA%D6%CD%F3%B5%C4%D7%D4%C8%BB%C7%FA%CF%DF%BA%CD%D4%CB%B6%AF%A3%AC%B4%B4%D4%EC%BA%CD%BB%BA%B5%C4GelFlex%CA%E6%CA%CA%B5%D8%B4%F8%21&extend_param=%70%6E%72%5E%4D%46%47%58%44%57%7C%73%74%61%72%74%5F%74%69%63%6B%65%74%5F%6E%6F%5E%31%32%33%7C%65%6E%64%5F%74%69%63%6B%65%74%5F%6E%6F%5E%32%33%34%7C%62%32%62%5F%6C%6F%67%69%6E%5F%6E%61%6D%65%5E%61%62%63&subject=%B1%B4%B6%FB%BD%F0%BB%A4%CD%F3%CA%BD&sign_type=MD5&notify_url=http%3A%2F%2Fapi.test.alipay.net&out_trade_no=6741334835157966&return_url=http%3A%2F%2Fapi.test.alipay.net%2Fatinterface%2Freceive_return.htm&sign=dc3d42f405d7e738ab35344449e2d9f7&buyer_id=2088002007018955&total_fee=100&error_notify_url=http%3A%2F%2Fapi.test.alipay.net%2Fatinterface%2Freceive_error_notify.htm&service=create_direct_pay_by_user&partner=2088101568338364&seller_id=2088002007018966&payment_type=1&qr_pay_mode=1

说明：
本样例仅供参考，支付宝网关为https://mapi.alipay.com/gateway.do。

 

注意：

    此接口只支持https请求；
    参数body（商品描述）、subject（商品名称）、extra_common_param（公用回传参数）不能包含特殊字符（如：#、%、&、+）、敏感词汇，也不能使用外国文字（旺旺不支持的外文，如：韩文、泰语、藏文、蒙古文、阿拉伯语）；
    请按照签名中的签名方法对输入参数进行签名，该接口请求才能够被支付宝系统接收；
    此接口支持重复调用，前提是交易基本信息（买家、卖家、交易金额、超时时间等）在多次调用中保持一致，且交易尚未完成支付；
    配置qr_pay_mode为0或1或3（扫码支付方式为订单码-简约前置模式或订单码-前置模式或订单码-迷你前置模式）的情况下，同步通知地址return_url需要传入商户中间跳转页面，即该页面需要实现让父页面自行跳转的功能，中间页面javascript代码：<script>window.parent.location.href='父页面调整的URL';</script>
 * </pre>
 * 
 * @author Yujinshui
 *
 */
public class InstantCountRequest implements Order {
	/***** 基本参数 ***/
	/**
	 * 接口名称 *
	 * <p>
	 * 接口名称。
	 */
	private String service;
	/**
	 * 合作者身份ID *
	 * <p>
	 * 签约的支付宝账号对应的支付宝唯一用户号。以2088开头的16位纯数字组成。
	 */
	private String partner;
	/**
	 * 参数编码字符集 *
	 * <p>
	 * 商户网站使用的编码格式，如utf-8、gbk、gb2312等。
	 */
	private String _input_charset;
	/**
	 * 签名方式 *
	 * <p>
	 * DSA、RSA、MD5三个值可选，必须大写。
	 */
	private String sign_type;
	/**
	 * 签名 *
	 * <p>
	 */
	private String sign;
	/**
	 * 服务器异步通知页面路径
	 * <p>
	 * 支付宝服务器主动通知商户网站里指定的页面http路径。
	 */
	private String notify_url;
	/**
	 * 页面跳转同步通知页面路径
	 * <p>
	 * 支付宝处理完请求后，当前页面自动跳转到商户网站里指定页面的http路径。
	 */
	private String return_url;
	/**
	 * 请求出错时的通知页面路径
	 * <p>
	 * 当商户通过该接口发起请求时，如果出现提示报错，支付宝会根据请求出错时的通知错误码通过异步的方式发送通知给商户。<br>
	 * 该功能需要联系支付宝开通。
	 */
	private String error_notify_url;

	/***** 以下为业务参数 *****/
	/**
	 * 商户网站唯一订单号 *
	 * <p>
	 * 支付宝合作商户网站唯一订单号。
	 */
	private String out_trade_no;
	/**
	 * 商品名称 *
	 * <p>
	 * 商品的标题/交易标题/订单标题/订单关键字等。<br>
	 * 该参数最长为128个汉字。
	 */
	private String subject;
	/**
	 * 支付类型 *
	 * <p>
	 * 默认值为：1（商品购买）。<br>
	 * 1-商品购买;4-捐赠;47-电子卡券<br>
	 * 注意：支付类型为“47”时，公共业务扩展参数（extend_param）中必须包含凭证号（
	 * evoucheprod_evouche_id）参数名和参数值。
	 */
	private String payment_type;
	/**
	 * 交易金额 *
	 * <p>
	 * 该笔订单的资金总额，单位为RMB-Yuan。取值范围为[0.01，100000000.00]，精确到小数点后两位。
	 */
	private BigDecimal total_fee;
	/**
	 * 卖家支付宝用户号 *
	 * <p>
	 * seller_id是以2088开头的纯16位数字。<br>
	 * seller_email是支付宝登录账号，格式一般是邮箱或手机号。<br>
	 * seller_account_name是卖家别名支付宝账号。三个参数至少必须传递一个。<br>
	 * 当签约账号就是收款账号时，请务必使用参数seller_id，即seller_id的值与partner的值相同。
	 */
	private String seller_id;
	/**
	 * 卖家支付宝账号 *
	 * <p>
	 */
	private String seller_email;
	/**
	 * 卖家别名支付宝账号 *
	 * <p>
	 * 三个参数的优先级别是：seller_id>seller_account_name>seller_email。
	 */
	private String seller_account_name;
	/**
	 * 买家支付宝用户号
	 * <p>
	 * 买家支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字。
	 */
	private String buyer_id;
	/**
	 * 买家支付宝账号
	 * <p>
	 * 买家支付宝账号，格式为邮箱或手机号。
	 */
	private String buyer_email;
	/**
	 * 买家别名支付宝账号
	 * <p>
	 * 买家别名支付宝账号。<br>
	 * 买家信息优先级：buyer_id>buyer_account_name>buyer_email。
	 */
	private String buyer_account_name;
	/**
	 * 商品单价
	 * <p>
	 * 单位为：RMB Yuan。取值范围为[0.01，100000000.00]，精确到小数点后两位。此参数为单价<br>
	 * 规则：price、quantity能代替total_fee。即存在total_fee，就不能存在price和quantity；存在price、
	 * quantity，就不能存在total_fee。
	 */
	private BigDecimal price;
	/**
	 * 购买数量
	 * <p>
	 * price、quantity能代替total_fee。即存在total_fee，就不能存在price和quantity；存在price、
	 * quantity，就不能存在total_fee。
	 */
	private BigDecimal quantity;
	/**
	 * 商品描述
	 * <p>
	 * 对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
	 */
	private String body;
	/**
	 * 商品展示网址
	 * <p>
	 * 收银台页面上，商品展示的超链接。
	 */
	private String show_url;
	/**
	 * 默认支付方式
	 * <p>
	 * 取值范围：
	 * 
	 * <br>
	 * creditPay（信用支付）<br>
	 * directPay（余额支付）<br>
	 * 
	 * 如果不设置，默认识别为余额支付。<br>
	 * 
	 * 说明：<br>
	 * 
	 * 必须注意区分大小写。<br>
	 */
	private String paymethod;
	/**
	 * 支付渠道
	 * <p>
	 * 用于控制收银台支付渠道显示，该值的取值范围请参见支付渠道。
	 * 
	 * 可支持多种支付渠道显示，以“^”分隔
	 */
	private String enable_paymethod;
	/**
	 * 网银支付时是否做CTU校验
	 * <p>
	 * 商户在配置了支持CTU（支付宝风险稽查系统）校验权限的前提下，可以选择本次交易是否需要经过CTU校验。
	 * 
	 * <br>
	 * Y：做CTU校验；<br>
	 * N：不做CTU校验。<br>
	 */
	private String need_ctu_check;
	/**
	 * 防钓鱼时间戳
	 * <p>
	 * 通过时间戳查询接口获取的加密支付宝系统时间戳。
	 * 
	 * <br>
	 * 如果已申请开通防钓鱼时间戳验证，则此字段必填。
	 */
	private String anti_phishing_key;
	/**
	 * 客户端IP
	 * <p>
	 * 用户在创建交易时，该用户当前所使用机器的IP。
	 * 
	 * <br>
	 * 如果商户申请后台开通防钓鱼IP地址检查选项，此字段必填，校验用。
	 */
	private String exter_invoke_ip;
	/**
	 * 公用回传参数
	 * <p>
	 * 如果用户请求时传递了该参数，则返回给商户时会回传该参数。
	 */
	private String extra_common_param;
	/**
	 * 公用业务扩展参数
	 * <p>
	 * 用于商户的特定业务信息的传递，只有商户与支付宝约定了传递此参数且约定了参数含义，此参数才有效。
	 * 
	 * <br>
	 * 参数格式：参数名1^参数值1|参数名2^参数值2|……<br>
	 * 
	 * 多条数据用“|”间隔。<br>
	 * 
	 * 支付类型（payment_type）为47（电子卡券）时，需要包含凭证号（evoucheprod_evouche_id）参数名和参数值。
	 */
	private String extend_param;
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
	private String it_b_pay;
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
	private String default_login;
	/**
	 * 商户申请的产品类型
	 * <p>
	 * 用于针对不同的产品，采取不同的计费策略。
	 * 
	 * 如果开通了航旅垂直搜索平台产品，请填写CHANNEL_FAST_PAY；如果没有，则为空。
	 */
	private String product_type;
	/**
	 * 快捷登录授权令牌
	 * <p>
	 * 如果开通了快捷登录产品，则需要填写；如果没有开通，则为空。
	 */
	private String token;
	/**
	 * 商户买家签约号
	 * <p>
	 * 用于唯一标识商户买家。
	 * 
	 * 如果本参数不为空，则sign_name_ext不能为空。
	 */
	private String sign_id_ext;
	/**
	 * 商户买家签约名
	 * <p>
	 * 商户买家唯一标识对应的名字。
	 */
	private String sign_name_ext;
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
	private String qr_pay_mode;

	/**
	 * 接口名称 *
	 * <p>
	 * 接口名称。
	 */
	@Override

	public String getService() {
		return service;
	}

	/**
	 * 接口名称 *
	 * <p>
	 * 接口名称。
	 */
	public void setService(String service) {
		this.service = service;
	}

	/**
	 * 合作者身份ID *
	 * <p>
	 * 签约的支付宝账号对应的支付宝唯一用户号。以2088开头的16位纯数字组成。
	 */
	@Override
	public String getPartner() {
		return partner;
	}

	/**
	 * 合作者身份ID *
	 * <p>
	 * 签约的支付宝账号对应的支付宝唯一用户号。以2088开头的16位纯数字组成。
	 */
	public void setPartner(String partner) {
		this.partner = partner;
	}

	/**
	 * 参数编码字符集 *
	 * <p>
	 * 商户网站使用的编码格式，如utf-8、gbk、gb2312等。
	 */
	@Override
	public String get_input_charset() {
		return _input_charset;
	}

	/**
	 * 参数编码字符集 *
	 * <p>
	 * 商户网站使用的编码格式，如utf-8、gbk、gb2312等。
	 */
	public void set_input_charset(String _input_charset) {
		this._input_charset = _input_charset;
	}

	/**
	 * 签名方式 *
	 * <p>
	 * DSA、RSA、MD5三个值可选，必须大写。
	 */
	@Override
	public String getSign_type() {
		return sign_type;
	}

	/**
	 * 签名方式 *
	 * <p>
	 * DSA、RSA、MD5三个值可选，必须大写。
	 */
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	/**
	 * 签名 *
	 * <p>
	 */
	@Override
	public String getSign() {
		return sign;
	}

	/**
	 * 签名 *
	 * <p>
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * 服务器异步通知页面路径
	 * <p>
	 * 支付宝服务器主动通知商户网站里指定的页面http路径。
	 */
	@Override
	public String getNotify_url() {
		return notify_url;
	}

	/**
	 * 服务器异步通知页面路径
	 * <p>
	 * 支付宝服务器主动通知商户网站里指定的页面http路径。
	 */
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	/**
	 * 页面跳转同步通知页面路径
	 * <p>
	 * 支付宝处理完请求后，当前页面自动跳转到商户网站里指定页面的http路径。
	 */
	@Override
	public String getReturn_url() {
		return return_url;
	}

	/**
	 * 页面跳转同步通知页面路径
	 * <p>
	 * 支付宝处理完请求后，当前页面自动跳转到商户网站里指定页面的http路径。
	 */
	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}

	/**
	 * 请求出错时的通知页面路径
	 * <p>
	 * 当商户通过该接口发起请求时，如果出现提示报错，支付宝会根据请求出错时的通知错误码通过异步的方式发送通知给商户。<br>
	 * 该功能需要联系支付宝开通。
	 */
	@Override
	public String getError_notify_url() {
		return error_notify_url;
	}

	/**
	 * 请求出错时的通知页面路径
	 * <p>
	 * 当商户通过该接口发起请求时，如果出现提示报错，支付宝会根据请求出错时的通知错误码通过异步的方式发送通知给商户。<br>
	 * 该功能需要联系支付宝开通。
	 */
	public void setError_notify_url(String error_notify_url) {
		this.error_notify_url = error_notify_url;
	}

	/***** 以下为业务参数 *****/
	/**
	 * 商户网站唯一订单号 *
	 * <p>
	 * 支付宝合作商户网站唯一订单号。
	 */
	@Override
	public String getOut_trade_no() {
		return out_trade_no;
	}

	/**
	 * 商户网站唯一订单号 *
	 * <p>
	 * 支付宝合作商户网站唯一订单号。
	 */
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	/**
	 * 商品名称 *
	 * <p>
	 * 商品的标题/交易标题/订单标题/订单关键字等。<br>
	 * 该参数最长为128个汉字。
	 */
	@Override
	public String getSubject() {
		return subject;
	}

	/**
	 * 商品名称 *
	 * <p>
	 * 商品的标题/交易标题/订单标题/订单关键字等。<br>
	 * 该参数最长为128个汉字。
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * 支付类型 *
	 * <p>
	 * 默认值为：1（商品购买）。<br>
	 * 1-商品购买;4-捐赠;47-电子卡券<br>
	 * 注意：支付类型为“47”时，公共业务扩展参数（extend_param）中必须包含凭证号（
	 * evoucheprod_evouche_id）参数名和参数值。
	 */
	@Override
	public String getPayment_type() {
		return payment_type;
	}

	/**
	 * 支付类型 *
	 * <p>
	 * 默认值为：1（商品购买）。<br>
	 * 1-商品购买;4-捐赠;47-电子卡券<br>
	 * 注意：支付类型为“47”时，公共业务扩展参数（extend_param）中必须包含凭证号（
	 * evoucheprod_evouche_id）参数名和参数值。
	 */
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	/**
	 * 交易金额 *
	 * <p>
	 * 该笔订单的资金总额，单位为RMB-Yuan。取值范围为[0.01，100000000.00]，精确到小数点后两位。
	 */
	public BigDecimal getTotal_fee() {
		return total_fee;
	}

	/**
	 * 交易金额 *
	 * <p>
	 * 该笔订单的资金总额，单位为RMB-Yuan。取值范围为[0.01，100000000.00]，精确到小数点后两位。
	 */
	public void setTotal_fee(BigDecimal total_fee) {
		this.total_fee = total_fee;
	}

	/**
	 * 卖家支付宝用户号 *
	 * <p>
	 * seller_id是以2088开头的纯16位数字。<br>
	 * seller_email是支付宝登录账号，格式一般是邮箱或手机号。<br>
	 * seller_account_name是卖家别名支付宝账号。三个参数至少必须传递一个。<br>
	 * 当签约账号就是收款账号时，请务必使用参数seller_id，即seller_id的值与partner的值相同。<br>
	 * 三个参数的优先级别是：seller_id>seller_account_name>seller_email。
	 */
	@Override
	public String getSeller_id() {
		return seller_id;
	}

	/**
	 * 卖家支付宝用户号 *
	 * <p>
	 * seller_id是以2088开头的纯16位数字。<br>
	 * seller_email是支付宝登录账号，格式一般是邮箱或手机号。<br>
	 * seller_account_name是卖家别名支付宝账号。三个参数至少必须传递一个。<br>
	 * 当签约账号就是收款账号时，请务必使用参数seller_id，即seller_id的值与partner的值相同。<br>
	 * 三个参数的优先级别是：seller_id>seller_account_name>seller_email。
	 */
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	/**
	 * 卖家支付宝账号 *
	 * <p>
	 * seller_id是以2088开头的纯16位数字。<br>
	 * seller_email是支付宝登录账号，格式一般是邮箱或手机号。<br>
	 * seller_account_name是卖家别名支付宝账号。三个参数至少必须传递一个。<br>
	 * 当签约账号就是收款账号时，请务必使用参数seller_id，即seller_id的值与partner的值相同。<br>
	 * 三个参数的优先级别是：seller_id>seller_account_name>seller_email。
	 */
	@Override
	public String getSeller_email() {
		return seller_email;
	}

	/**
	 * 卖家支付宝账号 *
	 * <p>
	 * seller_id是以2088开头的纯16位数字。<br>
	 * seller_email是支付宝登录账号，格式一般是邮箱或手机号。<br>
	 * seller_account_name是卖家别名支付宝账号。三个参数至少必须传递一个。<br>
	 * 当签约账号就是收款账号时，请务必使用参数seller_id，即seller_id的值与partner的值相同。<br>
	 * 三个参数的优先级别是：seller_id>seller_account_name>seller_email。
	 */
	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}

	/**
	 * 卖家别名支付宝账号 *
	 * <p>
	 * seller_id是以2088开头的纯16位数字。<br>
	 * seller_email是支付宝登录账号，格式一般是邮箱或手机号。<br>
	 * seller_account_name是卖家别名支付宝账号。三个参数至少必须传递一个。<br>
	 * 当签约账号就是收款账号时，请务必使用参数seller_id，即seller_id的值与partner的值相同。<br>
	 * 三个参数的优先级别是：seller_id>seller_account_name>seller_email。
	 */
	@Override
	public String getSeller_account_name() {
		return seller_account_name;
	}

	/**
	 * 卖家别名支付宝账号 *
	 * <p>
	 * 三个参数的优先级别是：seller_id>seller_account_name>seller_email。
	 */
	public void setSeller_account_name(String seller_account_name) {
		this.seller_account_name = seller_account_name;
	}

	/**
	 * 买家支付宝用户号
	 * <p>
	 * 买家支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字。
	 */
	@Override
	public String getBuyer_id() {
		return buyer_id;
	}

	/**
	 * 买家支付宝用户号
	 * <p>
	 * 买家支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字。
	 */
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	/**
	 * 买家支付宝账号
	 * <p>
	 * 买家支付宝账号，格式为邮箱或手机号。
	 */
	@Override
	public String getBuyer_email() {
		return buyer_email;
	}

	/**
	 * 买家支付宝账号
	 * <p>
	 * 买家支付宝账号，格式为邮箱或手机号。
	 */
	public void setBuyer_email(String buyer_email) {
		this.buyer_email = buyer_email;
	}

	/**
	 * 买家别名支付宝账号
	 * <p>
	 * 买家别名支付宝账号。<br>
	 * 买家信息优先级：buyer_id>buyer_account_name>buyer_email。
	 */
	@Override
	public String getBuyer_account_name() {
		return buyer_account_name;
	}

	/**
	 * 买家别名支付宝账号
	 * <p>
	 * 买家别名支付宝账号。<br>
	 * 买家信息优先级：buyer_id>buyer_account_name>buyer_email。
	 */
	public void setBuyer_account_name(String buyer_account_name) {
		this.buyer_account_name = buyer_account_name;
	}

	/**
	 * 商品单价
	 * <p>
	 * 单位为：RMB Yuan。取值范围为[0.01，100000000.00]，精确到小数点后两位。此参数为单价<br>
	 * 规则：price、quantity能代替total_fee。即存在total_fee，就不能存在price和quantity；存在price、
	 * quantity，就不能存在total_fee。
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * 商品单价
	 * <p>
	 * 单位为：RMB Yuan。取值范围为[0.01，100000000.00]，精确到小数点后两位。此参数为单价<br>
	 * 规则：price、quantity能代替total_fee。即存在total_fee，就不能存在price和quantity；存在price、
	 * quantity，就不能存在total_fee。
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * 购买数量
	 * <p>
	 * price、quantity能代替total_fee。即存在total_fee，就不能存在price和quantity；存在price、
	 * quantity，就不能存在total_fee。
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * 购买数量
	 * <p>
	 * price、quantity能代替total_fee。即存在total_fee，就不能存在price和quantity；存在price、
	 * quantity，就不能存在total_fee。
	 */
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	/**
	 * 商品描述
	 * <p>
	 * 对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
	 */
	@Override
	public String getBody() {
		return body;
	}

	/**
	 * 商品描述
	 * <p>
	 * 对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * 商品展示网址
	 * <p>
	 * 收银台页面上，商品展示的超链接。
	 */
	@Override
	public String getShow_url() {
		return show_url;
	}

	/**
	 * 商品展示网址
	 * <p>
	 * 收银台页面上，商品展示的超链接。
	 */
	public void setShow_url(String show_url) {
		this.show_url = show_url;
	}

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
	@Override
	public String getPaymethod() {
		return paymethod;
	}

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
	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	/**
	 * 支付渠道
	 * <p>
	 * 用于控制收银台支付渠道显示，该值的取值范围请参见支付渠道。
	 * 
	 * 可支持多种支付渠道显示，以“^”分隔
	 */
	@Override
	public String getEnable_paymethod() {
		return enable_paymethod;
	}

	/**
	 * 支付渠道
	 * <p>
	 * 用于控制收银台支付渠道显示，该值的取值范围请参见支付渠道。
	 * 
	 * 可支持多种支付渠道显示，以“^”分隔
	 */
	public void setEnable_paymethod(String enable_paymethod) {
		this.enable_paymethod = enable_paymethod;
	}

	/**
	 * 网银支付时是否做CTU校验
	 * <p>
	 * 商户在配置了支持CTU（支付宝风险稽查系统）校验权限的前提下，可以选择本次交易是否需要经过CTU校验。
	 * 
	 * <br>
	 * Y：做CTU校验；<br>
	 * N：不做CTU校验。<br>
	 */
	@Override
	public String getNeed_ctu_check() {
		return need_ctu_check;
	}

	/**
	 * 网银支付时是否做CTU校验
	 * <p>
	 * 商户在配置了支持CTU（支付宝风险稽查系统）校验权限的前提下，可以选择本次交易是否需要经过CTU校验。
	 * 
	 * <br>
	 * Y：做CTU校验；<br>
	 * N：不做CTU校验。<br>
	 */
	public void setNeed_ctu_check(String need_ctu_check) {
		this.need_ctu_check = need_ctu_check;
	}

	/**
	 * 防钓鱼时间戳
	 * <p>
	 * 通过时间戳查询接口获取的加密支付宝系统时间戳。 <br>
	 * 如果已申请开通防钓鱼时间戳验证，则此字段必填。
	 */
	@Override
	public String getAnti_phishing_key() {
		return anti_phishing_key;
	}

	/**
	 * 防钓鱼时间戳
	 * <p>
	 * 通过时间戳查询接口获取的加密支付宝系统时间戳。 <br>
	 * 如果已申请开通防钓鱼时间戳验证，则此字段必填。
	 */
	public void setAnti_phishing_key(String anti_phishing_key) {
		this.anti_phishing_key = anti_phishing_key;
	}

	/**
	 * 客户端IP
	 * <p>
	 * 用户在创建交易时，该用户当前所使用机器的IP。
	 * 
	 * <br>
	 * 如果商户申请后台开通防钓鱼IP地址检查选项，此字段必填，校验用。
	 */
	@Override
	public String getExter_invoke_ip() {
		return exter_invoke_ip;
	}

	/**
	 * 客户端IP
	 * <p>
	 * 用户在创建交易时，该用户当前所使用机器的IP。
	 * 
	 * <br>
	 * 如果商户申请后台开通防钓鱼IP地址检查选项，此字段必填，校验用。
	 */
	public void setExter_invoke_ip(String exter_invoke_ip) {
		this.exter_invoke_ip = exter_invoke_ip;
	}

	/**
	 * 公用回传参数
	 * <p>
	 * 如果用户请求时传递了该参数，则返回给商户时会回传该参数。
	 */
	@Override
	public String getExtra_common_param() {
		return extra_common_param;
	}

	/**
	 * 公用回传参数
	 * <p>
	 * 如果用户请求时传递了该参数，则返回给商户时会回传该参数。
	 */
	public void setExtra_common_param(String extra_common_param) {
		this.extra_common_param = extra_common_param;
	}

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
	@Override
	public String getExtend_param() {
		return extend_param;
	}

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
	public void setExtend_param(String extend_param) {
		this.extend_param = extend_param;
	}

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
	@Override
	public String getIt_b_pay() {
		return it_b_pay;
	}

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
	public void setIt_b_pay(String it_b_pay) {
		this.it_b_pay = it_b_pay;
	}

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
	@Override
	public String getDefault_login() {
		return default_login;
	}

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
	public void setDefault_login(String default_login) {
		this.default_login = default_login;
	}

	/**
	 * 商户申请的产品类型
	 * <p>
	 * 用于针对不同的产品，采取不同的计费策略。
	 * 
	 * 如果开通了航旅垂直搜索平台产品，请填写CHANNEL_FAST_PAY；如果没有，则为空。
	 */
	@Override
	public String getProduct_type() {
		return product_type;
	}

	/**
	 * 商户申请的产品类型
	 * <p>
	 * 用于针对不同的产品，采取不同的计费策略。
	 * 
	 * 如果开通了航旅垂直搜索平台产品，请填写CHANNEL_FAST_PAY；如果没有，则为空。
	 */
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	/**
	 * 快捷登录授权令牌
	 * <p>
	 * 如果开通了快捷登录产品，则需要填写；如果没有开通，则为空。
	 */
	@Override
	public String getToken() {
		return token;
	}

	/**
	 * 快捷登录授权令牌
	 * <p>
	 * 如果开通了快捷登录产品，则需要填写；如果没有开通，则为空。
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * 商户买家签约号
	 * <p>
	 * 用于唯一标识商户买家。
	 * 
	 * 如果本参数不为空，则sign_name_ext不能为空。
	 */
	@Override
	public String getSign_id_ext() {
		return sign_id_ext;
	}

	/**
	 * 商户买家签约号
	 * <p>
	 * 用于唯一标识商户买家。
	 * 
	 * 如果本参数不为空，则sign_name_ext不能为空。
	 */
	public void setSign_id_ext(String sign_id_ext) {
		this.sign_id_ext = sign_id_ext;
	}

	/**
	 * 商户买家签约名
	 * <p>
	 * 商户买家唯一标识对应的名字。
	 */
	@Override
	public String getSign_name_ext() {
		return sign_name_ext;
	}

	/**
	 * 商户买家签约名
	 * <p>
	 * 商户买家唯一标识对应的名字。
	 */
	public void setSign_name_ext(String sign_name_ext) {
		this.sign_name_ext = sign_name_ext;
	}

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
	@Override
	public String getQr_pay_mode() {
		return qr_pay_mode;
	}

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
	public void setQr_pay_mode(String qr_pay_mode) {
		this.qr_pay_mode = qr_pay_mode;
	}

}
