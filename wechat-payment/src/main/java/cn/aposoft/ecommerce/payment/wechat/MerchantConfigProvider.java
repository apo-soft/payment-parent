/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat;

/**
 * 根据提供的订单信息,来确定商户的config信息
 * 
 * @author Jann Liu
 *
 */
public interface MerchantConfigProvider {
	/**
	 * 根据订单预付款接口读取订单商户配置
	 * 
	 * @param order
	 *            订单预付款传输对象
	 * @return 商户信息配置
	 */
	Config getConfig(Order order);

	/**
	 * 根据订单预付款接口读取订单商户配置
	 * 
	 * @param refund
	 *            退款请求信息
	 * @return 商户信息配置
	 */
	Config getConfig(Refund refund);

	/**
	 * 根据订单预付款接口读取订单商户配置
	 * 
	 * @param queryParams
	 *            订单查询条件参数对象
	 * @return 商户信息配置
	 */
	Config getConfig(OrderQuery queryParams);

	/**
	 * 根据订单预付款接口读取订单商户配置
	 * 
	 * @param params
	 *            关闭订单参数对象
	 * @return 商户信息配置
	 */
	Config getConfig(CloseOrder params);

	/**
	 * 根据订单预付款接口读取订单商户配置
	 * 
	 * @param params
	 *            退款查询参数对象
	 * @return 商户信息配置
	 */
	Config getConfig(RefundQuery params);

	/**
	 * 根据订单预付款接口读取订单商户配置
	 * 
	 * @param params
	 *            对账单查询参数
	 * @return 商户信息配置
	 */
	Config getConfig(DownloadBill params);
}
