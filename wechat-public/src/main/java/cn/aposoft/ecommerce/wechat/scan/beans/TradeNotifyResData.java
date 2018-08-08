package cn.aposoft.ecommerce.wechat.scan.beans;


import cn.aposoft.ecommerce.wechat.scan.BasicTO;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by whl on 6/9/16.
 */
@XmlRootElement(name = "ROOT")
public class TradeNotifyResData extends BasicTO {

    private static final long serialVersionUID = 1L;

    private String RetCode;

    private String RetMsg;

    private String MAC;

    public String getRetCode() {
        return RetCode;
    }

    public void setRetCode(String retCode) {
        RetCode = retCode;
    }

    public String getRetMsg() {
        return RetMsg;
    }

    public void setRetMsg(String retMsg) {
        RetMsg = retMsg;
    }

    public String getMAC() {
        return MAC;
    }

    public void setMAC(String MAC) {
        this.MAC = MAC;
    }
}
