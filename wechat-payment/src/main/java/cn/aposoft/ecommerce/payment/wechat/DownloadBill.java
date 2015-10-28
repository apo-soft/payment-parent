/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat;

import java.util.Date;

/**
 * 下载对账单查询参数接口
 * 
 * <pre>
  	<xml>
	  <appid>wx2421b1c4370ec43b</appid>
	  <bill_date>20141110</bill_date>
	  <bill_type>ALL</bill_type>
	  <mch_id>10000100</mch_id>
	  <nonce_str>21df7dc9cd8616b56919f20d9f679233</nonce_str>
	  <sign>332F17B766FC787203EBE9D6E40457A1</sign>
	</xml>
 * </pre>
 * 
 * @author Jann Liu
 *
 */
public interface DownloadBill {
	/**
	 * 对账单日期 bill_date 是 String(8) 20140603 下载对账单的日期，格式：20140603
	 * 
	 * @return 账单日期
	 */
	String getBill_date();

	/**
	 * 账单类型 bill_type 否 String(8) ALL
	 * 
	 * ALL，返回当日所有订单信息，默认值
	 * 
	 * SUCCESS，返回当日成功支付的订单
	 * 
	 * REFUND，返回当日退款订单
	 * 
	 * REVOKED，已撤销的订单
	 * 
	 * @return 对账单的类型
	 */
	String getBill_type();

	/**
	 * 设备号 device_info 否 String(32) 013467007045764
	 * 微信支付分配的终端设备号，填写此字段，只下载该设备号的对账单
	 * 
	 * @return 商户定义的设备号
	 */
	String getDevice_info();
}
