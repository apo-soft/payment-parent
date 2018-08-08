package cn.aposoft.ecommerce.wechat.scan.beans;

import cn.aposoft.ecommerce.wechat.scan.BaseReqData;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by lisong on 16/7/22.
 */
@XmlRootElement(name="ROOT")
public class QueryRefundReqData extends BaseReqData {
    private String reqLogNo;
    private String ornReqLogNo;
    private String reqTm;
    private String payChlTyp;
    private String mercId;
    private String termId;
    private String txnAmt;
    private String sub_appid;
    private String extData;

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

    public String getReqTm() {
        return reqTm;
    }

    public void setReqTm(String reqTm) {
        this.reqTm=reqTm;
    }

    public String getPayChlTyp() {
        return payChlTyp;
    }

    public void setPayChlTyp(String payChlTyp) {
        this.payChlTyp=payChlTyp;
    }

    public String getMercId() {
        return mercId;
    }

    public void setMercId(String mercId) {
        this.mercId=mercId;
    }

    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId=termId;
    }

    public String getTxnAmt() {
        return txnAmt;
    }

    public void setTxnAmt(String txnAmt) {
        this.txnAmt=txnAmt;
    }

    public String getSub_appid() {
        return sub_appid;
    }

    public void setSub_appid(String sub_appid) {
        this.sub_appid=sub_appid;
    }

    public String getExtData() {
        return extData;
    }

    public void setExtData(String extData) {
        this.extData=extData;
    }
}
