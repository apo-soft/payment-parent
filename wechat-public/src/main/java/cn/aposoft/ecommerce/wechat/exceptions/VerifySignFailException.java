package cn.aposoft.ecommerce.wechat.exceptions;

/**
 * @author code
 * @Title: VerifySignFailException
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/9上午11:23
 */
public class VerifySignFailException extends BasicException {
    public VerifySignFailException() {
        super();
    }

    public VerifySignFailException(String msg) {
        super(msg);
    }

    public VerifySignFailException(String msg, Throwable t) {
        super(msg, t);
    }
}
