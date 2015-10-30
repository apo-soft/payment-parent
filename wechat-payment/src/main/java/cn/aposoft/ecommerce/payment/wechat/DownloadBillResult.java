/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat;

import java.util.List;

/**
 * 对账单下载报文拆分后结果
 * 
 * @author Jann Liu
 *
 */
public interface DownloadBillResult {

	/**
	 * @return the headers
	 */
	public List<String> getHeaders();

	/**
	 * @return the totalHeaders
	 */
	public List<String> getTotalHeaders();

	/**
	 * @return the totalItems
	 */
	public List<String> getTotalItems();

	/**
	 * @return the billItems
	 */
	public List<String[]> getBillItems();

}
