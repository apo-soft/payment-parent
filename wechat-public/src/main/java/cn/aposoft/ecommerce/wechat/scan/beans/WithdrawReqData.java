package cn.aposoft.ecommerce.wechat.scan.beans;

import cn.aposoft.ecommerce.wechat.scan.BaseReqData;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by lisong on 16/7/4.
 */
@XmlRootElement(name="ROOT")
public class WithdrawReqData extends BaseReqData {
    private String reqLogNo;
    private String reqTm;
    private String mercId;
    private String txnAmt;
    private String termId;

    public String getReqLogNo() {
        return reqLogNo;
    }

    public void setReqLogNo(String reqLogNo) {
        this.reqLogNo=reqLogNo;
    }

    public String getReqTm() {
        return reqTm;
    }

    public void setReqTm(String reqTm) {
        this.reqTm=reqTm;
    }

    public String getMercId() {
        return mercId;
    }

    public void setMercId(String mercId) {
        this.mercId=mercId;
    }

    public String getTxnAmt() {
        return txnAmt;
    }

    public void setTxnAmt(String txnAmt) {
        this.txnAmt=txnAmt;
    }

    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId=termId;
    }

}
