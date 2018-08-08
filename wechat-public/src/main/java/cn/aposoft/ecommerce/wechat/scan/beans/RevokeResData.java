package cn.aposoft.ecommerce.wechat.scan.beans;

import cn.aposoft.ecommerce.wechat.scan.BaseResData;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by lisong on 16/7/4.
 */
@XmlRootElement(name = "ROOT")
public class RevokeResData extends BaseResData {

    private String reqLogNo;

    private String ornReqLogNo;

    private String mercId;

    private String userId;

    private String txnTm;

    private String txnAmt;

    private String payOrderId;

    private String merOrderNo;

    private String payChlDesc;

    private String extRpData;

    private String errCode;


    public String getReqLogNo() {
        return reqLogNo;
    }

    public void setReqLogNo(String reqLogNo) {
        this.reqLogNo=reqLogNo;
    }

    public String getOrnReqLogNo() {
        return ornReqLogNo;
    }

    public void setOrnReqLogNo(String ornReqLogNo) {
        this.ornReqLogNo=ornReqLogNo;
    }

    public String getMercId() {
        return mercId;
    }

    public void setMercId(String mercId) {
        this.mercId=mercId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId=userId;
    }

    public String getTxnTm() {
        return txnTm;
    }

    public void setTxnTm(String txnTm) {
        this.txnTm=txnTm;
    }

    public String getTxnAmt() {
        return txnAmt;
    }

    public void setTxnAmt(String txnAmt) {
        this.txnAmt=txnAmt;
    }

    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId=payOrderId;
    }

    public String getMerOrderNo() {
        return merOrderNo;
    }

    public void setMerOrderNo(String merOrderNo) {
        this.merOrderNo=merOrderNo;
    }

    public String getPayChlDesc() {
        return payChlDesc;
    }

    public void setPayChlDesc(String payChlDesc) {
        this.payChlDesc=payChlDesc;
    }

    public String getExtRpData() {
        return extRpData;
    }

    public void setExtRpData(String extRpData) {
        this.extRpData=extRpData;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode=errCode;
    }
}
