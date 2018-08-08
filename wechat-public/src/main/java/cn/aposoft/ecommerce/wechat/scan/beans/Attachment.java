package cn.aposoft.ecommerce.wechat.scan.beans;

/**
 * Created by lisong on 16/5/31.
 */
public class Attachment {
    private String attachmentName;
    private String attachmentKind;
    private String attachmentType;

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName=attachmentName;
    }

    public String getAttachmentKind() {
        return attachmentKind;
    }

    public void setAttachmentKind(String attachmentKind) {
        this.attachmentKind=attachmentKind;
    }

    public String getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(String attachmentType) {
        this.attachmentType=attachmentType;
    }
}
