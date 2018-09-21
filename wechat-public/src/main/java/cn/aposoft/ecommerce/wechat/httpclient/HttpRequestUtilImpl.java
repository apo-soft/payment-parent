package cn.aposoft.ecommerce.wechat.httpclient;

import cn.aposoft.ecommerce.wechat.config.BaseWechatConfig;
import cn.aposoft.ecommerce.wechat.util.LogPortal;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author code
 * @Title: HttpRequestUtilImpl
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/21下午9:09
 */
public class HttpRequestUtilImpl implements HttpRequestUtil {

    // 单一主机最大并发连接数:默认为2,这里增大到200,避免高并发时,因此导致支付阻塞.
    private int connectionPerRoute = 200;
    //连接超时时间，毫秒
    private int httpConnectTimeoutMs = 60 * 1000;
    //读取超时时间，毫秒
    private int httpReadTimeoutMs = 60 * 1000;
    // 用于发送普通http连接的client
    private CloseableHttpClient client = null;

    // 用于发送https带有证书的连接client
    private final ConcurrentMap<String, CloseableHttpClient> httpsClients = new ConcurrentHashMap<String, CloseableHttpClient>();


    private HttpRequestUtilImpl() {
        this(200, 60 * 1000, 60 * 1000);
    }

    private HttpRequestUtilImpl(int connectionPerRoute, int httpConnectTimeoutMs, int httpReadTimeoutMs) {
        this.connectionPerRoute = connectionPerRoute;
        this.httpConnectTimeoutMs = httpConnectTimeoutMs;
        this.httpReadTimeoutMs = httpReadTimeoutMs;
        client = createHttpClient();
    }

    @Override
    public String post(String request, BaseWechatConfig config, String url) throws IOException {

        return generalPost(request, url, client);
    }


    @Override
    public String keyCertPost(String request, BaseWechatConfig config, String url) throws Exception {
        return generalPost(request, url, getHttpsClient(config));
    }


    private CloseableHttpClient createHttpClient() {
        // 因微信的服务器响应延时大约为500ms~~1.5s,因此有必要增加单一点对点最大连接数,在下一步优化中应放入配置文件里
        CloseableHttpClient client = HttpClients.custom().setMaxConnPerRoute(connectionPerRoute)
                .setMaxConnTotal(connectionPerRoute).build();
        return client;
    }

    /**
     * 获取该类的实例
     *
     * @param config
     * @return
     */
    public static final HttpRequestUtilImpl getInstance(BaseWechatConfig config) {
        int connectionPerRoute = 200;
        //连接超时时间，毫秒
        int httpConnectTimeoutMs = 60 * 1000;
        //读取超时时间，毫秒
        int httpReadTimeoutMs = 60 * 1000;
        if (StringUtils.isNotEmpty(config.connectionsPerRoute())) {
            connectionPerRoute = Integer.valueOf(config.connectionsPerRoute());
        }
        if (config.getHttpConnectTimeoutMs() > 0) {
            httpConnectTimeoutMs = config.getHttpConnectTimeoutMs();
        }
        if (config.getHttpReadTimeoutMs() > 0) {
            httpReadTimeoutMs = config.getHttpReadTimeoutMs();
        }

        return new HttpRequestUtilImpl(connectionPerRoute, httpConnectTimeoutMs, httpReadTimeoutMs);
    }

    /**
     * 返回配置微信商户的p12文件的加密连接客户端
     *
     * @return
     */
    private CloseableHttpClient getHttpsClient(BaseWechatConfig config) {

        CloseableHttpClient httpsClient = httpsClients.get(config.getMchID());
        if (httpsClient == null) {
            try {
                //putIfAbsent方法保证返回值为同一个，该方法本身赋值后便会有对应的返回值返回
                httpsClient = httpsClients.putIfAbsent(config.getMchID(), getPkcs12Client(config));
                if (httpsClient == null) {
                    httpsClient = httpsClients.get(config.getMchID());
                }
            } catch (Exception e) {
                LogPortal.error("当执行微信交易过程中,尝试创建客户端失败,请检查.", e);
            }
        }
        return httpsClient;
    }

    private CloseableHttpClient getPkcs12Client(BaseWechatConfig config) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        InputStream instream = null;

        instream = config.getCertStream();

        try {
            keyStore.load(instream, config.getMchID().toCharArray());
        } finally {
            instream.close();
        }
        // Trust own CA and all self-signed certs
        // 私有key在微信中默认以mchId作为密钥
        SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, config.getMchID().toCharArray()).build();
        // Allow TLSv1 protocol only
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[]{"TLSv1"}, null,
                SSLConnectionSocketFactory.getDefaultHostnameVerifier());
        CloseableHttpClient httpclient = HttpClients.custom().setMaxConnPerRoute(connectionPerRoute)
                .setMaxConnTotal(connectionPerRoute).setSSLSocketFactory(sslsf).build();

        return httpclient;
    }

    /**
     * 发起post请求
     *
     * @param request
     * @param url
     * @param httpsClient
     * @return
     */
    private String generalPost(String request, String url, CloseableHttpClient httpsClient) {
        HttpPost httpPost = createHttpPost(request, url);
        String result = "";
        try {
            LogPortal.info("Request:{url:" + url + ", body: " + request + "}");
            result = execute(httpsClient, httpPost);
            LogPortal.info("Response:{url:" + url + ", body: " + result + "}");
        } catch (ParseException e) {
            LogPortal.error(
                    "Exception:{ message: WeChatPay 请求远程服务时发生 ParseException! " + e.getMessage() + "}",
                    e);
        } catch (IOException e) {
            LogPortal.error("Exception:{ message: WeChatPay 请求远程服务时发生 IOException! " + e.getMessage() + "}",
                    e);
        }
        return result;
    }

    /**
     * 发起调用HTTP请求操作
     *
     * @param httpsClient
     * @param httpPost
     * @return
     * @throws IOException
     */
    private String execute(CloseableHttpClient httpsClient, HttpPost httpPost) throws IOException {

        CloseableHttpResponse response = httpsClient.execute(httpPost);
        return EntityUtils.toString(response.getEntity(), "UTF-8");
    }

    /**
     * 创建httpPost
     *
     * @param request
     * @param url
     * @return
     */
    private HttpPost createHttpPost(String request, String url) {
        // 定义POST请求
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(httpReadTimeoutMs).setConnectTimeout(httpConnectTimeoutMs).build();
        httpPost.setConfig(requestConfig);
        StringEntity postEntity = new StringEntity(request, "UTF-8");
        httpPost.addHeader("Content-Type", "text/xml");
        httpPost.setEntity(postEntity);
        return httpPost;
    }

    /**
     * 当应用停止时,应调用此方法,避免由未释放资源需要释放
     *
     * @throws IOException
     */
    @Override
    public void close() throws IOException {
        IOException ex = null;
        try {
            if (client != null) {
                client.close();
            }
        } catch (IOException e) {
            ex = e;
        }
        for (CloseableHttpClient client1 : httpsClients.values()) {
            if (client1 != null) {
                try {
                    client1.close();
                } catch (IOException e) {
                    if (ex == null) {
                        ex = e;
                    }
                }
            }
        }
        if (ex != null) {
            throw ex;
        }
    }
}
