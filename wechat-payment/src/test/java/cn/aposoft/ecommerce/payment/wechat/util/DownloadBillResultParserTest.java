/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.util;

import java.util.Arrays;

import org.junit.Test;

import cn.aposoft.ecommerce.payment.wechat.DownloadBillResult;
import cn.aposoft.ecommerce.payment.wechat.DownloadBillResultParser;
import cn.aposoft.ecommerce.payment.wechat.impl.DownloadBillResponse;

/**
 * @author Jann Liu
 *
 */
public abstract class DownloadBillResultParserTest {

	/**
	 * 获取对账单解析器的实现
	 * 
	 * @return 对账单解析类对象实例
	 */
	protected abstract DownloadBillResultParser getParser();

	/**
	 * 读取对账单的测试用报文
	 * 
	 * @return 对账单报文
	 */
	protected abstract String getTestText();

	/**
	 * 对对账单进行验证操作
	 * 
	 * @param result
	 *            待验证的解析结果
	 */
	protected abstract void validate(DownloadBillResult result);

	@Test
	public void testParse() {
		DownloadBillResult result = parse(getTestText());
		validate(result);
	}

	// 执行对账单解析操作
	protected final DownloadBillResult parse(String rawText) {
		return getParser().parse(rawText);
	}

	public static void print(DownloadBillResponse downloadBills) {
		System.out.println("=========================================================");
		System.out.println("Downloadbill Contents: \r\n    Raw Text: ");

		System.out.println(downloadBills.getData());
		System.out.println("    Split Result: ");
		System.out.println(downloadBills.getHeaders());
		for (String[] billItem : downloadBills.getBillItems()) {
			System.out.println(Arrays.toString(billItem));
		}
		System.out.println(downloadBills.getTotalHeaders());
		System.out.println(downloadBills.getTotalItems());
		System.out.println("=========================================================");
	}

	public static void print(DownloadBillResult downloadBills) {
		System.out.println("=========================================================");
		System.out.println("Downloadbill Contents: \r\n    Raw Text: ");
		System.out.println("    Split Result: ");
		System.out.println(downloadBills.getHeaders());
		for (String[] billItem : downloadBills.getBillItems()) {
			System.out.println(Arrays.toString(billItem));
		}
		System.out.println(downloadBills.getTotalHeaders());
		System.out.println(downloadBills.getTotalItems());
		System.out.println("=========================================================");
	}
}
