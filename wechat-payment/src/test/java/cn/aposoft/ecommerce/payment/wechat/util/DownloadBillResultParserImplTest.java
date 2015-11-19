/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import cn.aposoft.ecommerce.payment.wechat.DownloadBillResult;
import cn.aposoft.ecommerce.payment.wechat.DownloadBillResultParser;
import cn.aposoft.ecommerce.payment.wechat.impl.DownloadBillResultParserImpl;

/**
 * @author Jann Liu
 *
 */
public class DownloadBillResultParserImplTest extends DownloadBillResultParserTest {
	/**
	 * 返回默认实现
	 */
	@Override
	protected DownloadBillResultParser getParser() {
		return new DownloadBillResultParserImpl();
	}

	/**
	 * 返回classpath下的样例测试文件
	 */
	@Override
	protected String getTestText() {
		try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("downloadbill.txt");
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));) {
			StringBuilder builder = new StringBuilder();
			while (true) {
				String sarr = reader.readLine();
				if (sarr != null) {
					builder.append(sarr).append("\r\n");
				} else {
					break;
				}
			}
			return builder.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 针对样例文件执行验证
	 */
	@Override
	protected void validate(DownloadBillResult result) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DownloadBillResultParserImplTest tester = new DownloadBillResultParserImplTest();
		String rawText = tester.getTestText();

		DownloadBillResult result = tester.parse(rawText);
		DownloadBillResultParserTest.print(result);
	}
}
