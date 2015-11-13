package cn.aposoft.ecommerce.payment.alipay;

/**
 * 业务参数VO
 * <p>
 * JSON格式，具体包含的内容参见各个接口的业务参数描述
 * <p>
 * REQUEST URL: https://openapi.alipay.com/gateway.do REQUEST METHOD: POST
 * CONTENT: app_id=2014072300007148 method=alipay.mobile.public.menu.add
 * charset=GBK sign_type=RSA timestamp=2014-07-24 03:07:50
 * biz_content={"button":[{"actionParam":"ZFB_HFCZ","actionType":"out","name":
 * "话费充值"},{"name":"查询","subButton":[{"actionParam":"ZFB_YECX","actionType":
 * "out","name":"余额查询"},{"actionParam":"ZFB_LLCX","actionType":"out","name":
 * "流量查询"},{"actionParam":"ZFB_HFCX","actionType":"out","name":"话费查询"}]},{
 * "actionParam":"http://m.alipay.com","actionType":"link","name":"最新优惠"}]}
 * sign=
 * e9zEAe4TTQ4LPLQvETPoLGXTiURcxiAKfMVQ6Hrrsx2hmyIEGvSfAQzbLxHrhyZ48wOJXTsD4FPnt
 * +YGdK57+fP1BCbf9rIVycfjhYCqlFhbTu9pFnZgT55W+
 * xbAFb9y7vL0MyAxwXUXvZtQVqEwW7pURtKilbcBTEW7TAxzgro= version=1.0
 * 
 * @author Yujinshui
 *
 */
public class BizContent {
	// TODO
}
