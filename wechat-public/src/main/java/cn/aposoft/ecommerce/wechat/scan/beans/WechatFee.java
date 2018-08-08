package cn.aposoft.ecommerce.wechat.scan.beans;

/**
 * Created by lisong on 16/5/31.
 */
public class WechatFee {
    private String wechatType;
    private String wechatRate;
    private String wechatMinAmt;
    private String wechatMaxAmt;


    public String getWechatType() {
        return wechatType;
    }

    public void setWechatType(String wechatType) {
        this.wechatType=wechatType;
    }

    public String getWechatRate() {
        return wechatRate;
    }

    public void setWechatRate(String wechatRate) {
        this.wechatRate=wechatRate;
    }

    public String getWechatMinAmt() {
        return wechatMinAmt;
    }

    public void setWechatMinAmt(String wechatMinAmt) {
        this.wechatMinAmt=wechatMinAmt;
    }

    public String getWechatMaxAmt() {
        return wechatMaxAmt;
    }

    public void setWechatMaxAmt(String wechatMaxAmt) {
        this.wechatMaxAmt=wechatMaxAmt;
    }

}
