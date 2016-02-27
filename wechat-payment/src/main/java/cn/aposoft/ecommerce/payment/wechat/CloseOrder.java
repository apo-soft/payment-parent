/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat;

import java.io.Serializable;

/**
 * @author Jann Liu
 *
 */
public interface CloseOrder extends Serializable {
	public String getOut_trade_no();
}
