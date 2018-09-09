package cn.aposoft.ecommerce.wechat.beans.invoke;

import cn.aposoft.ecommerce.wechat.config.BaseWechatConfig;
import cn.aposoft.ecommerce.wechat.enums.SignTypeEnum;

import java.io.Serializable;

/**
 * http或者https调用请求参数信息
 *
 * @author code
 * @Title: HttpInvokeParams
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/9上午11:28
 */
public class HttpInvokeParams<T> implements Serializable {

    private Object requestParams;
    private BaseWechatConfig config;
    private Class requestBean;
    private Class<T> responseBean;
    private String url;

    private SignTypeEnum signTypeEnum;


    public Object getRequestParams() {
        return requestParams;
    }

    public HttpInvokeParams setRequestParams(Object requestParams) {
        this.requestParams = requestParams;
        return this;
    }

    public BaseWechatConfig getConfig() {
        return config;
    }

    public HttpInvokeParams setConfig(BaseWechatConfig config) {
        this.config = config;
        return this;
    }

    public Class getRequestBean() {
        return requestBean;
    }

    public HttpInvokeParams setRequestBean(Class requestBean) {
        this.requestBean = requestBean;
        return this;
    }

    public Class<T> getResponseBean() {
        return responseBean;
    }

    public HttpInvokeParams setResponseBean(Class<T> responseBean) {
        this.responseBean = responseBean;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public HttpInvokeParams setUrl(String url) {
        this.url = url;
        return this;
    }

    public SignTypeEnum getSignTypeEnum() {
        return signTypeEnum;
    }

    public HttpInvokeParams setSignTypeEnum(SignTypeEnum signTypeEnum) {
        this.signTypeEnum = signTypeEnum;
        return this;
    }
}
