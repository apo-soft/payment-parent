/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat;

/**
 * @author Jann Liu
 *
 */
public class MerchantIdConfigProviderImpl implements MerchantConfigProvider {

	/**
	 * TODO 实现通过merchantId读取商户的支付配置信息
	 * 
	 * @param merchantId
	 * @return
	 */
	private Config getConfigMerchantId(String merchantId) {

		return null;
	}

	private Config getConfigByMerchantId(Object o) {
		if (o instanceof MerchantIdProvider) {
			MerchantIdProvider idp = (MerchantIdProvider) o;
			return getConfigMerchantId(idp.getMerchantId());
		}
		throw new IllegalArgumentException(
				"order must be instance of type cn.aposoft.ecommerce.payment.wechat.MerchantIdProvider");
	}

	@Override
	public Config getConfig(Order order) {
		return getConfigByMerchantId(order);
	}

	@Override
	public Config getConfig(Refund refund) {
		return getConfigByMerchantId(refund);
	}

	@Override
	public Config getConfig(OrderQuery queryParams) {
		return getConfigByMerchantId(queryParams);
	}

	@Override
	public Config getConfig(CloseOrder params) {
		return getConfigByMerchantId(params);
	}

	@Override
	public Config getConfig(RefundQuery params) {
		return getConfigByMerchantId(params);
	}

	@Override
	public Config getConfig(DownloadBill params) {
		return getConfigByMerchantId(params);
	}

}
