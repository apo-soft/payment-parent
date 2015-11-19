package cn.aposoft.ecommerce.payment.alipay;

import java.util.Map;

public interface HttpClientUtil {
	/**
	 * 支付请求
	 * 
	 * @param params
	 * @param config
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月16日 下午2:37:53
	 */
	String post(Map<String, String> params, Config config);

	/**
	 * 退款请求
	 * 
	 * @param params
	 * @param config
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月16日 下午2:38:01
	 */
	String refund(Map<String, String> params, Config config);
}
