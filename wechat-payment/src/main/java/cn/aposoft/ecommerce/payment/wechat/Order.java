package cn.aposoft.ecommerce.payment.wechat;

/**
 * 订单信息[完成]<br>
 * 
 * 
 * @author LiuJian
 *
 */
public interface Order {

	/**
	 * 设备号 device_info 否 String(32) 013467007045764 终端设备号(门店号或收银设备ID)，
	 * <p>
	 * <span style="color:red;">注意：PC网页或公众号内支付请传"WEB" </span>
	 * 
	 * @return 设备号: 网页端或公众号内: "WEB"
	 */
	String getDevice_info();

	/**
	 * <font color=red>必需</font>
	 * <p>
	 * 商品描述 body 是 String(32) Ipad mini 16G 白色 商品或支付单简要描述
	 * 
	 * @return
	 */
	String getBody();

	/**
	 * 商品详情 detail 否 String(8192) Ipad mini 16G 白色 商品名称明细列表
	 * 
	 * @return 商品详情
	 */
	String getDetail();

	/**
	 * 附加说明
	 * 
	 * @return
	 */
	String getAttach();

	/**
	 * <font color=red>必需</font>
	 * <p>
	 * 商户订单号 out_trade_no 是 String(32) 20150806125346 商户系统内部的订单号,32个字符内、可包含字母,
	 * 其他说明见商户订单号
	 * {@link https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_2}
	 * 
	 * @return 商户订单号信息
	 */
	String getOut_trade_no();

	/**
	 * 货币类型 fee_type 否 String(16) CNY 符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
	 * {@link https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_2}
	 * 
	 * @return 货币类型(CNY)
	 */
	String getFee_type();

	/**
	 * <font color=red>必需</font>- 总金额 total_fee 是 Int 888 订单总金额，
	 * <span style="color:red;">单位为分</span>，详见支付金额
	 * {@link https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_2}
	 * 
	 * @return 总金额(分)
	 */
	Integer getTotal_fee();

	/**
	 * <font color=red>必需</font>
	 * <p>
	 * 终端IP spbill_create_ip 是 String(16) 123.12.12.123
	 * APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
	 * 
	 * @return
	 */
	String getSpbill_create_ip();

	/**
	 * 交易起始时间 time_start 否 String(14) 20091225091010
	 * 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
	 * 
	 * @return
	 */
	String getTime_start();

	/**
	 * 交易结束时间 time_expire 否 String(14) 20091227091010
	 * 
	 * 订单失效时间，格式为yyyyMMddHHmmss，
	 * <span style="color:">如2009年12月27日9点10分10秒表示为20091227091010</span>。
	 * 其他详见时间规则 注意：最短失效时间间隔必须大于5分钟
	 * 
	 * @return
	 */
	String getTime_expire();

	/**
	 * 
	 * 商品标记 goods_tag 否 String(32) WXG 商品标记，代金券或立减优惠功能的参数，说明详见代金券或立减优惠
	 * <p>
	 * {@link https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_7}
	 * 
	 * <pre>
	 * 代金券或立减优惠金额 coupon_fee 否 Int 10
	 * 代金券或立减优惠金额<=订单总金额，订单总金额-代金券或立减优惠金额=现金支付金额，详见支付金额
	 * </pre>
	 * 
	 * @return
	 */
	String getGoods_tag();

	/**
	 * 通知地址 notify_url 是 String(256) http://www.weixin.qq.com/wxpay/pay.php
	 * 接收微信支付异步通知回调地址
	 * <p>
	 * 详见: 支付结果通用通知
	 * {@link https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_7}
	 * 
	 * @return 支付成功结果通知地址
	 * @author Yujinshui
	 */
	String getNotify_url();

	/**
	 * <font color=red>必需</font>
	 * <p>
	 * 交易类型 trade_type 是 String(16) JSAPI 取值如下：JSAPI，NATIVE，APP，详细说明见参数规定
	 * 
	 * @return 交易类型
	 */
	String getTrade_type();

	/**
	 * 商品ID product_id 否 String(32) 12235413214070356458058
	 * trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
	 * 
	 * @return 商品ID
	 */
	String getProduct_id();

	/**
	 * 指定支付方式 limit_pay 否 String(32) no_credit
	 * <span style="color:red;">no_credit--指定不能使用信用卡支付</span>
	 * 
	 * @return 指定支付方式
	 */
	String getLimit_pay();
}
