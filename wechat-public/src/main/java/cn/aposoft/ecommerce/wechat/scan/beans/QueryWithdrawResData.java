package cn.aposoft.ecommerce.wechat.scan.beans;

import cn.aposoft.ecommerce.wechat.scan.BaseResData;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by lisong on 16/7/4.
 */
@XmlRootElement(name="ROOT")
public class QueryWithdrawResData extends BaseResData {

    private String reqLogNo;

    private String mercId;

    private String details;

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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details=details;
    }
}
