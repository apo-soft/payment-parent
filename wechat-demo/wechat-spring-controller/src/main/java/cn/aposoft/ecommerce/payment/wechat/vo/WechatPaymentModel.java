/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.vo;

import java.io.Serializable;

/**
 * 微信支付页面数据模型
 * 
 * @author LiuJian
 *
 */
public class WechatPaymentModel implements Serializable {
	private static final long serialVersionUID = 3474633591597051933L;
	// 订单编号
	private String orderNo;
	// 微信支付二维码url地址
	private String pngUrl;
	// 总消费价格
	private String totalFee;

	public String getPngUrl() {
		return pngUrl;
	}

	public void setPngUrl(String pngUrl) {
		this.pngUrl = pngUrl;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

}
