/**
 * 
 */
package cn.aposoft.ecommerce.payment.alipay.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import cn.aposoft.ecommerce.payment.alipay.AliConfig;

/**
 * 从配置文件进行读取微信支付服务端配置项
 * <p>
 * 配置文件默认名称：wechatpay.properties<br>
 * 可以指定配置文件名称
 * 
 * @author Yujinshui
 */
public class AliPropertiesConfig implements AliConfig {
	private static Logger logger = Logger.getLogger(AliPropertiesConfig.class);
	/**
	 * 二维码订单业务类型 product_code
	 */
	private String QR_CODE_PRODUCT;

	/**
	 * 商户的私钥
	 */
	private String PRIVATE_KEY;
	/**
	 * [必填]商户key
	 */
	private String KEY;
	/**
	 * [必填]合作身份者ID，以2088开头由16位纯数字组成的字符串
	 */
	private String PID;
	/**
	 * 支付宝分配给开发者的应用Id
	 */
	private String APPID;
	/**
	 * [必填]请求使用的编码格式，如utf-8(推荐),gbk,gb2312等
	 */
	private String CHARSET;
	/**
	 * [必填]签名方式 不需修改
	 */
	private String SIGN_TYPE;

	/**
	 * 调用的接口版本，固定为：1.0
	 */
	private String VERSION;
	/**
	 * [接口异步通知url ]支付宝服务器主动通知商户服务器里指定的页面http路径。
	 */
	private String NOTIFY_URL;
	/**
	 * 支付宝的公钥，无需修改该值
	 */
	private String ALI_PUBLIC_KEY;

	/**
	 * [必填]支付宝通用网关接口
	 */
	private String ALI_GATEWAY;

	/**
	 * 日志存放路径
	 */
	private String LOG_PATH;
	/**
	 * 扫码支付的方式，支持前置模式和跳转模式。
	 * 
	 * <pre>
	前置模式是将二维码前置到商户的订单确认页的模式。需要商户在自己的页面中以iframe方式请求支付宝页面。具体分为以下3种：
	
	    0：订单码-简约前置模式，对应iframe宽度不能小于600px，高度不能小于300px；
	    1：订单码-前置模式，对应iframe宽度不能小于300px，高度不能小于600px；
	    3：订单码-迷你前置模式，对应iframe宽度不能小于75px，高度不能小于75px。
	
	跳转模式下，用户的扫码界面是由支付宝生成的，不在商户的域名下。
	
	    2：订单码-跳转模式
	 * </pre>
	 */
	private String QR_PAY_MODE;

	/**
	 * 其他方式输入配置内容
	 * <p>
	 */
	public AliPropertiesConfig(Map<String, String> map) {
		QR_CODE_PRODUCT = map.get("QR_CODE_PRODUCT");
		PRIVATE_KEY = map.get("PRIVATE_KEY");
		KEY = map.get("KEY");// [必填]
		PID = map.get("PID");// [必填]
		APPID = map.get("APPID");
		CHARSET = map.get("CHARSET");// [必填]
		SIGN_TYPE = map.get("SIGN_TYPE");// [必填]
		VERSION = map.get("VERSION");
		NOTIFY_URL = map.get("NOTIFY_URL");
		ALI_PUBLIC_KEY = map.get("ALI_PUBLIC_KEY");
		ALI_GATEWAY = map.get("ALI_GATEWAY");// [必填]
		LOG_PATH = map.get("LOG_PATH");
		QR_PAY_MODE = map.get("QR_PAY_MODE");

	}

	/**
	 * 指定配置文件在项目中的路径+名称
	 * 
	 * @param fileName
	 */
	public AliPropertiesConfig(String fileName) {
		getProperties(fileName);
	}

	/**
	 * 通过读取默认配置文件加载微信支付的商户及系统配置信息
	 * <p>
	 * 读取默认配置文件 : classpath:alipay.properties
	 */
	public AliPropertiesConfig() {
		getProperties("alipay.properties");
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
	public AliPropertiesConfig(String fileName, String encoding) {
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
		} catch (IOException e1) {
			System.out.println("配置文件读取失败，请检查.");
			e1.printStackTrace();
		}
		setPropertiesValues(p);
	}

	/**
	 * 配置参数赋值
	 * 
	 * @param p
	 *            属性信息
	 * @author Yujinshui
	 * @time 2015年10月25日 上午11:57:18
	 */
	private void setPropertiesValues(Properties p) {
		QR_CODE_PRODUCT = p.getProperty("QR_CODE_PRODUCT");
		PRIVATE_KEY = p.getProperty("PRIVATE_KEY");
		KEY = p.getProperty("KEY");
		PID = p.getProperty("PID");
		APPID = p.getProperty("APPID");
		CHARSET = p.getProperty("CHARSET");
		SIGN_TYPE = p.getProperty("SIGN_TYPE");
		VERSION = p.getProperty("VERSION");
		NOTIFY_URL = p.getProperty("NOTIFY_URL");
		ALI_PUBLIC_KEY = p.getProperty("ALI_PUBLIC_KEY");
		ALI_GATEWAY = p.getProperty("ALI_GATEWAY");
		LOG_PATH = p.getProperty("LOG_PATH");
		QR_PAY_MODE = p.getProperty("QR_PAY_MODE");
	}

