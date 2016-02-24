package cn.aposoft.ecommerce.payment.wechat;

public class OrderVo implements Order, MerchantIdProvider {

	private String device_info; // 设备号-
	private String body; // 商品描述
	private String detail; // 商品详情
	private String attach; // 附加数据
	private String out_trade_no; // 商户订单号-
	private String fee_type; // 货币类型
	private Integer total_fee; // 总金额-
	private String spbill_create_ip; // 终端IP
	private String time_start; // 交易起始时间
	private String time_expire; // 交易结束时间
	private String goods_tag; // 商品标记
	private String notify_url; // 通知地址
	private String trade_type; // 交易类型
	private String product_id; // 商品ID
	private String limit_pay;

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public Integer getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

	/**
	 * 
	 * @return
	 */
	public String getBody() {
		return body;
	}

	/**
	 * 
	 * @param body
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * 
	 * @return
	 */
	public String getDetail() {
		return detail;
	}

	/**
	 * 
	 * @param detail
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

	/**
	 * 
	 * @return
	 */
	public String getAttach() {
		return attach;
	}

	/**
	 * 
	 * @param attach
	 */
	public void setAttach(String attach) {
		this.attach = attach;
	}

	/**
	 * 
	 * @return
	 */
	public String getFee_type() {
		return fee_type;
	}

	/**
	 * 
	 * @param fee_type
	 */
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	/**
	 * 
	 * @return
	 */
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	/**
	 * 
	 * @param spbill_create_ip
	 */
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	/**
	 * 
	 * @return
	 */
	public String getTime_start() {
		return time_start;
	}

	/**
	 * 
	 * @param time_start
	 */
	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	/**
	 * 
	 * @return
	 */
	public String getTime_expire() {
		return time_expire;
	}

	/**
	 * 
	 * @param time_expire
	 */
	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}

	/**
	 * 
	 * @return
	 */
	public String getGoods_tag() {
		return goods_tag;
	}

	/**
	 * 
	 * @param goods_tag
	 */
	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}

	/**
	 * 
	 * @return
	 */
	public String getNotify_url() {
		return notify_url;
	}

	/**
	 * 
	 * @param notify_url
	 */
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	/**
	 * 
	 * @return
	 */
	public String getTrade_type() {
		return trade_type;
	}

	/**
	 * 
	 * @param trade_type
	 */
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	/**
	 * 
	 * @return
	 */
	public String getProduct_id() {
		return product_id;
	}

	/**
	 * 
	 * @param product_id
	 */
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	@Override
	public String getLimit_pay() {
		return this.limit_pay;
	}

	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}

	private String merchantId;

	@Override
	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

}
