package cn.aposoft.ecommerce.payment.alipay;

import java.util.Map;

import cn.aposoft.ecommerce.payment.alipay.inter.Config;

public interface HttpClientUtil {

	String post(Map<String, String> params, Config config);
}