	public String toString() {

		return "QR_CODE_PRODUCT=" + QR_CODE_PRODUCT + "\r\n"//
				+ "PRIVATE_KEY=" + PRIVATE_KEY + "\r\n"//
				+ "KEY=" + KEY + "\r\n"//
				+ "PID=" + PID + "\r\n"//
				+ "APPID=" + APPID + "\r\n"//
				+ "CHARSET=" + CHARSET + "\r\n"//
				+ "SIGN_TYPE=" + SIGN_TYPE + "\r\n"//
				+ "VERSION=" + VERSION + "\r\n"//
				+ "NOTIFY_URL=" + NOTIFY_URL + "\r\n"//
				+ "ALI_PUBLIC_KEY=" + ALI_PUBLIC_KEY + "\r\n"//
				+ "ALI_GATEWAY=" + ALI_GATEWAY + "\r\n"//
				+ "QR_PAY_MODE=" + QR_PAY_MODE + "\r\n";
	}

	/**
	 * 二维码订单业务类型 product_code
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月26日 下午6:47:34
	 */
	@Override
	public String qr_code_product() {
		return QR_CODE_PRODUCT;
	}

	/**
	 * 商户的私钥 [源自官网demo说明]
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.AliConfig.alipay.Config#private_key()
	 */
	@Override
	public String private_key() {
		return PRIVATE_KEY;
	}

	/**
	 * 商户key
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.AliConfig.alipay.Config#key()
	 */
	@Override
	public String key() {
		return KEY;
	}

	/**
	 * <font color=red>*</font>合作身份者ID[partner]，以2088开头由16位纯数字组成的字符串
	 * [源自官网demo说明]
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.AliConfig.alipay.Config#pid()
	 */
	@Override
	public String pid() {
		return PID;
	}

	/**
	 * 支付宝分配给开发者的应用Id
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.AliConfig.alipay.Config#appid()
	 */
	@Override
	public String appid() {
		return APPID;
	}

	/**
	 * 请求使用的编码格式，如utf-8(推荐),gbk,gb2312等
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.AliConfig.alipay.Config#charset()
	 */
	@Override
	public String charset() {
		return CHARSET;
	}

	/**
	 * <font color=red>*</font>签名方式 不需修改 [源自官网demo说明]
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.AliConfig.alipay.Config#sign_type()
	 */
	@Override
	public String sign_type() {
		return SIGN_TYPE;
	}

	/**
	 * 调用的接口版本，固定为：1.0
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.AliConfig.alipay.Config#version()
	 */
	@Override
	public String version() {
		return VERSION;
	}

	/**
	 * [接口异步通知url ]支付宝服务器主动通知商户服务器里指定的页面http路径。
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.AliConfig.alipay.Config#notify_url()
	 */
	@Override
	public String notify_url() {
		return NOTIFY_URL;
	}

	/**
	 * 支付宝的公钥，无需修改该值 [源自官网demo说明]
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.AliConfig.alipay.Config#ali_public_key()
	 */
	@Override
	public String ali_public_key() {
		return ALI_PUBLIC_KEY;
	}

	/**
	 * 支付宝通用网关接口
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.AliConfig.alipay.Config#ali_gateway()
	 */
	@Override
	public String ali_gateway() {
		return ALI_GATEWAY;
	}

	/**
	 * 日志存放路径
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.AliConfig#log_path()
	 */
	@Override
	public String log_path() {
		return LOG_PATH;
	}

	/**
	 * 扫码支付的方式，支持前置模式和跳转模式。
	 * 
	 * <pre>
	前置模式是将二维码前置到商户的订单确认页的模式。需要商户在自己的页面中以iframe方式请求支付宝页面。具体分为以下3种：
	
	    0：订单码-简约前置模式，对应iframe宽度不能小于600px，高度不能小于300px；
	    1：订单码-前置模式，对应iframe宽度不能小于300px，高度不能小于600px；
	    3：订单码-迷你前置模式，对应iframe宽度不能小于75px，高度不能小于75px。
	
	跳转模式下，用户的扫码界面是由支付宝生成的，不在商户的域名下。
	
	    2：订单码-跳转模式
	 * </pre>
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.AliConfig#qr_pay_mode()
	 */

	@Override
	public String qr_pay_mode() {
		return QR_PAY_MODE;
	}

}
