package cn.aposoft.ecommerce.wechat.service.impl;

import cn.aposoft.ecommerce.wechat.beans.protocol.pay_protocol.WeChatPayReqData;
import cn.aposoft.ecommerce.wechat.config.BaseWechatConfig;
import cn.aposoft.ecommerce.wechat.params.OrderParams;
import cn.aposoft.ecommerce.wechat.service.BasePaymentService;
import cn.aposoft.ecommerce.wechat.tencent.WechatUtil;
import cn.aposoft.ecommerce.wechat.util.BeanConvertUtils;

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
        data.setAppid(config.getAppID())
                .setMch_id(config.getMchID())
                .setSub_appid(config.getSubAppId())
                .setSub_mch_id(config.getSubMchId())
        ;
        data.generateSign(config.getKey(), data);
        //TODO 下单请求参数转换
        return WechatUtil.ObjectToXml(data);
    }
}
