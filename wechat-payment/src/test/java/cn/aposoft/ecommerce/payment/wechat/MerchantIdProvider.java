/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat;

/**
 * @author Jann Liu
 *
 */
public interface MerchantIdProvider {
	/**
	 * 返回商户的业务id
	 * 
	 * @return 商户业务id
	 */
	public String getMerchantId();

}
