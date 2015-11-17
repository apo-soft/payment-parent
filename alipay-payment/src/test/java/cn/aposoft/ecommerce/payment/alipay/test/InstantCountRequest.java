package cn.aposoft.ecommerce.payment.alipay.test;

import java.math.BigDecimal;

import cn.aposoft.ecommerce.payment.alipay.Order;

/**
 * 
 * @author Yujinshui
 *
 */
public class InstantCountRequest implements Order {

	/**
	 * 
	 */
	private String service;
	/**
	 * 
	 */
	private String partner;
	/**
	 * 
	 */
	private String _input_charset;
	/**
	 * 
	 */
	private String sign_type;
	/**
	 * 
	 */
	private String sign;
	/**
	 * 
	 */
	private String notify_url;
	/**
	 * 
	 */
	private String alipay_ca_request;
	/**
	 * 
	 */
	private String out_trade_no;
	/**
	 * 
	 */
	private String subject;
	/**
	 * 
	 */
	private String product_code;
	/**
	 * 
	 */
	private BigDecimal total_fee;
	/**
	 * 
	 */
	private String seller_id;
	/**
	 * 
	 */
	private String seller_email;
	/**
	 * 
	 */
	private String operator_code;
	/**
	 * 
	 */
	private String operator_id;
	/**
	 * 
	 */
	private String body;
	/**
	 * 
	 */
	private String show_url;
	/**
	 * 
	 */
	private String currency;
	/**
	 * 
	 */
	private BigDecimal price;
	/**
	 * 
	 */
	private String quantity;
	/**
	 * 
	 */
	private String goods_detail;
	/**
	 * 
	 */
	private String extend_params;
	/**
	 * 
	 */
	private String it_b_pay;
	/**
	 * 
	 */
	private String royalty_type;
	/**
	 * 
	 */
	private String royalty_parameters;
	/**
	 * 
	 */
	private String channel_parameters;

	@Override
	public String getService() {

		return service;
	}

	@Override
	public String getPartner() {
		return partner;
	}

	@Override
	public String get_input_charset() {
		return _input_charset;
	}

	@Override
	public String getSign_type() {
		return sign_type;
	}

	@Override
	public String getSign() {
		return sign;
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

	public void setService(String service) {
		this.service = service;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public void set_input_charset(String _input_charset) {
		this._input_charset = _input_charset;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public void setAlipay_ca_request(String alipay_ca_request) {
		this.alipay_ca_request = alipay_ca_request;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public void setTotal_fee(BigDecimal total_fee) {
		this.total_fee = total_fee;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}

	public void setOperator_code(String operator_code) {
		this.operator_code = operator_code;
	}

	public void setOperator_id(String operator_id) {
		this.operator_id = operator_id;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setShow_url(String show_url) {
		this.show_url = show_url;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public void setGoods_detail(String goods_detail) {
		this.goods_detail = goods_detail;
	}

	public void setExtend_params(String extend_params) {
		this.extend_params = extend_params;
	}

	public void setIt_b_pay(String it_b_pay) {
		this.it_b_pay = it_b_pay;
	}

	public void setRoyalty_type(String royalty_type) {
		this.royalty_type = royalty_type;
	}

	public void setRoyalty_parameters(String royalty_parameters) {
		this.royalty_parameters = royalty_parameters;
	}

	public void setChannel_parameters(String channel_parameters) {
		this.channel_parameters = channel_parameters;
	}

}
