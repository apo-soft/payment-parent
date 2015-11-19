/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import cn.aposoft.ecommerce.payment.wechat.DownloadBillResult;
import cn.aposoft.ecommerce.payment.wechat.DownloadBillResultParser;

/**
 * @author Jann Liu
 *
 */
public class DownloadBillResultParserImpl implements DownloadBillResultParser {
	private static final Logger logger = Logger.getLogger(DownloadBillResultParserImpl.class);

	/**
	 * 解析对账单报文
	 */
	@Override
	public DownloadBillResult parse(String data) {
		DownloadBillResultImpl result = new DownloadBillResultImpl();
		String[] lines = splitRawText(data);
		int n = StateParserFactory.getParser().parse(0, lines, result);
		if (n < lines.length) {
			logger.warn("报文解析未正确完成.");
		}
		return result;
	}

	private String[] splitRawText(String data) {
		if (data == null || data.isEmpty()) {
			throw new IllegalArgumentException("解析对账单报文出错:报文内容不能为空.");
		}
		return data.split("\r\n");
	}

	// 解析状态枚举
	public static enum State {
		ItemHeader, Item, TotalHeader, Total
	}

	/**
	 * 构建文本解析器
	 * 
	 * @author Jann Liu
	 *
	 */
	public static class StateParserFactory {
		public static final StateParser getParser() {
			// TotalItemParser

			TotalItemParser totalItemParser = new TotalItemParser();
			// TotalHeaderParser
			TotalHeaderParser totalHeaderParser = new TotalHeaderParser();
			totalHeaderParser.setNext(totalItemParser);
			// ItemParser
			ItemParser itemParser = new ItemParser();
			itemParser.setNext(totalHeaderParser);
			// ItemHeaderParser
			ItemHeaderParser itemHeaderParser = new ItemHeaderParser();
			itemHeaderParser.setNext(itemParser);
			return itemHeaderParser;
		}
	}

	// 具体状态的解析器
	public static interface StateParser {
		void setNext(StateParser next);

		/**
		 * 返回当前的解析状态
		 * 
		 * @return 状态枚举
		 */
		State getState();

		/**
		 * 返回下一条带解析字符串的序号
		 */
		int parse(int lineNum, String[] lines, DownloadBillResultImpl result);
	}

	/**
	 * 抽象解析类
	 * 
	 * @author Jann Liu
	 *
	 */
	static abstract class AbstractStateParser implements StateParser {
		private StateParser next;

		@Override
		public void setNext(StateParser next) {
			this.next = next;
		}

		/**
		 * @return the next
		 */
		public StateParser getNext() {
			return next;
		}
	}

	/**
	 * 数据头解析
	 * 
	 * @author Jann Liu
	 *
	 */
	public static class ItemHeaderParser extends AbstractStateParser implements StateParser {
		@Override
		public State getState() {
			return State.ItemHeader;
		}

		/**
		 * 必须 lineNum==0 ,处理明细标题行
		 */
		@Override
		public int parse(int lineNum, String[] lines, DownloadBillResultImpl result) {
			int nextLineNum = lineNum;
			String src = lines[lineNum];
			if (isItemHeader(lineNum, src)) {
				final List<String> itemHeader = parseItemHeader(src);
				result.headers = itemHeader;
				nextLineNum++;
			}
			if (getNext() != null) {
				return getNext().parse(nextLineNum, lines, result);
			} else {
				return nextLineNum;
			}
		}

		// 解析报文头
		private List<String> parseItemHeader(String src) {
			String temp = src.replace("\ufeff", "");
			String[] headers = temp.split(",");
			return Arrays.asList(headers);
		}

		// 判定是否为ItemHeader
		boolean isItemHeader(int lineNum, String line) {
			return lineNum == 0 && line != null && !line.startsWith("`");
		}

	}

	/**
	 * Item集合的解析类
	 * 
	 * @author Jann Liu
	 *
	 */
	public static class ItemParser extends AbstractStateParser implements StateParser {

