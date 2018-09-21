package cn.aposoft.ecommerce.wechat.config;

import java.io.*;
import java.util.Map;
import java.util.Properties;

/**
 * @author code
 * @Title: WechatPubPropertiesConfig
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/11上午11:43
 */
public class WechatPubPropertiesConfig implements BaseWechatConfig {

    /**
     * 单一主机最大并发连接数:默认为2,这里进行动态配置,避免高并发时,因此导致支付阻塞.
     */
    private String CONNECTIONS_PER_ROUTE = "20";
    /**
     * 订单查询URL
     */
    private String ORDER_QUERY_URL = null;
    /**
     * 认证证书路径
     */
    private String PKCS12_PATH = null;

    /**
     * 商户KEY
     */
    private String KEY = null;
    /**
     * 商户APPID
     */
    private String APPID = null;
    /**
     * 商户ID
     */
    private String MCH_ID = null;
    /**
     * 对账单存储路径
     */
    private String STATEMENT_FILE_PATH = null;

    /**
     * 子商户ID
     *
     * @author code
     * @date 2018/8/13 上午9:26
     * @param null
     * @return
     */
    private String SUB_APPID;

    /**
     * 子商户号
     *
     * @author code
     * @date 2018/8/13 上午9:27
     * @param null
     * @return
     */
    private String SUB_MCH_ID;

    /**
     * 微信支付-请求URL
     */
    private String PAY_URL = null;
    /**
     * 退款-请求URL
     */
    private String REFUND_URL = null;
    /**
     * 关闭订单URL
     */
    private String CLOSE_ORDER_URL = null;
    /**
     * 支付成功提醒反馈URL地址
     */
    private String NOTIFY_URL;

    /**
     * 退款查询URL
     */
    private String REFUND_QUERY_URL;

    /**
     * 下载订单对账单地址
     */
    private String DOWNLOAD_BILL_URL;

    /**
     * 配置参数赋值
     * <p>
     * [商户APPID]APPID<br>
     * [商户ID]MCH_ID<br>
     * [用户标识]OPENID<br>
     * [商户KEY]KEY<br>
     * [微信支付-请求URL]PAY_URL<br>
     * [退款-请求URL]REFUND_URL<br>
     * [订单查询-请求URL]ORDER_QUERY_URL<br>
     * [认证证书路径]PKCS12_PATH
     *
     * @param p 属性信息
     * @author Yujinshui
     * @time 2015年10月25日 上午11:57:18
     */
    public void setPropertiesValues(Properties p) {
        APPID = p.getProperty("APPID");
        MCH_ID = p.getProperty("MCH_ID");
        KEY = p.getProperty("KEY");
        PAY_URL = p.getProperty("PAY_URL");
        NOTIFY_URL = p.getProperty("NOTIFY_URL");
        REFUND_URL = p.getProperty("REFUND_URL");
        ORDER_QUERY_URL = p.getProperty("ORDER_QUERY_URL");
        CLOSE_ORDER_URL = p.getProperty("CLOSE_ORDER_URL");
        REFUND_QUERY_URL = p.getProperty("REFUND_QUERY_URL");
        DOWNLOAD_BILL_URL = p.getProperty("DOWNLOAD_BILL_URL");
        PKCS12_PATH = p.getProperty("PKCS12_PATH");

        CONNECTIONS_PER_ROUTE = p.getProperty("CONNECTIONS_PER_ROUTE");
        SUB_MCH_ID = p.getProperty("SUB_MCH_ID");
        SUB_APPID = p.getProperty("SUB_APPID");
        STATEMENT_FILE_PATH = p.getProperty("STATEMENT_FILE_PATH");
    }

    /**
     * 其他方式输入配置内容
     * <p>
     * [商户APPID]APPID<br>
     * [商户ID]MCH_ID<br>
     * [用户标识]OPENID<br>
     * [商户KEY]KEY<br>
     * [微信支付-请求URL]PAY_URL<br>
     * [退款-请求URL]REFUND_URL<br>
     * [订单查询-请求URL]ORDER_QUERY_URL<br>
     * [认证证书路径]PKCS12_PATH
     */
    public WechatPubPropertiesConfig(Map<String, String> map) {
        APPID = map.get("APPID");
        MCH_ID = map.get("MCH_ID");
        KEY = map.get("KEY");
        PAY_URL = map.get("PAY_URL");
        NOTIFY_URL = map.get("NOTIFY_URL");
        REFUND_URL = map.get("REFUND_URL");
        ORDER_QUERY_URL = map.get("ORDER_QUERY_URL");
        CLOSE_ORDER_URL = map.get("CLOSE_ORDER_URL");
        REFUND_QUERY_URL = map.get("REFUND_QUERY_URL");
        DOWNLOAD_BILL_URL = map.get("DOWNLOAD_BILL_URL");
        PKCS12_PATH = map.get("PKCS12_PATH");
        /** add yujinshui 2016-02-02 */
        CONNECTIONS_PER_ROUTE = map.get("CONNECTIONS_PER_ROUTE");
        SUB_MCH_ID = map.get("SUB_MCH_ID");
        SUB_APPID = map.get("SUB_APPID");
        STATEMENT_FILE_PATH = map.get("STATEMENT_FILE_PATH");
    }

