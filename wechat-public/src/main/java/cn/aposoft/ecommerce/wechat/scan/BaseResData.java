package cn.aposoft.ecommerce.wechat.scan;

/**
 * Created by lisong on 16/6/20.
 */
public class BaseResData extends BasicTO {

    private String responseCode;
    private String message;
    private String MAC;

    public static final String SUCCESS_CODE="000000";

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

    public String getMAC() {
        return MAC;
    }

    public void setMAC(String MAC) {
        this.MAC=MAC;
    }
}
