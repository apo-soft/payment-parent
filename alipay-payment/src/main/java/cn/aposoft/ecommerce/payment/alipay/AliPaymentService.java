package cn.aposoft.ecommerce.payment.alipay;

import java.util.Map;

import cn.aposoft.ecommerce.payment.alipay.impl.AliPayResponse;
import cn.aposoft.ecommerce.payment.alipay.impl.AliRefundResponse;

/**
 * 主动向支付宝支付服务器发送各种订单业务相关请求
 * {@link http://doc.open.alipay.com/doc2/alipayDocIndex.htm}
 * 
 * @author Yujinshui
 *
 */
public interface AliPaymentService {
	/**
	 * 退款接口付款完成的交易进行部分或全部的退还。
	 * 
	 * @param refund
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月16日 下午12:12:49
	 */
	AliRefundResponse refund(AliRefund refund);

	/**
	 * 二维码支付 > 请求参数说明
	 * <p>
	 * 完成向微信支付服务器发送预处理订单并处理响应结果
	 * {@link http://doc.open.alipay.com/doc2/detail?spm=0.0.0.0.SYtTU9&treeId=62&articleId=103740&docType=1}
	 * 
	 * @param order
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月12日 下午6:45:16
	 */
	public AliPayResponse preparePay(AliOrder order);

	/**
	 * 即时到账 > 请求参数说明.返回Map类型。测试环境推荐
	 * <p>
	 * 完成向微信支付服务器发送预处理订单并处理响应结果
	 * {@link http://doc.open.alipay.com/doc2/detail?spm=0.0.0.0.SYtTU9&treeId=62&articleId=103740&docType=1}
	 * 
	 * @param order
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月12日 下午6:45:16
	 * @deprecated
	 */
	public Map<String, String> prepareMap(Map<String, String> params);

}
