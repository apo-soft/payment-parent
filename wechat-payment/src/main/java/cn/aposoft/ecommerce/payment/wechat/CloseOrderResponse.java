/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat;

/**
 * 关闭订单响应对象
 * 
 * <pre>
  <xml>
   <return_code><![CDATA[SUCCESS]]></return_code>
   <return_msg><![CDATA[OK]]></return_msg>
   <appid><![CDATA[wx2421b1c4370ec43b]]></appid>
   <mch_id><![CDATA[10000100]]></mch_id>
   <nonce_str><![CDATA[BFK89FC6rxKCOjLX]]></nonce_str>
   <sign><![CDATA[72B321D92A7BFA0B2509F3D13C7B1631]]></sign>
   <result_code><![CDATA[SUCCESS]]></result_code>
</xml>
 * 错误码
 * <ul>
		<li>名称 	描述 	原因 	解决方案</li>
		<li>ORDERPAID 	订单已支付 	订单已支付，不能发起关单 	订单已支付，不能发起关单，请当作已支付的正常交易</li>
		<li>SYSTEMERROR 	系统错误 	系统错误 	系统异常，请重新调用该API</li>
		<li>ORDERNOTEXIST 	订单不存在 	订单系统不存在此订单 	不需要关单，当作未提交的支付的订单</li>
		<li>ORDERCLOSED 	订单已关闭 	订单已关闭，无法重复关闭 	订单已关闭，无需继续调用</li>
		<li>SIGNERROR 	签名错误 	参数签名结果不正确 	请检查签名参数和方法是否都符合签名算法要求</li>
		<li>REQUIRE_POST_METHOD 	请使用post方法 	未使用post传递参数  	请检查请求参数是否通过post方法提交</li>
		<li>XML_FORMAT_ERROR 	XML格式错误 	XML格式错误 	请检查XML参数格式是否正确</li>
 * </ul>
 * 
 * </pre>
 * 
 * @author Jann Liu
 *
 */
public class CloseOrderResponse extends ResponseBase {
	private static final long serialVersionUID = 1893308750908312914L;
	// Attention
	// 在Base中不存在以下返回字段:
	// 1. device_info

}
