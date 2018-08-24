package cn.aposoft.ecommerce.wechat.service.impl;

import cn.aposoft.ecommerce.wechat.beans.protocol.BaseRequestBeans;
import cn.aposoft.ecommerce.wechat.beans.protocol.pay_protocol.WeChatPayReqData;
import cn.aposoft.ecommerce.wechat.beans.protocol.pay_query_protocol.WechatPayQueryReqData;
import cn.aposoft.ecommerce.wechat.config.BaseWechatConfig;
import cn.aposoft.ecommerce.wechat.params.OrderParams;
import cn.aposoft.ecommerce.wechat.params.OrderQueryParams;
import cn.aposoft.ecommerce.wechat.service.BasePaymentService;
import cn.aposoft.ecommerce.wechat.tencent.WechatConstant;
import cn.aposoft.ecommerce.wechat.tencent.WechatUtil;
import cn.aposoft.ecommerce.wechat.util.BeanConvertUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author code
 * @Title: AbstractBasePaymentService
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/22下午10:27
 */
public abstract class AbstractBasePaymentService implements BasePaymentService {

    /**
     * 转换为下单请求参数
     *
     * @param orderParams
     * @param config
     * @return
     */
    protected String createPayRequest(OrderParams orderParams, BaseWechatConfig config) throws Exception {


        WeChatPayReqData data = BeanConvertUtils.convert(orderParams, WeChatPayReqData.class);

        if (StringUtils.isEmpty(data.getSign_type())) {
            data.setSign_type(WechatConstant.HMACSHA256);//默认采用HMACSHA256签名方式处理
        }
        if (StringUtils.isEmpty(data.getNotify_url())) {
            data.setNotify_url(config.getNotifyUrl());//默认notify_url从配置文件中获取
        }

        setAccountData(config, data,WechatConstant.HMACSHA256);

        // 下单请求参数转换
        return WechatUtil.ObjectToXml(data);
    }


    protected String createQueryRequest(OrderQueryParams orderQueryParams, BaseWechatConfig config) throws Exception {
        WechatPayQueryReqData data = BeanConvertUtils.convert(orderQueryParams, WechatPayQueryReqData.class);
        setAccountData(config, data,WechatConstant.MD5);
        // 下单请求参数转换
        return WechatUtil.ObjectToXml(data);
    }

    private void setAccountData(BaseWechatConfig config, BaseRequestBeans data,String signType) {
        data.setAppid(config.getAppID())
                .setMch_id(config.getMchID())
                .setSub_appid(config.getSubAppId())
                .setSub_mch_id(config.getSubMchId())
        ;

        data.generateSign(config.getKey(), data,signType);

    }
}
