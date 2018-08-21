package cn.aposoft.ecommerce.wechat.exceptions;

/**
 * 微信配置参数为空异常
 *
 * @author code
 * @Title: WechatConfigNullException
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/21下午8:05
 */
public class WechatConfigNullException extends BasicException {

    public WechatConfigNullException(){
        super();
    }
    public WechatConfigNullException(String msg){
        super(msg);
    }
}
