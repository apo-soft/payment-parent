package cn.aposoft.ecommerce.payment.wechat.bean;

import java.math.BigDecimal;
import java.util.Date;

public class OrderBill {
    private Integer orderId;

    private String orderNo;

    private String orderDesc;

    private BigDecimal orderAmount;

    private BigDecimal orderPaidAmount;

    private Boolean orderState;

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

    public Boolean getOrderState() {
        return orderState;
    }

    public void setOrderState(Boolean orderState) {
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