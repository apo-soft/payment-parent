/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.impl;

import java.util.Map;

import cn.aposoft.ecommerce.payment.wechat.Config;
import cn.aposoft.ecommerce.payment.wechat.PaymentService;

/**
 * 付款接口启用
 * 
 * @author Yujinshui
 *
 */
public class PaymentServiceFactory {
	/**
	 * 1.通过读取默认配置文件（wechatpay.properties）进行读取
	 * 
	 * @author Jann Liu
	 */
	public PaymentService getService() {
		PaymentService service = new PaymentServiceImpl(new PropertiesConfig(), SingletonHttpClientUtil.getInstance(),
				SimpleEntityUtil.getInstance());
		return service;
	}

	/**
	 * 2.从数据库方式进行配置文件的配置
	 * 
	 * @param map
	 * @return
	 * @author Yujinshui
	 */
	public PaymentService getService(Map<String, String> map) {
		PaymentService service = new PaymentServiceImpl(new PropertiesConfig(map),
				SingletonHttpClientUtil.getInstance(), SimpleEntityUtil.getInstance());
		return service;
	}

	/**
	 * 3.从数据库方式进行配置文件的配置[将config已经完成初始化]
	 * 
	 * @param config
	 *            支付配置参数bean
	 * @return
	 * @author Yujinshui
	 * @time 2015年12月6日 下午3:05:32
	 */
	public PaymentService getService(Config config) {
		PaymentService service = new PaymentServiceImpl(config, SingletonHttpClientUtil.getInstance(),
				SimpleEntityUtil.getInstance());
		return service;
	}

}
