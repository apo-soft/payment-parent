/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.impl;

import cn.aposoft.ecommerce.payment.wechat.EntityUtil;

/**
 * EntityUtil工厂方法
 * 
 * @author Jann Liu
 *
 */
public class EntityUtilFactory {
	public static final EntityUtil getInstance() {
		return new ReflectEntityUtil();
	}
}
