package cn.aposoft.ecommerce.wechat.scan.beans;

import cn.aposoft.ecommerce.wechat.scan.BaseReqData;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by lisong on 16/6/21.
 */
@XmlRootElement(name = "ROOT")
public class UpdateMerchantReqData extends BaseReqData {
    //终端号。空值时修改商户下所有终端信息。
    private String shopNo;
    //商户号。
    private String termNo;

    //商户名称
    private String merName;

    /**
     * 商户经营名称(简称)
     */
    private String bizName;

    //营业执照号。(渠道类型“个人”时为身份证号码)
    private String merLicenseNo;

    //商户注册地址省代码。《省市区划信息》
    private String provinceCode;

    //商户注册地址市代码《省市区划信息》。
    private String cityCode;

    //商户注册地址区代码《省市区划信息》。
    private String countyCode;

    //商户详细地址。
    private String address;

    //商户经营内容。《商户经营内容》
    private String bizContent;

    //商户法人姓名。(渠道类型“个人”为姓名)
    private String crLicenceName;

    //商户法人身份证号码。
    private String crLicenceNo;

    //联系人手机号码。
    private String contactMobile;

    //开户行号。"银行信息查询接口"获取
    private String openningBankNo;

    //开户支行名称。"银行信息查询接口"获取
    private String openningBankName;

    //清算行号。"银行信息查询接口"获取
    private String clearingBankNo;

    //银行账户号。
    private String accountNo;

    //银行账户名称
    private String accountName;

    /**
     * 入账人身份证号码-可能和法人身份证号不一致
     */
    private String idCard;

    //账户性质。
    //57：对公
    //58：对私
    private String accountKind;

    //行业代码。《行业信息表》
    private String mccCode;

    //借记卡单笔交易限额。（单位：元）
    private String debitPerLimit;

    //借记卡单日交易限额。（单位：元）
    private String debitDayLimit;

    //借记卡单月交易限额。（单位：元）
    private String debitMonthLimit;

    //贷记卡单笔交易限额。（单位：元）
    private String creditPerLimit;

    //贷记卡单日交易限额。（单位：元）
    private String creditDayLimit;

    //贷记卡单月交易限额。（单位：元）
    private String creditMonthLimit;

    //扫码单笔交易限额。（单位：元）
    private String wechatPerLimit;

    //扫码单日交易限额。（单位：元）
    private String wechatDayLimit;

    //扫码单月交易限额。（单位：元）
    private String wechatMonthLimit;

    //借记卡手续费。
    private String debitRate;

    //借记卡手续费保底值。
    private String debitMixAmt;

    //借记卡手续费封顶值。
    private String debitMaxAmt;

    //贷记卡手续费。
    private String creditRate;

    //贷记卡手续费保底值。
    private String creditMixAmt;

    //贷记卡手续费封顶值。
    private String creditMaxAmt;

    //扫码手续费集合
    private List<WechatFee> wechatFees;

    //通知地址。
    private String retUrl;

    //附件信息集合。
    private List<Attachment> attachments;

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    public String getTermNo() {
        return termNo;
    }

    public void setTermNo(String termNo) {
        this.termNo = termNo;
    }

    public String getMerName() {
        return merName;
    }

