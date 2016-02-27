package cn.aposoft.ecommerce.payment.alipay.sign;

import java.util.Map;

import cn.aposoft.ecommerce.payment.alipay.AliConfig;
import cn.aposoft.ecommerce.payment.alipay.util.AlipayCore;

/**
 * 签名算法
 * 
 * @author Yujinshui
 *
 */
public class Signature {
	/**
	 * 生成MD5签名结果
	 * 
	 * @param sPara
	 *            要签名的数组
	 * @return 签名结果字符串
	 */
	public static String requestSign_MD5(Map<String, String> sPara, AliConfig config) {
		String prestr = AlipayCore.createLinkString(sPara); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
		String mysign = "";
		if ("MD5".equals(config.sign_type())) {
			mysign = MD5.sign(prestr, config.key(), config.charset());
		}
		return mysign;
	}
	// TODO RSA,DSA

}
