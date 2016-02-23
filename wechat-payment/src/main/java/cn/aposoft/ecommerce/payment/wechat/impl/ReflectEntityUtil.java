/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.impl;

import org.apache.log4j.Logger;

import cn.aposoft.ecommerce.payment.wechat.EntityUtil;
import cn.aposoft.ecommerce.payment.wechat.util.Signature;
import cn.aposoft.ecommerce.payment.wechat.util.XMLUtil;

/**
 * 实现实体到xml转换,签名的工具类实现 {@code ReflectEntityUtil} <br/>
 * 主要通过反射的方式完成对bean对象的读取
 * 
 * 本方法强制要求 传入的对方符合 fieldName 与危险要求的入参xml编码名一致
 * 
 * <p>
 * 完成进度: <br/>
 * 1. 预支付完成<br/>
 * 2. 退款查询响应完成 <br/>
 * 3. 退款查询完成<br/>
 * </p>
 * 
 * @see EntityUtil
 * @author Jann Liu
 *
 */
public class ReflectEntityUtil extends AbstractEntityUtil implements EntityUtil {
	private static final Logger logger = Logger.getLogger(ReflectEntityUtil.class);
	private static final EntityUtil instance = new ReflectEntityUtil();

	/**
	 * 根据微信算法对待发送的请求对象进行签名
	 * 
	 * @param obj
	 *            待签名对象
	 * @param key
	 *            签名key
	 * @return 签名字符串
	 */
	private static final String getSign(Object obj, String key) {
		try {
			return Signature.getSign(obj, key);
		} catch (IllegalAccessException e) {
			logger.error("sign for payRequest meets error.", e);
			return null;
		}
	}

	/**
	 * 将传入对象转换为微信请求发送的xml字符串
	 * 
	 * @param obj
	 *            待返回的对象
	 * @return 请求的xml字符串
	 */
	private static final String getRequestXml(Object obj) {
		try {
			return XMLUtil.createXML(obj);
		} catch (IllegalAccessException e) {
			// this should never happen
			return null;
		}
	}

	/**
	 * 获取实体Util对象实例
	 * 
	 * @return {@code EntityUtil} 实例
	 */
	public static EntityUtil getInstance() {
		return instance;
	}

	// 创建支付请求的xml字符串
	@Override
	protected String generatePayXml(PayRequest values) {
		return getRequestXml(values);
	}

	// 支付签名
	@Override
	protected String createPaySign(PayRequest request, String key) {
		return getSign(request, key);
	}

	// 退款查询签名
	@Override
	protected String createRefundQueryRequestSign(RefundQueryRequest request, String key) {
		return getSign(request, key);
	}

	/**
	 * 微信退款查询请求对象转换,仅供内部使用
	 * 
	 * @param values
	 *            退款查询请求对象
	 * @return 退款查询请求xml文本
	 */
	@Override
	public String createRefundQueryRequestXml(RefundQueryRequest values) {
		return getRequestXml(values);
	}

	@Override
	public String generateRefundXml(RefundRequest values) {
		return getRequestXml(values);
	}

	@Override
	protected String createRefundSign(RefundRequest payRefund, String key) {
		return getSign(payRefund, key);
	}

	@Override
	public String generateOrderQueryXml(OrderQueryRequest values) {
		return getRequestXml(values);
	}

	@Override
	protected String createOrderQuerySign(OrderQueryRequest values, String key) {
		return getSign(values, key);
	}

	@Override
	public String generateCloseOrderXml(CloseOrderRequest values) {
		return getRequestXml(values);
	}

	@Override
	protected String createCloseOrderSign(CloseOrderRequest request, String key) {
		return getSign(request, key);
	}

	@Override
	public String generateDownloadBillXml(DownloadBillRequest values) {
		return getRequestXml(values);
	}

	@Override
	protected String createDownloadBillSign(DownloadBillRequest request, String key) {
		return getSign(request, key);
	}
}
