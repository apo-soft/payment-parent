package cn.aposoft.ecommerce.wechat.scan.beans;


import cn.aposoft.ecommerce.wechat.scan.BasicTO;

import java.io.InputStream;

/**
 * Created by lisong on 16/7/20.
 */
public class UploadFileReqData extends BasicTO {

    /**
     * 接口版本号，此处为10
     */
    private String version="10";

    /**
     * 此处为ICP_UPLOAD_ATTACHMENT
     *
     */
    private String command="ICP_UPLOAD_ATTACHMENT";

    /**
     * TP：第三方平台
     * AP：代理商平台
     */
    private String platform="TP";

    /**
     * 拉卡拉提供的机构代码
     */
    private String compOrgCode;

    /**
     * 进件号，进件ID和商户号必须填写一个
     */
    private String contractId;

    /**
     * 身份证正面: ID_CARD_FRONT
     * 身份证反面: ID_CARD_BEHIND
     * 银行卡: BANK_CARD
     * 营业执照: BUSINESS_LICENCE
     * 合影照片: PERSONAL_PHOTO
     * 商户照片: MERCHANT_PHOTO
     * 其他: OTHERS
     */
    private String type;

    /**
     * 商户号,进件ID和商户号必须填写一个
     */
    private String shopNo;

    /**
     * 要上传的图片数据。仅支持JPEG、GIF、PNG格式，为空返回错误。图片大小<5M。
     */
    private InputStream pic;

    private byte[] bytePic;



    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version=version;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command=command;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform=platform;
    }

    public String getCompOrgCode() {
        return compOrgCode;
    }

    public void setCompOrgCode(String compOrgCode) {
        this.compOrgCode=compOrgCode;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId=contractId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type=type;
    }

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo=shopNo;
    }

    public InputStream getPic() {
        return pic;
    }

    public void setPic(InputStream pic) {
        this.pic=pic;
    }

    public byte[] getBytePic() {
        return bytePic;
    }

    public void setBytePic(byte[] bytePic) {
        this.bytePic=bytePic;
    }

    @Override
    public String toString() {
        return "UploadFileReqData{" +
                "version='" + version + '\'' +
                ", command='" + command + '\'' +
                ", platform='" + platform + '\'' +
                ", compOrgCode='" + compOrgCode + '\'' +
                ", contractId='" + contractId + '\'' +
                ", type='" + type + '\'' +
                ", shopNo='" + shopNo + '\'' +
                '}';
    }
}
