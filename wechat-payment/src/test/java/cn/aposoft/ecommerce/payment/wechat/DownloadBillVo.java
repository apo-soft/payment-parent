/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat;

/**
 * 下载对账单查询参数集合
 * 
 * @author Jann Liu
 *
 */
public class DownloadBillVo implements DownloadBill {

	private DownloadBillVo() {
	}

	public static DownloadBill demo() {
		DownloadBillVo vo = new DownloadBillVo();
		vo.bill_date = "20151028";
		vo.bill_type = "ALL";
		return vo;
	}

	private String bill_date;
	private String bill_type;
	private String device_info;

	/**
	 * @see cn.aposoft.ecommerce.payment.wechat.DownloadBill#getBill_date()
	 */
	@Override
	public String getBill_date() {
		return bill_date;
	}

	/**
	 * @see cn.aposoft.ecommerce.payment.wechat.DownloadBill#getBill_type()
	 */
	@Override
	public String getBill_type() {
		return bill_type;
	}

	/**
	 * @see cn.aposoft.ecommerce.payment.wechat.DownloadBill#getDevice_info()
	 */
	@Override
	public String getDevice_info() {
		return device_info;
	}

}
