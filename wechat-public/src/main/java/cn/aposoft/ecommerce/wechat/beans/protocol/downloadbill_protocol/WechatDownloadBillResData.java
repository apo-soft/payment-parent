package cn.aposoft.ecommerce.wechat.beans.protocol.downloadbill_protocol;



import java.util.Date;

/**
 *
 * User: rizenguo
 * Date: 2014/10/25
 * Time: 16:48
 */
public class WechatDownloadBillResData {

    /**
     * ????
     */
    private Date tradeTime;

    /**
     * ????ID
     */
    private String wechatAppid;

    /**
     * ?????
     */
    private String mchId;

    /**
     * ????
     */
    private String subMchId;

    /**
     * ???
     */
    private String deviceInfo;

    /**
     * ?????
     */
    private String wechatOrderId;

    /**
     * ?????
     */
    private String mchOrderId;

    /**
     * ????
     */
    private String userId;

    /**
     * ????
     */
    private String tradeType;

    /**
     * ????
     */
    private String tradeStatus;

    /**
     * ????
     */
    private String payBank;

    /**
     * ????
     */
    private String currency;

    /**
     * ???
     */
    private String totalAmount;

    /**
     * ??????????
     */
    private String enterpriseRedEnvelopeAmount;

    /**
     * ??????
     */
    private String refundApplyTime;

    /**
     * ??????
     */
    private String refundSuccessTime;

    /**
     * ??????
     */
    private String wechatRefundOrderId;

    /**
     * ??????
     */
    private String mchRefundOrderId;

    /**
     * ????
     */
    private String refundAmount;

    /**
     * ????????????,
     */
    private String enterpriseRedEnvelopeRefundAmount;

    /**
     * ????
     */
    private String refundType;

    /**
     * ????
     */
    private String refundStatus;

    /**
     * ????
     */
    private String goodsName;

    /**
     * ?????
     */
    private String mchDataPackage;

    /**
     * ???
     */
    private String counterFee;

    /**
     * ??
     */
    private String feeRate;

    /**
     * ???
     */
    private Integer statementDate;


    public Date getTradeTime() {
        return tradeTime;
    }

    public WechatDownloadBillResData setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
        return this;
    }

    public String getWechatAppid() {
        return wechatAppid;
    }

    public WechatDownloadBillResData setWechatAppid(String wechatAppid) {
        this.wechatAppid = wechatAppid;
        return this;
    }

    public String getMchId() {
        return mchId;
    }

    public WechatDownloadBillResData setMchId(String mchId) {
        this.mchId = mchId;
        return this;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public WechatDownloadBillResData setSubMchId(String subMchId) {
        this.subMchId = subMchId;
        return this;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public WechatDownloadBillResData setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
        return this;
    }

    public String getWechatOrderId() {
        return wechatOrderId;
    }

    public WechatDownloadBillResData setWechatOrderId(String wechatOrderId) {
        this.wechatOrderId = wechatOrderId;
        return this;
    }

    public String getMchOrderId() {
        return mchOrderId;
    }

    public WechatDownloadBillResData setMchOrderId(String mchOrderId) {
        this.mchOrderId = mchOrderId;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public WechatDownloadBillResData setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getTradeType() {
        return tradeType;
    }

    public WechatDownloadBillResData setTradeType(String tradeType) {
        this.tradeType = tradeType;
        return this;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public WechatDownloadBillResData setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
        return this;
    }

    public String getPayBank() {
        return payBank;
    }

    public WechatDownloadBillResData setPayBank(String payBank) {
        this.payBank = payBank;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public WechatDownloadBillResData setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public WechatDownloadBillResData setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public String getEnterpriseRedEnvelopeAmount() {
        return enterpriseRedEnvelopeAmount;
    }

    public WechatDownloadBillResData setEnterpriseRedEnvelopeAmount(String enterpriseRedEnvelopeAmount) {
        this.enterpriseRedEnvelopeAmount = enterpriseRedEnvelopeAmount;
        return this;
    }

    public String getRefundApplyTime() {
        return refundApplyTime;
    }

    public WechatDownloadBillResData setRefundApplyTime(String refundApplyTime) {
        this.refundApplyTime = refundApplyTime;
        return this;
    }

    public String getRefundSuccessTime() {
        return refundSuccessTime;
    }

    public WechatDownloadBillResData setRefundSuccessTime(String refundSuccessTime) {
        this.refundSuccessTime = refundSuccessTime;
        return this;
    }

    public String getWechatRefundOrderId() {
        return wechatRefundOrderId;
    }

    public WechatDownloadBillResData setWechatRefundOrderId(String wechatRefundOrderId) {
        this.wechatRefundOrderId = wechatRefundOrderId;
        return this;
    }

    public String getMchRefundOrderId() {
        return mchRefundOrderId;
    }

    public WechatDownloadBillResData setMchRefundOrderId(String mchRefundOrderId) {
        this.mchRefundOrderId = mchRefundOrderId;
        return this;
    }

    public String getRefundAmount() {
        return refundAmount;
    }

    public WechatDownloadBillResData setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
        return this;
    }

    public String getEnterpriseRedEnvelopeRefundAmount() {
        return enterpriseRedEnvelopeRefundAmount;
    }

    public WechatDownloadBillResData setEnterpriseRedEnvelopeRefundAmount(String enterpriseRedEnvelopeRefundAmount) {
        this.enterpriseRedEnvelopeRefundAmount = enterpriseRedEnvelopeRefundAmount;
        return this;
    }

    public String getRefundType() {
        return refundType;
    }

    public WechatDownloadBillResData setRefundType(String refundType) {
        this.refundType = refundType;
        return this;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public WechatDownloadBillResData setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
        return this;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public WechatDownloadBillResData setGoodsName(String goodsName) {
        this.goodsName = goodsName;
        return this;
    }

    public String getMchDataPackage() {
        return mchDataPackage;
    }

    public WechatDownloadBillResData setMchDataPackage(String mchDataPackage) {
        this.mchDataPackage = mchDataPackage;
        return this;
    }

    public String getCounterFee() {
        return counterFee;
    }

    public WechatDownloadBillResData setCounterFee(String counterFee) {
        this.counterFee = counterFee;
        return this;
    }

    public String getFeeRate() {
        return feeRate;
    }

    public WechatDownloadBillResData setFeeRate(String feeRate) {
        this.feeRate = feeRate;
        return this;
    }

    public Integer getStatementDate() {
        return statementDate;
    }

    public WechatDownloadBillResData setStatementDate(Integer statementDate) {
        this.statementDate = statementDate;
        return this;
    }
}
