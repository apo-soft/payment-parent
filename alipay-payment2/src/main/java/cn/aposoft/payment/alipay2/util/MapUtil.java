package cn.aposoft.payment.alipay2.util;

import java.util.Map;

import org.apache.commons.httpclient.NameValuePair;

import cn.aposoft.payment.alipay2.Ali2Config;
import cn.aposoft.payment.alipay2.sign.Signature;

public class MapUtil {

	/**
	 * 创建待发送map
	 * <p>
	 * 对params进行排序，同时添加签名信息
	 * 
	 * @param params
	 * @author Yujinshui
	 * @return
	 * @time 2015年11月12日 上午11:32:32
	 */
	public static Map<String, String> createMapRequest(Map<String, String> params, Ali2Config config) {
		// 除去数组中的空值和签名参数
		Map<String, String> paras = AlipayCore.paraFilter(params);
		String sign = Signature.requestSign_MD5(paras, config);
		paras.put("sign", sign);
		paras.put("sign_type", config.sign_type());
		return paras;
	}

	/**
	 * MAP类型数组转换成NameValuePair类型
	 * 
	 * @param properties
	 *            MAP类型数组
	 * @return NameValuePair类型数组
	 */
	public static NameValuePair[] generatNameValuePair(Map<String, String> properties) {
		NameValuePair[] nameValuePair = new NameValuePair[properties.size()];
		int i = 0;
		for (Map.Entry<String, String> entry : properties.entrySet()) {
			nameValuePair[i++] = new NameValuePair(entry.getKey(), entry.getValue());
		}

		return nameValuePair;
	}
}
