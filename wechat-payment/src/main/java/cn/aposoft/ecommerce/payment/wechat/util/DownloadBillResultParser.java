/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.util;

import cn.aposoft.ecommerce.payment.wechat.DownloadBillResult;

/**
 * 对账单返回结果解析方法接口
 * 
 * @author Jann Liu
 *
 */
public interface DownloadBillResultParser {
	/**
	 * 将对账单原始报文解析为可处理格式
	 * 
	 * @param data
	 *            原始报文内容
	 * @return 对账单解析结果
	 */
	DownloadBillResult parse(String data);
}
