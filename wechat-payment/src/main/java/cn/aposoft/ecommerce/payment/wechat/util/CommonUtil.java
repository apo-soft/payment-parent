package cn.aposoft.ecommerce.payment.wechat.util;

import org.apache.log4j.Logger;

/**
 * 工具类
 * 
 * @author Yujinshui
 *
 */
public class CommonUtil {
	private static Logger logger = Logger.getLogger(CommonUtil.class);

	/**
	 * 金额转换[Integer]
	 * 
	 * @param object
	 * @return
	 * @author Yujinshui
	 */
	public static Integer parseNum(Object object) {
		Integer res = 0;
		if (object != null) {
			try {
				res = Integer.parseInt(object.toString());
			} catch (NumberFormatException e) {
				logger.error("input object:" + object + "    数字格式转换失败，请检查输入内容是否合法");
				e.printStackTrace();
			}
		}
		return res;
	}

}
