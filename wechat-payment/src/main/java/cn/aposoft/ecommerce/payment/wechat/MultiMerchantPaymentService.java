/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat;

/**
 * @author Jann Liu
 *
 */
public interface MultiMerchantPaymentService extends PaymentService {

	/**
	 * 用户设置多商户时,识别商户的appid,mch_id,key等信息的辅助策略类
	 * 
	 * @param provider
	 *            商户信息识别方法注入类
	 */
	void setMerchantConfigProvider(MerchantConfigProvider provider);
}
