/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.util;

import cn.aposoft.ecommerce.payment.wechat.CouponParser;
import cn.aposoft.ecommerce.payment.wechat.RefundResultParser;
import cn.aposoft.ecommerce.payment.wechat.impl.OrderQueryCouponParser;
import cn.aposoft.ecommerce.payment.wechat.impl.RefundQueryCouponParser;

/**
 * {@code ParserFactory}
 * Parser工厂:用于获取OrderQuery或RefundQuery中带有序号循环的数据的解析的Parser构造类
 * 
 * @author Jann Liu
 *
 */
public class ParserFactory {

	private static final CouponParser orderQueryParser = new OrderQueryCouponParser();
	private static final RefundResultParser refundQueryParser = new RefundQueryCouponParser();

	/**
	 * 优惠券解析对象
	 * 
	 * @param type
	 *            输入数据类型
	 * @return 解析对象实例
	 */
	public static CouponParser getCouponParser(ParserType type) {
		if (ParserType.OrderQuery.equals(type)) {
			return orderQueryParser;
		} else if (ParserType.RefundQuery.equals(type)) {
			return refundQueryParser;
		} else {
			return null;
		}
	}

	/**
	 * 退款结果解析对象
	 * 
	 * @return 返回退款结果解析对象
	 */
	public static RefundResultParser getRefundResultParser() {
		return refundQueryParser;
	}

	/**
	 * 解析类型
	 * 
	 * @author Jann Liu
	 *
	 */
	public static enum ParserType {
		/**
		 * 订单查询
		 */
		OrderQuery,
		/**
		 * 退款查询
		 */
		RefundQuery
	}
}
