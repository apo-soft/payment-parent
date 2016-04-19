package cn.aposoft.ecommerce.payment.wechat.bean;

import java.math.BigDecimal;
import java.util.Date;

public class OrderBill {

	/**
	 * 订单状态类
	 * 
	 * @author Jann Liu
	 *
	 */
	public static class OrderBillState {
		/**
		 * 订单已经创建,客户点击创建
		 */
		public static final int CREATED = 0;
		/**
		 * 订单已经提交,客户提交,进行支付
		 */
		public static final int SUBMITTED = 1;
		/**
		 * 订单已经支付完成,第三方支付确认支付
		 */
		public static final int PAID = 2;
		/**
		 * 订单已经关闭,后台客服关闭
		 */
		public static final int CLOSED = 3;
		/**
		 * 订单已经过期,自动超时过期
		 */
		public static final int EXPIRED = 4;
		/**
		 * 订单已经取消 客户取消
		 */
		public static final int CANCEL = 5;
	}

	private Integer orderId;

	private String orderNo;

	private String orderDesc;

	private BigDecimal orderAmount;

	private BigDecimal orderPaidAmount;

	private Integer orderState;

	private Date createTime;

	private Date updateTime;

	private Date closedTime;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo == null ? null : orderNo.trim();
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc == null ? null : orderDesc.trim();
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public BigDecimal getOrderPaidAmount() {
		return orderPaidAmount;
	}

	public void setOrderPaidAmount(BigDecimal orderPaidAmount) {
		this.orderPaidAmount = orderPaidAmount;
	}

	public Integer getOrderState() {
		return orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getClosedTime() {
		return closedTime;
	}

	public void setClosedTime(Date closedTime) {
		this.closedTime = closedTime;
	}
}