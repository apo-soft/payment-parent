package cn.aposoft.ecommerce.payment.wechat.util;

import org.apache.log4j.Logger;

/**
 * 工具类:
 * <p>
 * 1. parseNum
 * 
 * @author Yujinshui
 *
 */
public class CommonUtil {
	private static Logger logger = Logger.getLogger(CommonUtil.class);

	private CommonUtil() {
	}

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
				logger.error("input object:" + object + "    数字格式转换失败，请检查输入内容是否合法.");
			}
		}
		return res;
	}

	/**
	 * 实现从对象到String的转换, 针对null对象进行特殊处理,直接返回nullString 其他情况参考
	 * {@link String#valueOf(Object)}
	 * 
	 * @param o
	 *            待转换为String的对象
	 * @return 输入o为null时,返回null,其他情况返回String.valueOf(o);
	 */
	public static String toString(Object o) {
		if (o == null) {
			return null;
		} else if (o instanceof String) {
			return (String) o;
		} else {
			return String.valueOf(o);
		}
	}

	/**
	 * 实现从对象到String的转换, 针对null对象进行特殊处理,直接返回nullString 其他情况参考
	 * {@link String#valueOf(Object)}
	 * 
	 * @param l
	 *            输入的长整形值
	 * @return l的字符串表示 {@link String#valueOf(long)}
	 */
	public static String toString(long l) {
		return String.valueOf(l);
	}

	/**
	 * 参考 {@link String#valueOf(int)}
	 * 
	 * @param i
	 *            输入的长整形值
	 * @return i的字符串表示 {@link String#valueOf(int)}
	 */
	public static String toString(int i) {
		return String.valueOf(i);
	}

	/**
	 * 参考 {@link String#valueOf(char)}
	 * 
	 * @param c
	 *            输入字符
	 * @return c的字符串表示 {@link String#valueOf(char)}
	 */
	public static String toString(char c) {
		return String.valueOf(c);
	}

	/**
	 * 参考 {@link String#valueOf(short)}
	 * 
	 * @param sh
	 *            输入短整型数字
	 * @return sh的字符串表示 {@link String#valueOf(short)}
	 */
	public static String toString(short sh) {
		return String.valueOf(sh);
	}

	/**
	 * 参考 {@link String#valueOf(byte)}
	 * 
	 * @param by
	 *            字节值
	 * @return by的字符串表示 {@link String#valueOf(byte)}
	 */
	public static String toString(byte by) {
		return String.valueOf(by);
	}

	/**
	 * 参考 {@link String#valueOf(float)}
	 * 
	 * @param f
	 *            输入的浮点数字
	 * @return f的字符串表示 {@link String#valueOf(float)}
	 */
	public static String toString(float f) {
		return String.valueOf(f);
	}

	/**
	 * 参考 {@link String#valueOf(double)}
	 * 
	 * @param d
	 *            输入的双精度浮点数字
	 * @return d的字符串表示 {@link String#valueOf(double)}
	 */
	public static String toString(double d) {
		return String.valueOf(d);
	}

	/**
	 * 参考 {@link String#valueOf(boolean)}
	 * 
	 * @param b
	 *            输入的bool值
	 * 
	 * @return b的字符串表示 {@link String#valueOf(boolean)}
	 */
	public static String toString(boolean b) {
		return String.valueOf(b);
	}
}
