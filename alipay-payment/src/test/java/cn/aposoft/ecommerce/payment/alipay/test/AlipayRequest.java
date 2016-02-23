package cn.aposoft.ecommerce.payment.alipay.test;

import java.math.BigDecimal;

import cn.aposoft.ecommerce.payment.alipay.AliOrder;

/**
 * 支付宝支付请求参数
 * 
 * @author Yujinshui
 *
 */
public class AlipayRequest implements AliOrder {

	/**
	 * 接口名称*
	 * <p>
	 */
	private String service;
	/**
	 * 服务器异步通知页面路径
	 * <p>
	 */
	private String notify_url;
	/**
	 * 签名类型
	 * <p>
	 */
	private String alipay_ca_request;
	/**
	 * 商户网站唯一订单号*
	 * <p>
	 */
	private String out_trade_no;
	/**
	 * 订单标题*
	 * <p>
	 */
	private String subject;
	/**
	 * 订单业务类型*
	 * <p>
	 */
	private String product_code;
	/**
	 * 订单金额*
	 * <p>
	 */
	private BigDecimal total_fee;
	/**
	 * 卖家支付宝用户号
	 * <p>
	 */
	private String seller_id;
	/**
	 * 卖家支付宝账号
	 * <p>
	 */
	private String seller_email;
	/**
	 * 操作员类型
	 * <p>
	 */
	private String operator_code;
	/**
	 * 操作员号
	 * <p>
	 */
	private String operator_id;
	/**
	 * 订单描述
	 * <p>
	 */
	private String body;
	/**
	 * 商品展示网址
	 * <p>
	 */
	private String show_url;
	/**
	 * 订单金额币种
	 * <p>
	 */
	private String currency;
	/**
	 * 商品单价
	 * <p>
	 */
	private BigDecimal price;
	/**
	 * 商品数量
	 * <p>
	 */
	private String quantity;
	/**
	 * 商品明细
	 * <p>
	 */
	private String goods_detail;
	/**
	 * 公用业务扩展信息
	 * <p>
	 */
	private String extend_params;
	/**
	 * 订单支付超时时间
	 * <p>
	 */
	private String it_b_pay;
	/**
	 * 分账类型
	 * <p>
	 */
	private String royalty_type;
	/**
	 * 分账信息
	 * <p>
	 */
	private String royalty_parameters;
	/**
	 * 渠道参数
	 * <p>
	 * 描述多渠道收单的渠道明细 信息，json格式，具体请参见 “4.5 渠道明细说明”。
	 * 
	 */
	private String channel_parameters;
	/**
	 * 业务透传参数
	 * <p>
	 * 商户与支付宝约定的业务透传参数，异步通知中会回传 给商户（参数名为 extra_common_param）。<br>
	 * 具体请参见“4.7 业务透传参数说明”。
	 * 
	 */
	private String passback_parameters;

	/**
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.AliOrder#getService()
	 */
	@Override
	public String getService() {

		return service;
	}

	@Override
	public String getNotify_url() {
		return notify_url;
	}

	@Override
	public String getAlipay_ca_request() {
		return alipay_ca_request;
	}

	@Override
	public String getOut_trade_no() {
		return out_trade_no;
	}

	@Override
	public String getSubject() {
		return subject;
	}

	@Override
	public String getProduct_code() {
		return product_code;
	}

	@Override
	public BigDecimal getTotal_fee() {
		return total_fee;
	}

	@Override
	public String getSeller_id() {
		return seller_id;
	}

	@Override
	public String getSeller_email() {
		return seller_email;
	}

	@Override
	public String getOperator_code() {
		return operator_code;
	}

	@Override
	public String getOperator_id() {
		return operator_id;
	}

	@Override
	public String getBody() {
		return body;
	}

	@Override
	public String getShow_url() {
		return show_url;
	}

	@Override
	public String getCurrency() {
		return currency;
	}

	@Override
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public String getQuantity() {
		return quantity;
	}

	@Override
	public String getGoods_detail() {
		return goods_detail;
	}

	@Override
	public String getExtend_params() {
		return extend_params;
	}

	@Override
	public String getIt_b_pay() {
		return it_b_pay;
	}

	@Override
	public String getRoyalty_type() {
		return royalty_type;
	}

