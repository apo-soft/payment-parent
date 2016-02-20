/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.impl;

import org.apache.log4j.Logger;

import cn.aposoft.ecommerce.payment.wechat.EntityUtil;
import cn.aposoft.ecommerce.payment.wechat.util.Signature;

/**
 * 使用反射的方法重构SimpleEntityUtil
 * <p>
 * TODO 待完成
 * </p>
 * 
 * @author Jann Liu
 *
 */
public class ReflectEntityUtil extends AbstractEntityUtil implements EntityUtil {
	private static final Logger logger = Logger.getLogger(ReflectEntityUtil.class);

	@Override
	protected String generatePayXml(PayRequest values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createPaySign(PayRequest payRequest, String key) {
		try {
			return Signature.getSign(payRequest, key);
		} catch (IllegalAccessException e) {
			logger.error("sign for payRequest meets error.", e);
			return null;
		}

	}

}
