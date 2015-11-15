package cn.aposoft.ecommerce.payment.alipay;

import java.util.Map;

public interface HttpClientUtil {

	String post(Map<String, String> params, Config config);
}
