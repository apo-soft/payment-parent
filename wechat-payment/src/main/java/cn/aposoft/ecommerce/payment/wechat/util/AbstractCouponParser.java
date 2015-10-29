/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CouponParser的抽象基类
 * 
 * @author Jann Liu
 *
 */
public abstract class AbstractCouponParser implements CouponParser {

	private static final String COMMON_SINGLE_DOLLAR_PATTERN_TEXT = "^[_a-z]+_(\\d+)$";
	private static final String COMMON_DOUBLE_DOLLAR_PATTERN_TEXT = "^[_a-z]+_(\\d+)_(\\d+)$";
	protected static final Pattern COMMON_SINGLE_DOLLAR_PATTERN = Pattern.compile(COMMON_SINGLE_DOLLAR_PATTERN_TEXT);
	protected static final Pattern COMMON_DOUBLE_DOLLAR_PATTERN = Pattern.compile(COMMON_DOUBLE_DOLLAR_PATTERN_TEXT);

	/**
	 * 读取序号 如果是优惠券读取第一个$后面的字段 当无法读取合法值时,返回-1
	 */
	@Override
	public int getN(String key) {
		if (Pattern.matches(COMMON_SINGLE_DOLLAR_PATTERN_TEXT, key)) {
			return getSingleN(key);
		} else if (Pattern.matches(COMMON_DOUBLE_DOLLAR_PATTERN_TEXT, key)) {
			return getDoubleN(key);
		}

		return -1;
	}

	private int getDoubleN(String key) {
		Matcher matcher = COMMON_DOUBLE_DOLLAR_PATTERN.matcher(key);
		matcher.matches();
		return CommonUtil.parseNum(matcher.group(1));
	}

	/**
	 * 用于计算单一$标记的N
	 * <p>
	 * HINT:默认使用startWith方法
	 * 
	 * @param key
	 *            标识符字符串
	 * @return n的值
	 */
	private int getSingleN(String key) {
		Matcher matcher = COMMON_SINGLE_DOLLAR_PATTERN.matcher(key);
		matcher.matches();
		return CommonUtil.parseNum(matcher.group(1));
	}
}
