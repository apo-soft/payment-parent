package cn.aposoft.ecommerce.wechat.scan.beans;


import cn.aposoft.ecommerce.wechat.scan.BasicTO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by xiaowei.wang on 2016/5/24.
 */
@XmlRootElement(name = "ROOT")
public class WechatScanResData extends BasicTO {
    private static final long serialVersionUID = 1L;
    //授权码
    private String authCode;
    //第三方钱包返回错误码
    private String errCode;
    //扩展返回数据
    private String extRpData;
    private String MAC;
    //商户号
    private String mercId;
    //商户订单号
    private String merOrderNo;
    //返回码描述
    private String message;
    //营销优惠信息
    private String mrkInfo;
    //原请求流水号
    private String ornReqLogNo;
    //支付渠道描述
    private String payChlDesc;
    //第三方钱包订单号
    private String payOrderId;
    //预付单号
    private String prePayId;
    //请求流水号
    private String reqLogNo;
    //返回码 成功返回000000，否则返回六位错误码。 当返回0100C0时，表示本次支付进行中，需间隔10秒后通过订单查询接口发起
    private String responseCode;
    //第三方钱包返回交易状态 微信渠道： SUCCESS—支付成功,REFUND—转入退款, NOTPAY—未支付,CLOSED—已关闭,REVOKED—已撤销 USERPAYING--用户支付中,NOPAY--未支付(输入密码或 确认支付超时), PAYERROR-- 支 付 失 败 ( 其 他 原因，如银行返回失败)
    private String tradeState;
    //交易金额 订单总金额
    private String txnAmt;
    //交易时间
    private String txnTm;
    //用户识别码
    private String userId;
    @XmlElement
    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
    @XmlElement
    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
    @XmlElement
    public String getExtRpData() {
        return extRpData;
    }

    public void setExtRpData(String extRpData) {
        this.extRpData = extRpData;
    }
    @XmlElement
    public String getMAC() {
        return MAC;
    }

    public void setMAC(String MAC) {
        this.MAC = MAC;
    }
    @XmlElement
    public String getMercId() {
        return mercId;
    }

    public void setMercId(String mercId) {
        this.mercId = mercId;
    }
    @XmlElement
    public String getMerOrderNo() {
        return merOrderNo;
    }

    public void setMerOrderNo(String merOrderNo) {
        this.merOrderNo = merOrderNo;
    }
    @XmlElement
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    @XmlElement
    public String getMrkInfo() {
        return mrkInfo;
    }

    public void setMrkInfo(String mrkInfo) {
        this.mrkInfo = mrkInfo;
    }
    @XmlElement
    public String getOrnReqLogNo() {
        return ornReqLogNo;
    }

    public void setOrnReqLogNo(String ornReqLogNo) {
        this.ornReqLogNo = ornReqLogNo;
    }
    @XmlElement
    public String getPayChlDesc() {
        return payChlDesc;
    }

    public void setPayChlDesc(String payChlDesc) {
        this.payChlDesc = payChlDesc;
    }
    @XmlElement
    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }
    @XmlElement
    public String getPrePayId() {
        return prePayId;
    }

    public void setPrePayId(String prePayId) {
        this.prePayId = prePayId;
    }
    @XmlElement
    public String getReqLogNo() {
        return reqLogNo;
    }

    public void setReqLogNo(String reqLogNo) {
        this.reqLogNo = reqLogNo;
    }
    @XmlElement
    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
    @XmlElement
    public String getTradeState() {
        return tradeState;
    }

    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
    }
    @XmlElement
    public String getTxnAmt() {
        return txnAmt;
    }

    public void setTxnAmt(String txnAmt) {
        this.txnAmt = txnAmt;
    }
    @XmlElement
    public String getTxnTm() {
        return txnTm;
    }

    public void setTxnTm(String txnTm) {
        this.txnTm = txnTm;
    }
    @XmlElement
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
