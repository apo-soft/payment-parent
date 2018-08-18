package cn.aposoft.ecommerce.wechat.scan.beans.protocol;

import cn.aposoft.ecommerce.tencent.WechatSignature;
import cn.aposoft.ecommerce.tencent.WechatUtil;
import cn.aposoft.ecommerce.util.LogPortal;
import org.apache.commons.lang3.StringUtils;

/**
 * @author code
 * @Title: BaseRequestBeans
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/11上午11:56
 */
public class BaseRequestBeans {
    private String appid;
    private String mch_id;
    private String sub_appid;
    private String sub_mch_id;
    private String nonce_str;
    private String sign;

    public String getAppid() {
        return appid;
    }

    //TODO 后期把它抽掉，改为赋值过程进行sign的生成
    public void generateSign(String key, Object obj) {
        //随机字符串，不长于32 位
        if (StringUtils.isEmpty(getNonce_str())) {//如果已赋值，不再重复赋值
            setNonce_str(WechatUtil.generateNonceStr());
        }
        //根据API给的签名规则进行签名
        String sign = null;
        try {
            sign = WechatSignature.generateSignatureWithHMACSHA256(WechatUtil.objectToMap(obj), key);
        } catch (Exception e) {
            LogPortal.error("微信对账单下载参数，签名创建异常", e);
        }
        setSign(sign);//把签名数据设置到Sign这个属性中
    }

    public BaseRequestBeans setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getMch_id() {
        return mch_id;
    }

    public BaseRequestBeans setMch_id(String mch_id) {
        this.mch_id = mch_id;
        return this;
    }

    public String getSub_appid() {
        return sub_appid;
    }

    public BaseRequestBeans setSub_appid(String sub_appid) {
        this.sub_appid = sub_appid;
        return this;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public BaseRequestBeans setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
        return this;
    }


    public String getNonce_str() {
        return nonce_str;
    }

    public BaseRequestBeans setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public BaseRequestBeans setSign(String sign) {
        this.sign = sign;
        return this;
    }
}
