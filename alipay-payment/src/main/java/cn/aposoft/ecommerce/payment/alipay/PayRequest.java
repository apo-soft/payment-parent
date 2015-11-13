package cn.aposoft.ecommerce.payment.alipay;

import java.util.List;

/**
 * 预下单请求参数
 * 
 * @author Yujinshui
 *
 */
public class PayRequest extends PublicParamsRequest {

	/**
	 * 商户订单号*
	 * <p>
	 * 商户订单号,64个字符以内、可包含字母、数字、下划线；需保证在商户端不重复
	 */
	private String out_trade_no;
	/**
	 * 卖家支付宝用户ID
	 * <p>
	 * 如果该值为空，则默认为商户签约账号对应的支付宝用户ID
	 */
	private String seller_id;
	/**
	 * 订单总金额
	 * <p>
	 * 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]。<br>
	 * 如果同时传入【可打折金额】和【不可打折金额】，该参数可以不用传入；<br>
	 * 如果同时传入了【可打折金额】，【不可打折金额】，【订单总金额】三者，则必须满足如下条件：【订单总金额】=【可打折金额】+【不可打折金额】
	 */
	private String total_amount;
	/**
	 * 可打折金额
	 * <p>
	 * 参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]。<br>
	 * 如果该值未传入，但传入了【订单总金额】和 【不可打折金额】，则该值默认为【订单总金额】-【不可打折金额】
	 */
	private String discountable_amount;
	/**
	 * 不可打折金额
	 * <p>
	 * 不参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]。<br>
	 * 如果该值未传入，但传入了【订单总金额】 和【可打折金额】，则该值默认为【订单总金额】-【可打折金额】
	 */
	private String undiscountable_amount;
	/**
	 * 订单标题*
	 * <p>
	 */
	private String subject;
	/**
	 * 订单描述
	 * <p>
	 * 对交易或商品的描述
	 */
	private String body;
	/**
	 * 商品明细列表
	 * <p>
	 * 订单包含的商品列表信息，Json格式，其它说明详见商品明细说明
	 */
	private List<GoodsDetail> goods_detail;
	/**
	 * 商户操作员编号
	 * <p>
	 */
	private String operator_id;
	/**
	 * 商户门店编号
	 * <p>
	 */
	private String store_id;
	/**
	 * 机具终端编号
	 * <p>
	 * 商户机具终端编号
	 */
	private String terminal_id;
	/**
	 * 扩展参数
	 * <p>
	 * 业务扩展参数，sys_service_provider_id：系统商编号
	 */
	private ExtendParams extend_params;
	/**
	 * 支付超时时间
	 * <p>
	 * 该笔订单允许的最晚付款时间，逾期将关闭交易。格式为：yyyy-MM-dd HH:mm:ss
	 */
	private String time_expire;
	/**
	 * 分账信息
	 * <p>
	 * 描述分账信息，Json格式，其它说明详见分账说明
	 */
	private RoyaltyInfo royalty_info;

	/**
	 * 商户订单号*
	 * <p>
	 * 商户订单号,64个字符以内、可包含字母、数字、下划线；需保证在商户端不重复
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:18:05
	 */
	public String getOut_trade_no() {
		return out_trade_no;
	}

	/**
	 * 商户订单号*
	 * <p>
	 * 商户订单号,64个字符以内、可包含字母、数字、下划线；需保证在商户端不重复
	 */
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	/**
	 * 卖家支付宝用户ID
	 * <p>
	 * 如果该值为空，则默认为商户签约账号对应的支付宝用户ID
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:21:52
	 */
	public String getSeller_id() {
		return seller_id;
	}

	/**
	 * 卖家支付宝用户ID
	 * <p>
	 * 如果该值为空，则默认为商户签约账号对应的支付宝用户ID
	 * 
	 * @param seller_id
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:21:57
	 */
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	/**
	 * 订单总金额
	 * <p>
	 * 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]。<br>
	 * 如果同时传入【可打折金额】和【不可打折金额】，该参数可以不用传入；<br>
	 * 如果同时传入了【可打折金额】，【不可打折金额】，【订单总金额】三者，则必须满足如下条件：【订单总金额】=【可打折金额】+【不可打折金额】
	 *
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:22:16
	 */
	public String getTotal_amount() {
		return total_amount;
	}

