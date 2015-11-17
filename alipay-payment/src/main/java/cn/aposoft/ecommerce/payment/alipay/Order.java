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
	 * alipay.acquire.precreate
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
	 * DSA、RSA、MD5三个值可选，必须大写。推荐MD5
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
	 * 签名类型
	 * <p>
	 * 签名类型。<br>
	 * 1：证书签名<br>
	 * 2：其他密钥签名<br>
	 * 如果为空，默认为 2。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 上午11:39:30
	 */
	public String getAlipay_ca_request();

	// /**
	// * 页面跳转同步通知页面路径
	// * <p>
	// * 支付宝处理完请求后，当前页面自动跳转到商户网站里指定页面的http路径。
	// */
	//
	// public String getReturn_url();
	//
	// /**
	// * 请求出错时的通知页面路径
	// * <p>
	// * 当商户通过该接口发起请求时，如果出现提示报错，支付宝会根据请求出错时的通知错误码通过异步的方式发送通知给商户。<br>
	// * 该功能需要联系支付宝开通。
	// */
	//
	// public String getError_notify_url();

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
	 * 订单业务类型*
	 * <p>
	 * 用来区分是哪种业务类型的 下单。目前支持：<br>
	 * z QR_CODE_OFFLINE ：<br>
	 * 二维码支付<br>
	 * z TCOMPANY_QR_OFFL<br>
	 * INE：出租车企业码
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 上午11:41:09
	 */
	public String getProduct_code();

	/**
	 * 交易金额 *
	 * <p>
	 * 该笔订单的资金总额，单位为RMB-Yuan。取值范围为[0.01，100000000.00]，精确到小数点后两位。
	 */
	public BigDecimal getTotal_fee();

	/**
	 * 卖家支付宝用户号
	 * <p>
	 * 卖家支付宝账号对应的支付 宝唯一用户号。<br>
	 * 以 2088 开头的纯 16 位数字。 如果和 seller_email 同时为 空，则本参数默认填充 partner 的值。
	 */

	public String getSeller_id();

	/**
	 * 卖家支付宝账号 *
	 * <p>
	 * 卖家支付宝账号，可以为 email 或者手机号。<br>
	 * 如果 seller_id 不为空，则以 seller_id 的值作为卖家账号， 忽略本参数。
	 */

	public String getSeller_email();

	/**
	 * 操作员类型
	 * <p>
	 * 操作员的类型：<br>
	 * 0：支付宝操作员<br>
	 * 1：商户的操作员<br>
	 * 如果传入其它值或者为空， 则默认设置为 1。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 上午11:45:34
	 */
	public String getOperator_code();

	/**
	 * 操作员号
	 * <p>
	 * 卖家的操作员 ID。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 上午11:46:24
	 */
	public String getOperator_id();

	/**
	 * 订单描述
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
	 * 订单金额币种
	 * <p>
	 * 订单金额币种。<br>
	 * 目前只支持传入 156（人民 币）。<br>
	 * 如果为空，则默认设置为 156。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 上午11:48:29
	 */
	public String getCurrency();

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
	public String getQuantity();

	/**
	 * 商品明细
	 * <p>
	 * 描述商品明细信息， 式，具体请参见“ 4.3 json 商品 格 明细说明”<br>
	 * param_demo:[{"goodsName":"ipad","p rice":"2000.00","quantity
	 * ":"1","goodsCategory":"7 788230"}]
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 上午11:50:43
	 */
	public String getGoods_detail();

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

	public String getExtend_params();

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
	 * 分账类型
	 * <p>
	 * 卖家的分账类型，目前只支 持传入 ROYALTY （普通分账 类型）。<br>
	 * 如果商户使用分账模式，该 参数不可空。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 上午11:52:37
	 */
	public String getRoyalty_type();

	/**
	 * 分账信息
	 * <p>
	 * 描述分账明细信息， json格 式，具体请参见“ 4.4 分账 明细说明”。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 上午11:53:25
	 */
	public String getRoyalty_parameters();

	/**
	 * 渠道参数
	 * <p>
	 * 描述多渠道收单的渠道明细 信息， json格式，具体请参见 “ 4.5 渠道明细说明”。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 上午11:54:22
	 */
	public String getChannel_parameters();

}
