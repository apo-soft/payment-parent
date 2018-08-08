package cn.aposoft.ecommerce.wechat.scan.beans.protocol.notify_protocol;

/**
 * @author xu.han
 * @ClassName: TradeResultNotify
 * @date 16/4/10 下午9:10
 */
public class TradeResultNotify {

	//协议层

	/**
	 * SUCCESS/FAIL
	 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
	 */
	private String return_code ;
	private String return_msg ;

	//协议返回的具体数据（以下字段在return_code 为SUCCESS 的时候有返回）

	/**
	 * 微信开放平台审核通过的应用APPID
	 */
	private String appid ;

	/**
	 * 微信支付分配的商户号
	 */
	private String mch_id ;
	/**
	 * 微信支付分配的终端设备号
	 */
	private String device_info ;
	/**
	 * 随机字符串，不长于32位
	 */
	private String nonce_str;

	/**
	 * 随机字符串，不长于32位
	 */
	private String sign;
	/**
	 * SUCCESS/FAIL
	 */
	private String result_code;
	/**
	 * 错误返回的信息描述
	 */
	private String err_code;

	/**
	 * 错误返回的信息描述
	 */
	private String err_code_des ;
	/**
	 * 用户在商户appid下的唯一标识
	 */
	private String openid;
	/**
	 * 用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
	 */
	private String is_subscribe;
	/**
	 * APP
	 */
	private String trade_type;
	/**
	 * 银行类型，采用字符串类型的银行标识，银行类型见银行列表
	 */
	private String bank_type;
	/**
	 * 订单总金额，单位为分
	 */
	private int total_fee;
	/**
	 * 货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY
	 */
	private String fee_type;
	/**
	 * 现金支付金额订单现金支付金额
	 */
	private int cash_fee;
	/**
	 * 货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY
	 */
	private String cash_fee_type;
	/**
	 * 代金券或立减优惠金额<=订单总金额，订单总金额-代金券或立减优惠金额=现金支付金额
	 * 详见支付金额 https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=4_2
	 */
	private int coupon_fee;
	/**
	 * 代金券或立减优惠使用数量
	 */
	private int coupon_count;
	/**
	 * 微信支付订单号
	 */
	private String transaction_id;
	/**
	 * 商户系统的订单号，与请求一致。
	 */
	private String out_trade_no;
	/**
	 * 商家数据包，原样返回
	 */
	private String attach;
	/**
	 * 支付完成时间
	 * 格式 yyyyMMddHHmmss
	 */
	private String time_end;

	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public String getErr_code_des() {
		return err_code_des;
	}

	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getIs_subscribe() {
		return is_subscribe;
	}

	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getBank_type() {
		return bank_type;
	}

	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}

	public int getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public int getCash_fee() {
		return cash_fee;
	}

	public void setCash_fee(int cash_fee) {
		this.cash_fee = cash_fee;
	}

	public String getCash_fee_type() {
		return cash_fee_type;
	}

	public void setCash_fee_type(String cash_fee_type) {
		this.cash_fee_type = cash_fee_type;
	}

	public int getCoupon_fee() {
		return coupon_fee;
	}

	public void setCoupon_fee(int coupon_fee) {
		this.coupon_fee = coupon_fee;
	}

	public int getCoupon_count() {
		return coupon_count;
	}

	public void setCoupon_count(int coupon_count) {
		this.coupon_count = coupon_count;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getTime_end() {
		return time_end;
	}

	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}
}
