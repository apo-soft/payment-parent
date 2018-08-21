package cn.aposoft.ecommerce.wechat.exceptions;

/**
 * @author code
 * @Title: BasicException
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/14下午4:15
 */
public class BasicException extends Exception {

    private static final long serialVersionUID = 1L;

    public BasicException() {
        super();
    }

    public BasicException(String msg) {
        super(msg);
    }

    public BasicException(String msg, Throwable th) {
        super(msg, th);
    }

    public BasicException(Throwable th) {
        super(th);
    }
}
