package cn.aposoft.ecommerce.wechat.scan.beans;


import cn.aposoft.ecommerce.wechat.scan.BasicTO;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by lisong on 16/7/20.
 */
@XmlRootElement(name = "ROOT")
public class UploadFileResData extends BasicTO {
    private String command;
    private String responseCode;
    private String message;
    private String contractId;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command=command;
    }


    public String getResponseCode() {
        return responseCode;
    }


    public void setResponseCode(String responseCode) {
        this.responseCode=responseCode;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message=message;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId=contractId;
    }
}
