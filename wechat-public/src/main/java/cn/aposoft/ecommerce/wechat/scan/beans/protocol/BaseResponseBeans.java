package cn.aposoft.ecommerce.wechat.scan.beans.protocol;

/**
 * @author code
 * @Title: BaseResponseBeans
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/11下午12:00
 */
public class BaseResponseBeans extends BaseRequestBeans {
    //协议层
    private String return_code;
    private String return_msg;

    public String getReturn_code() {
        return return_code;
    }

    public BaseResponseBeans setReturn_code(String return_code) {
        this.return_code = return_code;
        return this;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public BaseResponseBeans setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
        return this;
    }
}
