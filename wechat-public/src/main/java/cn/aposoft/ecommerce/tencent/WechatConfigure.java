package cn.aposoft.ecommerce.tencent;

/**
 * User: rizenguo
 * Date: 2014/10/29
 * Time: 14:40
 * 这里放置各种配置数据
 */
public class WechatConfigure {
	//这个就是自己要保管好的私有Key了（切记只能放在自己的后台代码里，不能放在任何可能被看到源代码的客户端程序中）
	// 每次自己Post数据给API的时候都要用这个key来对所有字段进行签名，生成的签名会放在Sign这个字段，API收到Post数据的时候也会用同样的签名算法对Post过来的数据进行签名和验证
	// 收到API的返回的时候也要用这个key来对返回的数据算下签名，跟API的Sign数据进行比较，如果值不一致，有可能数据被第三方给篡改

	private String key = "221A142ED19F13C2FD92886439A39540";

	//微信分配的公众号ID（开通公众号之后可以获取到）
	private String appID = "wx5269eef08886e3d5";

	//微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
	private String mchID = "1324016301";

	//受理模式下给子商户分配的子商户号
	private String subMchID = "";

	//HTTPS证书的内容字节
	private byte[] certData;

	//HTTPS证书密码，默认密码等于商户号MCHID
	private String certPassword = "1324016301";

	//是否使用异步线程的方式来上报API测速，默认为异步模式
	private boolean useThreadToDoReport = true;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getAppID() {
		return appID;
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}

	public String getMchID() {
		return mchID;
	}

	public void setMchID(String mchID) {
		this.mchID = mchID;
	}

	public String getSubMchID() {
		return subMchID;
	}

	public void setSubMchID(String subMchID) {
		this.subMchID = subMchID;
	}

	public String getCertPassword() {
		return certPassword;
	}

	public void setCertPassword(String certPassword) {
		this.certPassword = certPassword;
	}

	public boolean isUseThreadToDoReport() {
		return useThreadToDoReport;
	}

	public void setUseThreadToDoReport(boolean useThreadToDoReport) {
		this.useThreadToDoReport = useThreadToDoReport;
	}

	public byte[] getCertData() {
		return certData;
	}

	public void setCertData(byte[] certData) {
		this.certData = certData;
	}
}
