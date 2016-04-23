package cn.aposoft.ecommerce.payment.cshpay;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

public class CshPropertiesConfig implements CshConfig {
	private static Logger logger = Logger.getLogger(CshPropertiesConfig.class);
	private String key;
	private String ve;
	private String secret;
	private String cid;
	private String bid;
	private String callback;
	private String payurl;
	private String qrcodeurl;

	/**
	 * 默认资源文件
	 */
	public CshPropertiesConfig() {
		getProperties("csh.properties");
	}

	/**
	 * 资源文件
	 * 
	 * @param fileName
	 */
	public CshPropertiesConfig(String fileName) {
		getProperties(fileName);
	}

	/**
	 * 外部文件
	 * 
	 * @param outFileName
	 * @param encoding
	 */
	public CshPropertiesConfig(String outFileName, String encoding) {
		getFileProperties(outFileName, encoding);
	}

	public CshPropertiesConfig(Map<String, String> map) {
		key = map.get("KEY");
		ve = map.get("VE");
		secret = map.get("SECRET");
		cid = map.get("CID");
		bid = map.get("BID");
		callback = map.get("CALLBACK");
		payurl = map.get("PAY_URL");
		qrcodeurl = map.get("QRCODE_URL");
	}

	private void setPropertiesValues(Properties p) {
		key = p.getProperty("KEY");
		ve = p.getProperty("VE");
		secret = p.getProperty("SECRET");
		cid = p.getProperty("CID");
		bid = p.getProperty("BID");
		callback = p.getProperty("CALLBACK");
		payurl = p.getProperty("PAY_URL");
		qrcodeurl = p.getProperty("QRCODE_URL");

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

	@Override
	public String key() {
		return key;
	}

	@Override
	public String ve() {
		return ve;
	}

	@Override
	public String secret() {
		return secret;
	}

	@Override
	public String cid() {
		return cid;
	}

	@Override
	public String bid() {
		return bid;
	}

	@Override
	public String callback() {
		return callback;
	}

	@Override
	public String payUrl() {
		return payurl;
	}

	@Override
	public String qrcodeUrl() {
		return qrcodeurl;
	}
}
