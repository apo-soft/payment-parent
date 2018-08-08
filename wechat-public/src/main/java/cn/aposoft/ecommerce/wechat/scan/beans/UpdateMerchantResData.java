package cn.aposoft.ecommerce.wechat.scan.beans;

import cn.aposoft.ecommerce.wechat.scan.BaseResData;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by lisong on 16/6/21.
 */
@XmlRootElement(name = "ROOT")
public class UpdateMerchantResData extends BaseResData {
    private String contractId;

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId=contractId;
    }
}