	/**
	 * 订单总金额
	 * <p>
	 * 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]。<br>
	 * 如果同时传入【可打折金额】和【不可打折金额】，该参数可以不用传入；<br>
	 * 如果同时传入了【可打折金额】，【不可打折金额】，【订单总金额】三者，则必须满足如下条件：【订单总金额】=【可打折金额】+【不可打折金额】
	 *
	 * @param total_amount
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:22:22
	 */
	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}

	/**
	 * 可打折金额
	 * <p>
	 * 参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]。<br>
	 * 如果该值未传入，但传入了【订单总金额】和 【不可打折金额】，则该值默认为【订单总金额】-【不可打折金额】
	 *
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:28:21
	 */
	public String getDiscountable_amount() {
		return discountable_amount;
	}

	/**
	 * 可打折金额
	 * <p>
	 * 参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]。<br>
	 * 如果该值未传入，但传入了【订单总金额】和 【不可打折金额】，则该值默认为【订单总金额】-【不可打折金额】
	 *
	 * @param discountable_amount
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:28:25
	 */
	public void setDiscountable_amount(String discountable_amount) {
		this.discountable_amount = discountable_amount;
	}

	/**
	 * 不可打折金额
	 * <p>
	 * 不参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]。<br>
	 * 如果该值未传入，但传入了【订单总金额】 和【可打折金额】，则该值默认为【订单总金额】-【可打折金额】
	 *
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:28:44
	 */
	public String getUndiscountable_amount() {
		return undiscountable_amount;
	}

	/**
	 * 不可打折金额
	 * <p>
	 * 不参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]。<br>
	 * 如果该值未传入，但传入了【订单总金额】 和【可打折金额】，则该值默认为【订单总金额】-【可打折金额】
	 *
	 * @param undiscountable_amount
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:28:48
	 */
	public void setUndiscountable_amount(String undiscountable_amount) {
		this.undiscountable_amount = undiscountable_amount;
	}

	/**
	 * 订单标题*
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:36:38
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * 订单标题*
	 * <p>
	 * 
	 * @param subject
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:36:43
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * 订单描述
	 * <p>
	 * 对交易或商品的描述
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:55:35
	 */
	public String getBody() {
		return body;
	}

	/**
	 * 订单描述
	 * <p>
	 * 对交易或商品的描述
	 * 
	 * @param body
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:55:39
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * 商品明细列表
	 * <p>
	 * 订单包含的商品列表信息，Json格式，其它说明详见商品明细说明
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:55:53
	 */
	public List<GoodsDetail> getGoods_detail() {
		return goods_detail;
	}

	/**
	 * 商品明细列表
	 * <p>
	 * 订单包含的商品列表信息，Json格式，其它说明详见商品明细说明
	 * 
	 * @param goods_detail
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:55:57
	 */
	public void setGoods_detail(List<GoodsDetail> goods_detail) {
		this.goods_detail = goods_detail;
	}

	/**
	 * 商户操作员编号
	 * <p>
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:56:10
	 */
	public String getOperator_id() {
		return operator_id;
	}

	/**
	 * 商户操作员编号
	 * <p>
	 * 
	 * @param operator_id
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:56:17
	 */
	public void setOperator_id(String operator_id) {
		this.operator_id = operator_id;
	}

	/**
	 * 商户门店编号
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:56:40
	 */
	public String getStore_id() {
		return store_id;
	}

	/**
	 * 商户门店编号
	 * 
	 * @param store_id
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:56:47
	 */
	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}

	/**
	 * 机具终端编号
	 * <p>
	 * 商户机具终端编号
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:56:58
	 */
	public String getTerminal_id() {
		return terminal_id;
	}

	/**
	 * 机具终端编号
	 * <p>
	 * 商户机具终端编号
	 * 
	 * @param terminal_id
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:57:03
	 */
	public void setTerminal_id(String terminal_id) {
		this.terminal_id = terminal_id;
	}

	/**
	 * 扩展参数
	 * <p>
	 * 业务扩展参数，sys_service_provider_id：系统商编号
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:57:16
	 */
	public ExtendParams getExtend_params() {
		return extend_params;
	}

	/**
	 * 扩展参数
	 * <p>
	 * 业务扩展参数，sys_service_provider_id：系统商编号
	 * 
	 * @param extend_params
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:57:22
	 */
	public void setExtend_params(ExtendParams extend_params) {
		this.extend_params = extend_params;
	}

	/**
	 * 支付超时时间
	 * <p>
	 * 该笔订单允许的最晚付款时间，逾期将关闭交易。格式为：yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:57:35
	 */
	public String getTime_expire() {
		return time_expire;
	}

	/**
	 * 支付超时时间
	 * <p>
	 * 该笔订单允许的最晚付款时间，逾期将关闭交易。格式为：yyyy-MM-dd HH:mm:ss
	 * 
	 * @param time_expire
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:57:40
	 */
	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}

	/**
	 * 分账信息
	 * <p>
	 * 描述分账信息，Json格式，其它说明详见分账说明
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:57:53
	 */
	public RoyaltyInfo getRoyalty_info() {
		return royalty_info;
	}

	/**
	 * 分账信息
	 * <p>
	 * 描述分账信息，Json格式，其它说明详见分账说明
	 * 
	 * @param royalty_info
	 * @author Yujinshui
	 * @time 2015年11月10日 下午12:57:58
	 */
	public void setRoyalty_info(RoyaltyInfo royalty_info) {
		this.royalty_info = royalty_info;
	}

}

/**********************************************************/
/**
 * 业务扩展参数，sys_service_provider_id：系统商编号<br>
 * demo:{“sys_service_provider_id”:“ 2088511833207846”}
 * 
 * @author Yujinshui
 *
 */
class ExtendParams {
	/**
	 * 系统商编号
	 */
	private String sys_service_provider_id;

	public String getSys_service_provider_id() {
		return sys_service_provider_id;
	}

	public void setSys_service_provider_id(String sys_service_provider_id) {
		this.sys_service_provider_id = sys_service_provider_id;
	}
}