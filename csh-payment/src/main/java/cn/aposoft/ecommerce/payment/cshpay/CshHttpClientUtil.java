package cn.aposoft.ecommerce.payment.cshpay;

import java.util.Map;

/**
 * 请求接口
 * 
 * @author Yu Jinshui
 * @createTime 2016年4月23日 下午7:01:03
 */
public interface CshHttpClientUtil {
	/**
	 * 支付请求
	 *
	 * @param params
	 * @param config
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年4月23日 下午7:02:07
	 */
	String post(Map<String, String> params, CshConfig config);

}
