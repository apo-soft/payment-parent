package cn.aposoft.ecommerce.wechat.httpclient;

import cn.aposoft.ecommerce.wechat.config.BaseWechatConfig;

import java.io.IOException;

/**
 * @author code
 * @Title: HttpRequestUtil
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/21下午9:06
 */
public interface HttpRequestUtil {
    /**
     * 支付post
     *
     * @param request
     * @param config
     * @param url
     *            请求的url地址
     * @return
     * @author Yujinshui
     * @throws IOException
     */
    String post(String request, BaseWechatConfig config, String url) throws IOException;

    /**
     * 退款post
     *
     * @param request
     * @param config
     * @param url
     *            请求的url地址
     * @return
     * @throws Exception
     * @author Yujinshui
     */
    String keyCertPost(String request, BaseWechatConfig config, String url) throws Exception;

}
