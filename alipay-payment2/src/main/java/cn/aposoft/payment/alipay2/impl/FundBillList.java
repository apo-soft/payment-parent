package cn.aposoft.payment.alipay2.impl;

/**
 * 交易资金明细信息集合
 * 
 * @author Yujinshui
 *
 */
public class FundBillList {
	/**
	 * 支付渠道 [固定参数]
	 * <p>
	 * 支付渠道，参见下面的“支付渠道说明”。
	 */
	private String fund_channel;
	/**
	 * 支付金额
	 * <p>
	 * 使用指定支付渠道支付的金额，单位为元。
	 */
	private String amount;

	/**
	 * 支付渠道 [固定参数]
	 * <p>
	 * 支付渠道，参见下面的“支付渠道说明”。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午4:46:59
	 */
	public String getFund_channel() {
		return fund_channel;
	}

	/**
	 * 支付渠道 [固定参数]
	 * <p>
	 * 支付渠道，参见下面的“支付渠道说明”。
	 * 
	 * @param fund_channel
	 * @author Yujinshui
	 * @time 2015年11月10日 下午4:47:05
	 */
	public void setFund_channel(String fund_channel) {
		this.fund_channel = fund_channel;
	}

	/**
	 * 支付金额
	 * <p>
	 * 使用指定支付渠道支付的金额，单位为元。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午4:47:12
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * 支付金额
	 * <p>
	 * 使用指定支付渠道支付的金额，单位为元。
	 * 
	 * @param amount
	 * @author Yujinshui
	 * @time 2015年11月10日 下午4:47:16
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
}
