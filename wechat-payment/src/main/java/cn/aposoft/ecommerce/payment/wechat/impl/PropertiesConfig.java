/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import cn.aposoft.ecommerce.payment.wechat.Config;

/**
 * 从配置文件进行读取微信支付服务端配置项
 * <p>
 * 配置文件默认名称：wechatpay.properties<br>
 * 可以指定配置文件名称
 * 
 * @author Yujinshui
 */
public class PropertiesConfig implements Config {
	private static Logger logger = Logger.getLogger(PropertiesConfig.class);
	/**
	 * 订单查询URL
	 */
	private String ORDER_URL = null;
	/**
	 * 认证证书路径
	 */
	private String PKCS12 = null;
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
	 * 微信支付-请求URL
	 */
	private String URL = null;
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
	 * 
	 * @param p
	 *            属性信息
	 * @author Yujinshui
	 * @time 2015年10月25日 上午11:57:18
	 */
	public void setPropertiesValues(Properties p) {
		APPID = p.getProperty("APPID");
		MCH_ID = p.getProperty("MCH_ID");
		KEY = p.getProperty("KEY");
		URL = p.getProperty("URL");
		NOTIFY_URL = p.getProperty("NOTIFY_URL");
		REFUND_URL = p.getProperty("REFUND_URL");
		ORDER_URL = p.getProperty("ORDER_URL");
		CLOSE_ORDER_URL = p.getProperty("CLOSE_ORDER_URL");
		REFUND_QUERY_URL = p.getProperty("REFUND_QUERY_URL");
		DOWNLOAD_BILL_URL = p.getProperty("DOWNLOAD_BILL_URL");
		PKCS12 = p.getProperty("PKCS12");
	}

	/**
	 * 其他方式输入配置内容
	 * <p>
	 * [商户APPID]APPID<br>
	 * [商户ID]MCH_ID<br>
	 * [商户KEY]KEY<br>
	 * [微信支付-请求URL]URL<br>
	 * [退款-请求URL]REFUND_URL<br>
	 * [订单查询-请求URL]ORDER_URL<br>
	 * [认证证书路径]PKCS12
	 */
	public PropertiesConfig(Map<String, String> map) {
		APPID = map.get("APPID");
		MCH_ID = map.get("MCH_ID");
		KEY = map.get("KEY");
		URL = map.get("URL");
		NOTIFY_URL = map.get("NOTIFY_URL");
		REFUND_URL = map.get("REFUND_URL");
		ORDER_URL = map.get("ORDER_URL");
		CLOSE_ORDER_URL = map.get("CLOSE_ORDER_URL");
		REFUND_QUERY_URL = map.get("REFUND_QUERY_URL");
		DOWNLOAD_BILL_URL = map.get("DOWNLOAD_BILL_URL");
		PKCS12 = map.get("PKCS12");
	}

	public PropertiesConfig(String fileName) {
		getProperties(fileName);
	}

	/**
	 * 通过读取默认配置文件加载微信支付的商户及系统配置信息
	 * <p>
	 * 读取默认配置文件 : classpath:wechatpay.properties
	 */
	public PropertiesConfig() {
		getProperties("wechatpay.properties");
	}

	/**
	 * 通过读取指定位置配置文件加载微信支付的商户及系统配置信息
	 * <p>
	 * 用于开发人员进行测试使用，以防误操作上传真实配置文件内容
	 * 
	 * @param fileName
	 *            文件路径+名称[E:/wechat/wechatpay.properties]
	 * @param encoding
	 *            读取编码
	 * @author Yujinshui
	 * @time 2015年10月25日 上午11:52:08
	 */
	public PropertiesConfig(String fileName, String encoding) {
		getFileProperties(fileName, encoding);
	}

	private void getFileProperties(String fileName, String encoding) {
		InputStreamReader reader = null;
		try {
			reader = new InputStreamReader(new FileInputStream(fileName), encoding);
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			System.out.println("读取指定路径配置失败。" + fileName);
			logger.error("读取指定路径配置文件失败，请检查文件是否存在。" + fileName);
			e.printStackTrace();
		}
		Properties p = new Properties();
		try {
			p.load(reader);
		} catch (IOException e1) {
			System.out.println("配置文件读取失败，请检查.");
			e1.printStackTrace();
		}
		setPropertiesValues(p);
	}

	/**
	 * 读取项目配置文件参数
	 * 
	 * @param fileName
	 * @author Yujinshui
	 */
	private void getProperties(String fileName) {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			System.out.println("配置文件读取失败，请检查.");
			e1.printStackTrace();
		}
		setPropertiesValues(p);
	}

	/**
	 * 认证证书安装位置
	 */
	@Override
	public String pkcs12() {
		return PKCS12;
	}

	/*
	 * 私有key,用于MD5加密 , 不能暴露
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.Config#key()
	 */
	@Override
	public String key() {
		return KEY;
	}

	/**
	 * 应用id
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.Config#appId()
	 */
	@Override
	public String appId() {
		return APPID;
	}

	/**
	 * 商户号
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.Config#mchId()
	 */
	@Override
	public String mchId() {
		return MCH_ID;
	}

	/**
	 * 微信支付URL
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.Config#url()
	 */
	@Override
	public String url() {
		return URL;
	}

	/**
	 * 订单交易返回URL
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.Config#notifyUrl()
	 */
	@Override
	public String notifyUrl() {
		return NOTIFY_URL;
	}

	/**
	 * 退款-请求URL
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.Config#refundUrl()
	 */
	@Override
	public String refundUrl() {
		return REFUND_URL;
	}

	/**
	 * 订单查询-请求URL
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.Config#orderUrl()
	 */
	@Override
	public String orderUrl() {
		return ORDER_URL;
	}

	/**
	 * 关闭订单URL
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.Config#closeOrderUrl()
	 */
	@Override
	public String closeOrderUrl() {
		return CLOSE_ORDER_URL;
	}

	/**
	 * 下载订单对账单地址
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.Config#closeOrderUrl()
	 */
	@Override
	public String downloadBillUrl() {
		return DOWNLOAD_BILL_URL;
	}

	/**
	 * 退款查询地址
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.Config#closeOrderUrl()
	 */
	@Override
	public String refundQueryUrl() {
		return REFUND_QUERY_URL;
	}

}