	@Override
	public String getRoyalty_parameters() {
		return royalty_parameters;
	}

	@Override
	public String getChannel_parameters() {
		return channel_parameters;
	}

	@Override
	public String getPassback_parameters() {
		return passback_parameters;
	}

	/**
	 * 接口名称 *
	 * <p>
	 * alipay.acquire.precreate
	 * 
	 * @param service
	 * @author Yujinshui
	 * @time 2015年11月19日 上午10:56:11
	 */
	public void setService(String service) {
		this.service = service;
	}

	/**
	 * 服务器异步通知页面路径
	 * <p>
	 * 支付宝服务器主动通知商户网站里指定的页面http路径。
	 * 
	 * @param notify_url
	 * @author Yujinshui
	 * @time 2015年11月19日 上午10:56:21
	 */
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	/**
	 * 签名类型
	 * <p>
	 * 签名类型。<br>
	 * 1：证书签名<br>
	 * 2：其他密钥签名<br>
	 * 如果为空，默认为 2。
	 * 
	 * @param alipay_ca_request
	 * @author Yujinshui
	 * @time 2015年11月19日 上午10:56:34
	 */
	public void setAlipay_ca_request(String alipay_ca_request) {
		this.alipay_ca_request = alipay_ca_request;
	}

	/**
	 * 商户网站唯一订单号 *
	 * <p>
	 * 支付宝合作商户网站唯一订单号。
	 * 
	 * @param out_trade_no
	 * @author Yujinshui
	 * @time 2015年11月19日 上午10:57:37
	 */
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	/**
	 * 商品名称 *
	 * <p>
	 * 商品的标题/交易标题/订单标题/订单关键字等。<br>
	 * 该参数最长为128个汉字。
	 * 
	 * @param subject
	 * @author Yujinshui
	 * @time 2015年11月19日 上午10:57:50
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * 订单业务类型*
	 * <p>
	 * 用来区分是哪种业务类型的 下单。目前支持：<br>
	 * z QR_CODE_OFFLINE ：<br>
	 * 二维码支付<br>
	 * z TCOMPANY_QR_OFFL<br>
	 * INE：出租车企业码
	 * 
	 * @param product_code
	 * @author Yujinshui
	 * @time 2015年11月19日 上午10:58:03
	 */
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	/**
	 * 交易金额 *
	 * <p>
	 * 该笔订单的资金总额，单位为RMB-Yuan。取值范围为[0.01，100000000.00]，精确到小数点后两位。
	 *
	 * @param total_fee
	 * @author Yujinshui
	 * @time 2015年11月19日 上午10:58:16
	 */
	public void setTotal_fee(BigDecimal total_fee) {
		this.total_fee = total_fee;
	}

