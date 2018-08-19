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
     * 获取base64加密后的证书内容
     *
     * @return
     */
    public String getPKCS12_BASE64();

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