    public void setMerName(String merName) {
        this.merName = merName;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public String getMerLicenseNo() {
        return merLicenseNo;
    }

    public void setMerLicenseNo(String merLicenseNo) {
        this.merLicenseNo = merLicenseNo;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBizContent() {
        return bizContent;
    }

    public void setBizContent(String bizContent) {
        this.bizContent = bizContent;
    }

    public String getCrLicenceName() {
        return crLicenceName;
    }

    public void setCrLicenceName(String crLicenceName) {
        this.crLicenceName = crLicenceName;
    }

    public String getCrLicenceNo() {
        return crLicenceNo;
    }

    public void setCrLicenceNo(String crLicenceNo) {
        this.crLicenceNo = crLicenceNo;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getOpenningBankNo() {
        return openningBankNo;
    }

    public void setOpenningBankNo(String openningBankNo) {
        this.openningBankNo = openningBankNo;
    }

    public String getOpenningBankName() {
        return openningBankName;
    }

    public void setOpenningBankName(String openningBankName) {
        this.openningBankName = openningBankName;
    }

    public String getClearingBankNo() {
        return clearingBankNo;
    }

    public void setClearingBankNo(String clearingBankNo) {
        this.clearingBankNo = clearingBankNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAccountKind() {
        return accountKind;
    }

    public void setAccountKind(String accountKind) {
        this.accountKind = accountKind;
    }

    public String getMccCode() {
        return mccCode;
    }

    public void setMccCode(String mccCode) {
        this.mccCode = mccCode;
    }

    public String getDebitPerLimit() {
        return debitPerLimit;
    }

    public void setDebitPerLimit(String debitPerLimit) {
        this.debitPerLimit = debitPerLimit;
    }

    public String getDebitDayLimit() {
        return debitDayLimit;
    }

    public void setDebitDayLimit(String debitDayLimit) {
        this.debitDayLimit = debitDayLimit;
    }

    public String getDebitMonthLimit() {
        return debitMonthLimit;
    }

    public void setDebitMonthLimit(String debitMonthLimit) {
        this.debitMonthLimit = debitMonthLimit;
    }

    public String getCreditPerLimit() {
        return creditPerLimit;
    }

    public void setCreditPerLimit(String creditPerLimit) {
        this.creditPerLimit = creditPerLimit;
    }

    public String getCreditDayLimit() {
        return creditDayLimit;
    }

    public void setCreditDayLimit(String creditDayLimit) {
        this.creditDayLimit = creditDayLimit;
    }

    public String getCreditMonthLimit() {
        return creditMonthLimit;
    }

    public void setCreditMonthLimit(String creditMonthLimit) {
        this.creditMonthLimit = creditMonthLimit;
    }

    public String getWechatPerLimit() {
        return wechatPerLimit;
    }

    public void setWechatPerLimit(String wechatPerLimit) {
        this.wechatPerLimit = wechatPerLimit;
    }

    public String getWechatDayLimit() {
        return wechatDayLimit;
    }

    public void setWechatDayLimit(String wechatDayLimit) {
        this.wechatDayLimit = wechatDayLimit;
    }

    public String getWechatMonthLimit() {
        return wechatMonthLimit;
    }

    public void setWechatMonthLimit(String wechatMonthLimit) {
        this.wechatMonthLimit = wechatMonthLimit;
    }

    public String getDebitRate() {
        return debitRate;
    }

    public void setDebitRate(String debitRate) {
        this.debitRate = debitRate;
    }

    public String getDebitMixAmt() {
        return debitMixAmt;
    }

    public void setDebitMixAmt(String debitMixAmt) {
        this.debitMixAmt = debitMixAmt;
    }

    public String getDebitMaxAmt() {
        return debitMaxAmt;
    }

    public void setDebitMaxAmt(String debitMaxAmt) {
        this.debitMaxAmt = debitMaxAmt;
    }

    public String getCreditRate() {
        return creditRate;
    }

    public void setCreditRate(String creditRate) {
        this.creditRate = creditRate;
    }

    public String getCreditMixAmt() {
        return creditMixAmt;
    }

    public void setCreditMixAmt(String creditMixAmt) {
        this.creditMixAmt = creditMixAmt;
    }

    public String getCreditMaxAmt() {
        return creditMaxAmt;
    }

    public void setCreditMaxAmt(String creditMaxAmt) {
        this.creditMaxAmt = creditMaxAmt;
    }

    public List<WechatFee> getWechatFees() {
        return wechatFees;
    }

    public void setWechatFees(List<WechatFee> wechatFees) {
        this.wechatFees = wechatFees;
    }

    public String getRetUrl() {
        return retUrl;
    }

    public void setRetUrl(String retUrl) {
        this.retUrl = retUrl;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
}