	/**
	 * 卖家支付宝用户号
	 * <p>
	 * 卖家支付宝账号对应的支付 宝唯一用户号。<br>
	 * 以 2088 开头的纯 16 位数字。 如果和 seller_email 同时为 空，则本参数默认填充 partner 的值。
	 *
	 * @param seller_id
	 * @author Yujinshui
	 * @time 2015年11月19日 上午10:58:25
	 */
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	/**
	 * 卖家支付宝账号 *
	 * <p>
	 * 卖家支付宝账号，可以为 email 或者手机号。<br>
	 * 如果 seller_id 不为空，则以 seller_id 的值作为卖家账号， 忽略本参数。
	 *
	 * @param seller_email
	 * @author Yujinshui
	 * @time 2015年11月19日 上午10:58:34
	 */
	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}

	/**
	 * 操作员类型
	 * <p>
	 * 操作员的类型：<br>
	 * 0：支付宝操作员<br>
	 * 1：商户的操作员<br>
	 * 如果传入其它值或者为空， 则默认设置为 1。
	 * 
	 * @param operator_code
	 * @author Yujinshui
	 * @time 2015年11月19日 上午10:58:46
	 */
	public void setOperator_code(String operator_code) {
		this.operator_code = operator_code;
	}

	/**
	 * 操作员号
	 * <p>
	 * 卖家的操作员 ID。
	 * 
	 * @param operator_id
	 * @author Yujinshui
	 * @time 2015年11月19日 上午10:58:56
	 */
	public void setOperator_id(String operator_id) {
		this.operator_id = operator_id;
	}

	/**
	 * 订单描述
	 * <p>
	 * 对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
	 *
	 * @param body
	 * @author Yujinshui
	 * @time 2015年11月19日 上午10:59:06
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * 商品展示网址
	 * <p>
	 * 收银台页面上，商品展示的超链接。
	 * 
	 * @param show_url
	 * @author Yujinshui
	 * @time 2015年11月19日 上午10:59:16
	 */
	public void setShow_url(String show_url) {
		this.show_url = show_url;
	}

	/**
	 * 订单金额币种
	 * <p>
	 * 订单金额币种。<br>
	 * 目前只支持传入 156（人民 币）。<br>
	 * 如果为空，则默认设置为 156。
	 * 
	 * @param currency
	 * @author Yujinshui
	 * @time 2015年11月19日 上午10:59:26
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * 商品单价
	 * <p>
	 * 单位为：RMB Yuan。取值范围为[0.01，100000000.00]，精确到小数点后两位。此参数为单价<br>
	 * 规则：price、quantity能代替total_fee。即存在total_fee，就不能存在price和quantity；存在price、
	 * quantity，就不能存在total_fee。
	 * 
	 * @param price
	 * @author Yujinshui
	 * @time 2015年11月19日 上午10:59:35
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * 购买数量
	 * <p>
	 * price、quantity能代替total_fee。即存在total_fee，就不能存在price和quantity；存在price、
	 * quantity，就不能存在total_fee
	 * 
	 * @param quantity
	 * @author Yujinshui
	 * @time 2015年11月19日 上午10:59:49
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * 商品明细
	 * <p>
	 * 描述商品明细信息， 式，具体请参见“ 4.3 json 商品 格 明细说明”<br>
	 * param_demo:[{"goodsName":"ipad","p rice":"2000.00","quantity
	 * ":"1","goodsCategory":"7 788230"}]
	 * 
	 * @param goods_detail
	 * @author Yujinshui
	 * @time 2015年11月19日 上午10:59:57
	 */
	public void setGoods_detail(String goods_detail) {
		this.goods_detail = goods_detail;
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
	 *
	 * @param extend_params
	 * @author Yujinshui
	 * @time 2015年11月19日 上午11:00:10
	 */
	public void setExtend_params(String extend_params) {
		this.extend_params = extend_params;
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
	 * 
	 * @param it_b_pay
	 * @author Yujinshui
	 * @time 2015年11月19日 上午11:00:22
	 */
	public void setIt_b_pay(String it_b_pay) {
		this.it_b_pay = it_b_pay;
	}

	/**
	 * 分账类型
	 * <p>
	 * 卖家的分账类型，目前只支 持传入 ROYALTY （普通分账 类型）。<br>
	 * 如果商户使用分账模式，该 参数不可空。
	 * 
	 * @param royalty_type
	 * @author Yujinshui
	 * @time 2015年11月19日 上午11:00:31
	 */
	public void setRoyalty_type(String royalty_type) {
		this.royalty_type = royalty_type;
	}

	/**
	 * 分账信息
	 * <p>
	 * 描述分账明细信息， json格 式，具体请参见“ 4.4 分账 明细说明”。
	 * 
	 * @param royalty_parameters
	 * @author Yujinshui
	 * @time 2015年11月19日 上午11:00:39
	 */
	public void setRoyalty_parameters(String royalty_parameters) {
		this.royalty_parameters = royalty_parameters;
	}

	/**
	 * 渠道参数
	 * <p>
	 * 描述多渠道收单的渠道明细 信息， json格式，具体请参见 “ 4.5 渠道明细说明”。
	 * 
	 * @param channel_parameters
	 * @author Yujinshui
	 * @time 2015年11月19日 上午11:00:48
	 */
	public void setChannel_parameters(String channel_parameters) {
		this.channel_parameters = channel_parameters;
	}

	/**
	 * 业务透传参数
	 * <p>
	 * 商户与支付宝约定的业务透传参数，异步通知中会回传 给商户（参数名为 extra_common_param）。<br>
	 * 具体请参见“4.7 业务透传参数说明”。
	 * 
	 * @param passback_parameters
	 * @author Yujinshui
	 * @time 2015年11月19日 上午11:00:56
	 */
	public void setPassback_parameters(String passback_parameters) {
		this.passback_parameters = passback_parameters;
	}
}
