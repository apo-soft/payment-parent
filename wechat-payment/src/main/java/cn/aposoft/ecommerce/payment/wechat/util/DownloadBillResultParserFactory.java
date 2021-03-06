/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.util;

import cn.aposoft.ecommerce.payment.wechat.DownloadBillResultParser;
import cn.aposoft.ecommerce.payment.wechat.impl.DownloadBillResultParserImpl;

/**
 * 对账单解析器实现工厂
 * 
 * @author Jann Liu
 *
 */
public class DownloadBillResultParserFactory {

	private static DownloadBillResultParser parser = new DownloadBillResultParserImpl();

	/**
	 * 返回对账单解析器的实现
	 * 
	 * @return
	 */
	public static DownloadBillResultParser getParser() {
		return parser;
	}
}
