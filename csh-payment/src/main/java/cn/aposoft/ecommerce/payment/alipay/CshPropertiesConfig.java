package cn.aposoft.ecommerce.payment.alipay;

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

	public CshPropertiesConfig(Map<String, String> map) {
		key = map.get("key");
		ve = map.get("ve");
		secret = map.get("secret");
		cid = map.get("cid");
	}

	public CshPropertiesConfig() {
		getProperties("csh.properties");
	}

	public CshPropertiesConfig(String fileName) {
		getProperties(fileName);
	}

	public CshPropertiesConfig(String outFileName, String encoding) {
		getFileProperties(outFileName, encoding);
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

	private void setPropertiesValues(Properties p) {
		key = p.getProperty("key");
		ve = p.getProperty("ve");
		secret = p.getProperty("secret");
		cid = p.getProperty("cid");

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
}
