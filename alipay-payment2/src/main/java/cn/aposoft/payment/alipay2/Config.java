package cn.aposoft.payment.alipay2;
/**
 * 
 */

/**
 * 固定参数相关
 * <p>
 * {@link https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_1}
 * 
 * @author Jann Liu
 *
 */
public interface Config {

	/**
	 * 商户的私钥<br>
	 * [源自官网demo说明]
	 * 
	 * @return key值
	 */
	String private_key();

	/**
	 * 商户key
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月9日 下午3:17:30
	 */
	String key();

	/**
	 * 合作身份者ID，以2088开头由16位纯数字组成的字符串<br>
	 * [源自官网demo说明]
	 * 
	 * @return 应用id字符串
	 */
	String pid();

	/**
	 * 支付宝分配给开发者的应用Id
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月9日 下午6:02:31
	 */
	String appid();

	/**
	 * 请求使用的编码格式，如utf-8(推荐),gbk,gb2312等
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午7:43:33
	 */
	String charset();

	/**
	 * 签名方式 不需修改<br>
	 * [源自官网demo说明]
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月9日 下午3:14:33
	 */
	String sign_type();

	/**
	 * 调用的接口版本，固定为：1.0
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午7:44:06
	 */
	String version();

	/**
	 * [接口异步通知url ]支付宝服务器主动通知商户服务器里指定的页面http路径。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午7:44:33
	 */
	String notify_url();

	/**
	 * 支付宝的公钥，无需修改该值<br>
	 * [源自官网demo说明]
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月9日 下午3:14:57
	 */
	String ali_public_key();

	/**
	 * 支付宝通用网关接口
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午7:45:08
	 */
	String ali_gateway();

	/**
	 * 日志存放路径
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月11日 上午10:49:32
	 */
	String log_path();
	
	/**
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月11日 下午7:55:42
	 */
	String qr_pay_mode();
}
