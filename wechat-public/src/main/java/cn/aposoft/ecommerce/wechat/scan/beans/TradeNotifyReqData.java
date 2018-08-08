package cn.aposoft.ecommerce.wechat.scan.beans;

import cn.aposoft.ecommerce.wechat.scan.BaseResData;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by whl on 6/9/16.
 */
@XmlRootElement(name = "ROOT")
public class TradeNotifyReqData extends BaseResData {

    private static final long serialVersionUID = 1L;

    // 机构代码
    private String compOrgCode;

    // 机构代码
    private String reqLogNo;

    // 机构代码
    private String ornReqLogNo;

    // 请求时间
    private String reqTm;

    // 支付渠道类型
    private String payChlTyp;

    // 商户号
    private String mercId;

    // 交易金额
    private String txnAmt;

    // 交易时间
    private String txnTm;

    // 交易接口类型
    private String tradeType;

    // 子商户appid
    private String sub_appid;

    // 第三方钱包订单号
    private String payOrderId;

    // 商户订单号
    private String merOrderNo;

    private String userId;

    @XmlElement
    public String getCompOrgCode() {
        return compOrgCode;
    }

    public void setCompOrgCode(String compOrgCode) {
        this.compOrgCode = compOrgCode;
    }

    @XmlElement
    public String getReqLogNo() {
        return reqLogNo;
    }

    public void setReqLogNo(String reqLogNo) {
        this.reqLogNo = reqLogNo;
    }

    @XmlElement
    public String getOrnReqLogNo() {
        return ornReqLogNo;
    }

    public void setOrnReqLogNo(String ornReqLogNo) {
        this.ornReqLogNo = ornReqLogNo;
    }

    @XmlElement
    public String getReqTm() {
        return reqTm;
    }

    public void setReqTm(String reqTm) {
        this.reqTm = reqTm;
    }

    @XmlElement
    public String getPayChlTyp() {
        return payChlTyp;
    }

    public void setPayChlTyp(String payChlTyp) {
        this.payChlTyp = payChlTyp;
    }

    @XmlElement
    public String getMercId() {
        return mercId;
    }

    public void setMercId(String mercId) {
        this.mercId = mercId;
    }

    @XmlElement
    public String getTxnAmt() {
        return txnAmt;
    }

    public void setTxnAmt(String txnAmt) {
        this.txnAmt = txnAmt;
    }

    @XmlElement
    public String getTxnTm() {
        return txnTm;
    }

    public void setTxnTm(String txnTm) {
        this.txnTm = txnTm;
    }

    @XmlElement
    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    @XmlElement
    public String getSub_appid() {
        return sub_appid;
    }

    public void setSub_appid(String sub_appid) {
        this.sub_appid = sub_appid;
    }

    @XmlElement
    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    @XmlElement
    public String getMerOrderNo() {
        return merOrderNo;
    }

    public void setMerOrderNo(String merOrderNo) {
        this.merOrderNo = merOrderNo;
    }

    @XmlElement
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
