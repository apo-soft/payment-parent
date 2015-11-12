package cn.aposoft.ecommerce.payment.alipay.vo;

import java.util.List;

import cn.aposoft.ecommerce.payment.alipay.vo.FundBillList;

/**
 * TODO 内容有待修正<br>
 * 响应结果
 * <p>
 * a.操作处理中响应结果<br>
 * b.操作成功时响应结果<br>
 * c.操作失败时响应结果<br>
 * 以下属性以abc标记用途
 * 
 * @author Yujinshui
 */
public class PayResponseUtil {

	/**
	 * [abc]返回编号*
	 */
	private String code;
	/**
	 * [abc]返回信息*
	 */
	private String msg;

	/**
	 * 
	 * [ab]支付宝交易号*
	 * <p>
	 * 支付宝交易凭证号
	 */
	private String trade_no;
	/**
	 * [ab]商户订单号*
	 * <p>
	 * 原支付请求的商户订单号
	 */
	private String out_trade_no;
	/**
	 * [ab]买家支付宝用户号*
	 * <p>
	 * 买家支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字
	 */
	private String buyer_user_id;
	/**
	 * [ab]买家支付宝账号*
	 * <p>
	 * 买家支付宝账号，将用*号屏蔽部分内容
	 */
	private String buyer_logon_id;
	/**
	 * [ab]交易金额*
	 * <p>
	 * 订单总金额，单位为元
	 */
	private double total_amount;
	/**
	 * [b]实收金额*
	 * <p>
	 * 商家在交易中实际收到的款项
	 */
	private double receipt_amount;
	/**
	 * [b]开票金额*
	 * <p>
	 * 用户在交易中支付的可开具发票的金额
	 */
	private double invoice_amount;
	/**
	 * [b]付款金额*
	 * <p>
	 * 用户在交易中支付的金额
	 */
	private double buyer_pay_amount;
	/**
	 * [b]积分宝金额*
	 * <p>
	 * 使用积分宝支付的金额
	 */
	private double point_amount;
	/**
	 * [b]付款时间*
	 * <p>
	 * 买家付款时间。 格式为 yyyy-MM-dd HH:mm:ss
	 */
	private String gmt_payment;
	/**
	 * [b]交易资金明细信息集合*
	 * <p>
	 * 本次交易使用的资金明细信息列表，包含多个渠道信息子节点 ，json格式。该节点包含的参数请参见资金明细信息说明
	 */
	private List<FundBillList> fund_bill_list;
	/**
	 * [b]门名名称
	 * <p>
	 * 交易发生所在门店的门店名称
	 *
	 */
	private String store_name;

	/**
	 * [c]失败编码
	 */
	private String sub_code;
	/**
	 * [c]失败描述
	 */
	private String sub_desc;

	/**
	 * [abc]签名
	 */
	private String sign;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getBuyer_user_id() {
		return buyer_user_id;
	}

	public void setBuyer_user_id(String buyer_user_id) {
		this.buyer_user_id = buyer_user_id;
	}

	public String getBuyer_logon_id() {
		return buyer_logon_id;
	}

	public void setBuyer_logon_id(String buyer_logon_id) {
		this.buyer_logon_id = buyer_logon_id;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	public double getReceipt_amount() {
		return receipt_amount;
	}

	public void setReceipt_amount(double receipt_amount) {
		this.receipt_amount = receipt_amount;
	}

	public double getInvoice_amount() {
		return invoice_amount;
	}

	public void setInvoice_amount(double invoice_amount) {
		this.invoice_amount = invoice_amount;
	}

	public double getBuyer_pay_amount() {
		return buyer_pay_amount;
	}

	public void setBuyer_pay_amount(double buyer_pay_amount) {
		this.buyer_pay_amount = buyer_pay_amount;
	}

	public double getPoint_amount() {
		return point_amount;
	}

	public void setPoint_amount(double point_amount) {
		this.point_amount = point_amount;
	}

	public String getGmt_payment() {
		return gmt_payment;
	}

	public void setGmt_payment(String gmt_payment) {
		this.gmt_payment = gmt_payment;
	}

	public List<FundBillList> getFund_bill_list() {
		return fund_bill_list;
	}

	public void setFund_bill_list(List<FundBillList> fund_bill_list) {
		this.fund_bill_list = fund_bill_list;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getSub_code() {
		return sub_code;
	}

	public void setSub_code(String sub_code) {
		this.sub_code = sub_code;
	}

	public String getSub_desc() {
		return sub_desc;
	}

	public void setSub_desc(String sub_desc) {
		this.sub_desc = sub_desc;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