		@Override
		public State getState() {
			return State.Item;
		}

		@Override
		public int parse(int lineNum, String[] lines, DownloadBillResultImpl result) {
			int nextLineNum = lineNum;
			int i = lineNum;
			for (; i < lines.length; i++) {
				if (isItem(lineNum, lines[i])) {
					result.billItems.add(splitItem(lines[i]));
				} else {
					break;
				}
			}
			nextLineNum = i;
			if (nextLineNum < lines.length && getNext() != null) {
				return getNext().parse(nextLineNum, lines, result);
			} else {
				return nextLineNum;
			}
		}

		private boolean isItem(int lineNum, String text) {
			return text != null && text.startsWith("`");
		}

		private String[] splitItem(String text) {
			String[] arr = text.split("(^`|,`)");
			if (arr.length > 0) {
				return Arrays.copyOfRange(arr, 1, arr.length);
			} else {
				return arr;
			}
		}

	}

	/**
	 * 数据头解析
	 * 
	 * @author Jann Liu
	 *
	 */
	public static class TotalHeaderParser extends AbstractStateParser implements StateParser {
		@Override
		public State getState() {
			return State.ItemHeader;
		}

		/**
		 * 必须 lineNum==0 ,处理明细标题行
		 */
		@Override
		public int parse(int lineNum, String[] lines, DownloadBillResultImpl result) {
			int nextLineNum = lineNum;
			String src = lines[lineNum];
			if (isTotalHeader(lineNum, src)) {
				final List<String> totalHeader = parseItemHeader(src);
				result.totalHeaders = totalHeader;
				nextLineNum++;
			}
			if (getNext() != null) {
				return getNext().parse(nextLineNum, lines, result);
			} else {
				return nextLineNum;
			}
		}

		// 解析报文头
		private List<String> parseItemHeader(String src) {
			String temp = src.replace("\ufeff", "");
			String[] headers = temp.split(",");
			return Arrays.asList(headers);
		}

		// 判定是否为TotalHeader
		boolean isTotalHeader(int lineNum, String line) {
			return line != null && !line.startsWith("`");
		}

	}

	/**
	 * Item集合的解析类
	 * 
	 * @author Jann Liu
	 *
	 */
	public static class TotalItemParser extends AbstractStateParser implements StateParser {

		@Override
		public State getState() {
			return State.Total;
		}

		@Override
		public int parse(int lineNum, String[] lines, DownloadBillResultImpl result) {
			int nextLineNum = lineNum;
			int i = lineNum;
			for (; i < lines.length; i++) {
				if (isItem(lineNum, lines[i])) {
					String[] totalItem = splitItem(lines[i]);
					List<String> totalItemList = Arrays.asList(totalItem);
					result.totalItems = totalItemList;
				} else {
					break;
				}
			}
			nextLineNum = i;
			if (nextLineNum < lines.length && getNext() != null) {
				return getNext().parse(nextLineNum, lines, result);
			} else {
				return nextLineNum;
			}
		}

		private boolean isItem(int lineNum, String text) {
			return text != null && text.startsWith("`");
		}

		private String[] splitItem(String text) {
			String[] arr = text.split("(^`|,`)");
			if (arr.length > 0) {
				return Arrays.copyOfRange(arr, 1, arr.length);
			} else {
				return arr;
			}
		}

	}

	/**
	 * 对账解析结果类
	 * 
	 * @author Jann Liu
	 *
	 */
	private class DownloadBillResultImpl implements DownloadBillResult {

		private List<String> headers;
		private List<String> totalHeaders;
		private List<String> totalItems;
		private List<String[]> billItems = new ArrayList<String[]>();

		@Override
		public List<String> getHeaders() {
			return headers;
		}

		@Override
		public List<String> getTotalHeaders() {
			return totalHeaders;
		}

		@Override
		public List<String> getTotalItems() {
			return totalItems;
		}

		@Override
		public List<String[]> getBillItems() {
			return billItems;
		}

	}

}
