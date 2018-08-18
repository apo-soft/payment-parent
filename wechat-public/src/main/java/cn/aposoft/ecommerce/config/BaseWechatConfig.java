package cn.aposoft.ecommerce.config;

/**
 * @author code
 * @Title: BaseWechatConfig
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/18下午12:18
 */
public interface BaseWechatConfig {
    public String getAppID();

    public String getMchID();

    public String getSubAppId();

    public String getSubMchId();

    public String getKey();

    /**
     * 用户标识
     * <p>
     * trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。openid如何获取，可参考【获取openid】。企业号请使用【
     * 企业号OAuth2.0接口】获取企业号内成员userid，再调用【企业号userid转openid接口】进行转换
     */

    public String getOpenId();

    /**
     * 微信支付URL
     */

    public String getPayUrl();

    /**
     * 订单交易返回URL
     */

    public String getNotifyUrl();

    /**
     * 退款-请求URL
     */

    public String getRefundUrl();

    /**
     * 订单查询-请求URL
     */

    public String getOrderQueryUrl();

    public String getStatementPath();

    /**
     * 关闭订单URL
     */

    public String getCloseOrderUrl();

    /**
     * 下载订单对账单地址
     */

    public String getDownloadBillUrl();

    /**
     * 退款查询地址
     */

    public String getRefundQueryUrl();


    public String connectionsPerRoute();

    /**
     * 连接超时时间，毫秒
     *
     * @return
     */

    public int getHttpConnectTimeoutMs();

    /**
     * 读取超时时间，毫秒
     *
     * @return
     */

    public int getHttpReadTimeoutMs();


}
