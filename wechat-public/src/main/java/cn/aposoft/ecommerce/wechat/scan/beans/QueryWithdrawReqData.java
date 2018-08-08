package cn.aposoft.ecommerce.wechat.scan.beans;

import cn.aposoft.ecommerce.wechat.scan.BaseReqData;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by lisong on 16/7/4.
 */
@XmlRootElement(name = "ROOT")
public class QueryWithdrawReqData extends BaseReqData {
    private String reqLogNo;
    private String reqTm;
    private String mercId;
    private String termId;
    private String qryDate;

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

    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId=termId;
    }

    public String getQryDate() {
        return qryDate;
    }

    public void setQryDate(String qryDate) {
        this.qryDate=qryDate;
    }
}
