/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.impl;

import cn.aposoft.ecommerce.payment.wechat.CloseOrder;
import cn.aposoft.ecommerce.payment.wechat.Config;
import cn.aposoft.ecommerce.payment.wechat.DownloadBill;
import cn.aposoft.ecommerce.payment.wechat.MerchantConfigProvider;
import cn.aposoft.ecommerce.payment.wechat.Order;
import cn.aposoft.ecommerce.payment.wechat.OrderQuery;
import cn.aposoft.ecommerce.payment.wechat.Refund;
import cn.aposoft.ecommerce.payment.wechat.RefundQuery;

/**
 * 用于实现多商户情况下的配置提供方式, 此方法仅提供直接返回单一商户信息的默认实现.<br/>
 * 具体的多商户实现,由开发人员根据本项目实际情况进行扩展
 * 
 * 比如,可以在每个方法的入参上添加统一的商户识别接口,进行定制化开发等
 * 
 * @author Jann Liu
 *
 */
public class MerchantConfigProviderImpl implements MerchantConfigProvider {
	private static final Config config = new PropertiesConfig();

	@Override
	public Config getConfig(Order order) {
		return config;
	}

	@Override
	public Config getConfig(Refund refund) {
		return config;
	}

	@Override
	public Config getConfig(OrderQuery queryParams) {
		return config;
	}

	@Override
	public Config getConfig(CloseOrder params) {
		return config;
	}

	@Override
	public Config getConfig(RefundQuery params) {
		return config;
	}

	@Override
	public Config getConfig(DownloadBill params) {
		return config;
	}

}