    public WechatPubPropertiesConfig(String fileName) {
        getProperties(fileName);
    }

    /**
     * 通过读取默认配置文件加载微信支付的商户及系统配置信息
     * <p>
     * 读取默认配置文件 : classpath:wechatpay.properties
     */
    public WechatPubPropertiesConfig() {
        getProperties("wechatpub.properties");
    }

    /**
     * 通过读取指定位置配置文件加载微信支付的商户及系统配置信息
     * <p>
     * 用于开发人员进行测试使用，以防误操作上传真实配置文件内容
     *
     * @param fileName 文件路径+名称[E:/wechat/wechatpay.properties]
     * @param encoding 读取编码
     * @author Yujinshui
     * @time 2015年10月25日 上午11:52:08
     */
    public WechatPubPropertiesConfig(String fileName, String encoding) {
        getFileProperties(fileName, encoding);
    }

    private void getFileProperties(String fileName, String encoding) {
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(fileName), encoding);
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            throw new RuntimeException("初始化微信支付过程中,读取配置文件失败,配置文件[classpath:" + fileName + "]，请检查.", e);
        }
        Properties p = new Properties();
        try {
            p.load(reader);
        } catch (IOException e) {
            throw new RuntimeException("初始化微信支付过程中,读取配置文件失败,配置文件[classpath:" + fileName + "]，请检查.", e);

        }
        setPropertiesValues(p);
    }

    /**
     * 读取项目配置文件参数
     * <p>
     * 采用ISO-8859-1默认字符集
     *
     * @param fileName
     * @author Yujinshui
     */
    private void getProperties(String fileName) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        Properties p = new Properties();
        try {
            p.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("初始化微信支付过程中,读取配置文件失败,配置文件[classpath:" + fileName + "]，请检查.", e);
        }
        setPropertiesValues(p);
    }


    @Override
    public String getSubAppId() {
        return SUB_APPID;
    }

    @Override
    public String getSubMchId() {
        return SUB_MCH_ID;
    }


    /**
     * 微信支付URL
     */
    @Override
    public String getPayUrl() {
        return PAY_URL;
    }

    /**
     * 订单交易返回URL
     */
    @Override
    public String getNotifyUrl() {
        return NOTIFY_URL;
    }

    /**
     * 退款-请求URL
     */
    @Override
    public String getRefundUrl() {
        return REFUND_URL;
    }

    /**
     * 订单查询-请求URL
     */
    @Override
    public String getOrderQueryUrl() {
        return ORDER_QUERY_URL;
    }

    @Override
    public String getStatementPath() {
        return STATEMENT_FILE_PATH;
    }

    /**
     * 关闭订单URL
     */
    @Override
    public String getCloseOrderUrl() {
        return CLOSE_ORDER_URL;
    }

    /**
     * 下载订单对账单地址
     */
    @Override
    public String getDownloadBillUrl() {
        return DOWNLOAD_BILL_URL;
    }

    /**
     * 退款查询地址
     */
    @Override
    public String getRefundQueryUrl() {
        return REFUND_QUERY_URL;
    }

    @Override
    public String connectionsPerRoute() {
        return CONNECTIONS_PER_ROUTE;
    }


    /**
     * 连接超时时间，毫秒
     *
     * @return
     */
    @Override
    public int getHttpConnectTimeoutMs() {
        return 60 * 1000;
    }

    /**
     * 读取超时时间，毫秒
     *
     * @return
     */
    @Override
    public int getHttpReadTimeoutMs() {
        return 60 * 1000;
    }


    @Override
    public String getAppID() {
        return APPID;
    }

    @Override
    public String getMchID() {
        return MCH_ID;
    }

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public InputStream getCertStream() throws Exception {
        return new FileInputStream(new File(PKCS12_PATH));
    }
}
