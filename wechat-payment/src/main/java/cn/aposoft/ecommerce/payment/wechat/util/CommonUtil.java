package cn.aposoft.ecommerce.payment.wechat.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import cn.aposoft.ecommerce.payment.wechat.Config;

/**
 * 工具类
 * 
 * @author Yujinshui
 *
 */
@SuppressWarnings("unused")
public class CommonUtil {
	private static Logger logger = Logger.getLogger(CommonUtil.class);

	/**
	 * 双向证书认证部分
	 * 
	 * @param config
	 * @return
	 * @throws Exception
	 * @author Yujinshui
	 */
	public static CloseableHttpClient getPkcs12(Config config) throws Exception {
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		FileInputStream instream = new FileInputStream(new File(config.pkcs12()));
		try {
			keyStore.load(instream, config.mchId().toCharArray());
		} finally {
			instream.close();
		}

		// Trust own CA and all self-signed certs
		SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, config.mchId().toCharArray()).build();
		// Allow TLSv1 protocol only
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null,
				SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
		CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();

		return httpclient;
	}

	/**
	 * 金额转换[Integer]
	 * 
	 * @param object
	 * @return
	 * @author Yujinshui
	 */
	public static Integer parseNum(Object object) {
		Integer res = 0;
		if (object != null) {
			try {
				res = Integer.parseInt(object.toString());
			} catch (NumberFormatException e) {
				logger.error("input object:" + object + "    数字格式转换失败，请检查输入内容是否合法");
				e.printStackTrace();
			}
		}
		return res;
	}

}
