package cn.aposoft.ecommerce.wechat.scan.beans;

import cn.aposoft.ecommerce.wechat.scan.BaseReqData;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by xiaowei.wang on 2016/5/24.
 */
@XmlRootElement(name = "ROOT")
public class WechatScanReqData extends BaseReqData {
    private static final long serialVersionUID = 1L;

    //扩展信息 保留扩展字段，以|分隔
    private String extData;

    //商品标识 营销活动信息
    private String goodsTag;

    //商户号
    private String mercId;
    //子商户appid
    private String sub_appid;
    //用户标识 用户在商户下唯一标识
    private String openId;
    //订单描述 扫码支付商品描述
    private String orderInfo;
    //原请求流水号 原扫码支付交易上送的请求流水号
    private String ornReqLogNo ;
    //支付渠道类型 微信二维码消费:WECHAT,支付宝二维码消费:ALIPAY,百度二维码消费:BAIDUPAY
    private String payChlTyp;
    //商品ID
    private String productId;
    //请求流水号 定长16位 保证唯一
    private String reqLogNo;
    //请求时间 14位,格式：yyyyMMddHHmmss
    private String reqTm;
    //终端号
    private String termId;
    //交易接口类型 JSAPI、NATIVE、APP
    private String tradeType;
    //交易金额 订单总金额 以分为单位
    private String txnAmt;

    //异步通知支付结果。
    //不上送，则不通知。
    private String NTF_URL;

    @XmlElement
    public String getExtData() {
        return extData;
    }

    public void setExtData(String extData) {
        this.extData = extData;
    }

    @XmlElement
    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    @XmlElement
    public String getMercId() {
        return mercId;
    }

    public void setMercId(String mercId) {
        this.mercId = mercId;
    }
    @XmlElement
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
    @XmlElement
    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }
    @XmlElement
    public String getOrnReqLogNo() {
        return ornReqLogNo;
    }

    public void setOrnReqLogNo(String ornReqLogNo) {
        this.ornReqLogNo = ornReqLogNo;
    }
    @XmlElement
    public String getPayChlTyp() {
        return payChlTyp;
    }

    public void setPayChlTyp(String payChlTyp) {
        this.payChlTyp = payChlTyp;
    }
    @XmlElement
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    @XmlElement
    public String getReqLogNo() {
        return reqLogNo;
    }

    public void setReqLogNo(String reqLogNo) {
        this.reqLogNo = reqLogNo;
    }
    @XmlElement
    public String getReqTm() {
        return reqTm;
    }

    public void setReqTm(String reqTm) {
        this.reqTm = reqTm;
    }
    @XmlElement
    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId = termId;
    }
    @XmlElement
    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }
    @XmlElement
    public String getTxnAmt() {
        return txnAmt;
    }

    public void setTxnAmt(String txnAmt) {
        this.txnAmt = txnAmt;
    }

    public String getSub_appid() {
        return sub_appid;
    }

    public void setSub_appid(String sub_appid) {
        this.sub_appid=sub_appid;
    }

    @XmlElement
    public String getNTF_URL() {
        return NTF_URL;
    }

    public void setNTF_URL(String NTF_URL) {
        this.NTF_URL = NTF_URL;
    }
}
