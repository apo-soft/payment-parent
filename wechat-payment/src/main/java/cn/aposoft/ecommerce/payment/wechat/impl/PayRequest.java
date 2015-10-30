/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.impl;

/**
 * 统一下单提交订单HTTP请求传输对象
 * 
 * <pre>
<xml>
   <appid>wx2421b1c4370ec43b</appid>
   <attach>支付测试</attach>
   <body>JSAPI支付测试</body>
   <mch_id>10000100</mch_id>
   <nonce_str>1add1a30ac87aa2db72f57a2375d8fec</nonce_str>
   <notify_url>http://wxpay.weixin.qq.com/pub_v2/pay/notify.v2.php</notify_url>
   <openid>oUpF8uMuAJO_M2pxb1Q9zNjWeS6o</openid>
   <out_trade_no>1415659990</out_trade_no>
   <spbill_create_ip>14.23.150.211</spbill_create_ip>
   <total_fee>1</total_fee>
   <trade_type>JSAPI</trade_type>
   <sign>0CB01533B8C1EF103065174F50BCA001</sign>
</xml>
 * </pre>
 * 
 * @author LiuJian
 *
 */
public class PayRequest extends RequestBase {
	/**
	 * 商品描述 body 是 String(32) Ipad mini 16G 白色 商品或支付单简要描述
	 */
	private String body; // 商品描述
	/**
	 * 商品详情 detail 否 String(8192) Ipad mini 16G 白色 商品名称明细列表
	 */
	private String detail; // 商品详情
	/**
	 * 附加数据 attach 否 String(127) 深圳分店 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
	 */
	private String attach; // 附加数据
	// private String out_trade_no; // 商户订单号- // base
	/**
	 * 货币类型 fee_type 否 String(16) CNY 符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
	 */
	private String fee_type; // 货币类型
	/**
	 * 总金额 total_fee 是 Int 888 订单总金额，单位为分，详见支付金额
	 */
	private Integer total_fee; // 总金额-
	/**
	 * 终端IP spbill_create_ip 是 String(16) 123.12.12.123
	 * APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
	 */
	private String spbill_create_ip; // 终端IP
	/**
	 * 交易起始时间 time_start 否 String(14) 20091225091010
	 * 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
	 */
	private String time_start; // 交易起始时间
	/**
	 * 交易结束时间 time_expire 否 String(14) 20091227091010
	 * 
	 * 订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。其他详见时间规则
	 * <span style="color:red;">注意：最短失效时间间隔必须大于5分钟</span>
	 */
	private String time_expire; // 交易结束时间
	/**
	 * 商品标记 goods_tag 否 String(32) WXG 商品标记，代金券或立减优惠功能的参数，说明详见代金券或立减优惠
	 */
	private String goods_tag; // 商品标记
	/**
	 * 通知地址 notify_url 是 String(256) http://www.weixin.qq.com/wxpay/pay.php
	 * 接收微信支付异步通知回调地址
	 */
	private String notify_url; // 通知地址
	/**
	 * 交易类型 trade_type 是 String(16) JSAPI 取值如下：JSAPI，NATIVE，APP，详细说明见参数规定
	 * {@link https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_2}
	 */
	private String trade_type; // 交易类型
	/**
	 * 商品ID product_id 否 String(32) 12235413214070356458058
	 * trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
	 */
	private String product_id; // 商品ID

	/**
	 * 指定支付方式 limit_pay 否 String(32) no_credit no_credit--指定不能使用信用卡支付
	 */
	private String limit_pay;

	/**
	 * 用户标识 openid 否 String(128) oUpF8uMuAJO_M2pxb1Q9zNjWeS6o
	 * trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。openid如何获取，可参考【获取openid】。企业号请使用【
	 * 企业号OAuth2.0接口】获取企业号内成员userid，再调用【企业号userid转openid接口】进行转换
	 */
	private String openid; // 用户标识

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
	public Integer getTotal_fee() {
		return total_fee;
	}

	/**
	 * 
	 * @param total_fee
	 */
	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
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

	public String getLimit_pay() {
		return limit_pay;
	}

	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}

	/**
	 * 
	 * @return
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * 
	 * @param openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

}
