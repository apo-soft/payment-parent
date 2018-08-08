package cn.aposoft.ecommerce.wechat.scan.beans;

import cn.aposoft.ecommerce.wechat.scan.BaseResData;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by lisong on 16/7/4.
 */
@XmlRootElement(name="ROOT")
public class WithdrawResData extends BaseResData {

    private String reqLogNo;
    private String mercId;
    private String txnTm;
    private String txnAmt;
    private String extRpData;

    public String getReqLogNo() {
        return reqLogNo;
    }

    public void setReqLogNo(String reqLogNo) {
        this.reqLogNo=reqLogNo;
    }

    public String getMercId() {
        return mercId;
    }

    public void setMercId(String mercId) {
        this.mercId=mercId;
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

    public String getExtRpData() {
        return extRpData;
    }

    public void setExtRpData(String extRpData) {
        this.extRpData=extRpData;
    }
}
