/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.impl;

import cn.aposoft.ecommerce.payment.wechat.EntityUtil;
import cn.aposoft.ecommerce.payment.wechat.impl.EntityUtilFactory;
import cn.aposoft.ecommerce.payment.wechat.util.EntityUtilTest;

/**
 * @author Jann Liu
 *
 */
public class ReflectEntityUtilTest extends EntityUtilTest {

	private static final EntityUtil util = EntityUtilFactory.getInstance();

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.util.EntityUtilTest#getUtil()
	 */
	@Override
	protected EntityUtil getUtil() {
		return util;
	}

}
