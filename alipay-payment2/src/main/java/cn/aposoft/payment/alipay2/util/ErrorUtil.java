package cn.aposoft.payment.alipay2.util;

/**
 * 错误说明
 * 
 * @author Yujinshui
 *
 */
public class ErrorUtil {
	/**
	 * 支付宝错误返回说明
	 * 
	 * @param error_code
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月9日 下午4:51:52
	 */
	public static String getErrorContent(String error_code) {
		String error_content = null;
		if (null == error_code) {
			return "error_code is null";
		} else if (error_code.equals("ILLEGAL_SIGN")) {
			error_content = "签名不正确";
		} else if (error_code.equals("ILLEGAL_DYN_MD5_KEY")) {
			error_content = "动态密钥信息错误";
		} else if (error_code.equals("ILLEGAL_ENCRYPT")) {
			error_content = "加密不正确";
		} else if (error_code.equals("ILLEGAL_ARGUMENT")) {
			error_content = "参数不正确";
		} else if (error_code.equals("ILLEGAL_SERVICE")) {
			error_content = "接口名称不正确";
		} else if (error_code.equals("ILLEGAL_PARTNER")) {
			error_content = "合作伙伴ID不正确";
		} else if (error_code.equals("ILLEGAL_EXTERFACE")) {
			error_content = "接口配置不正确";
		} else if (error_code.equals("ILLEGAL_PARTNER_EXTERFACE")) {
			error_content = "合作伙伴接口信息不正确";
		} else if (error_code.equals("ILLEGAL_SECURITY_PROFILE")) {
			error_content = "未找到匹配的密钥配置";
		} else if (error_code.equals("ILLEGAL_AGENT")) {
			error_content = "代理ID不正确";
		} else if (error_code.equals("ILLEGAL_SIGN_TYPE")) {
			error_content = "签名类型不正确";
		} else if (error_code.equals("ILLEGAL_CHARSET")) {
			error_content = "字符集不合法";
		} else if (error_code.equals("ILLEGAL_CLIENT_IP")) {
			error_content = "客户端IP地址无权访问服务";
		} else if (error_code.equals("ILLEGAL_DIGEST_TYPE")) {
			error_content = "摘要类型不正确";
		} else if (error_code.equals("ILLEGAL_DIGEST")) {
			error_content = "文件摘要不正确";
		} else if (error_code.equals("ILLEGAL_FILE_FORMAT")) {
			error_content = "文件格式不正确";
		} else if (error_code.equals("ILLEGAL_ENCODING")) {
			error_content = "不支持该编码类型";
		} else if (error_code.equals("ILLEGAL_REQUEST_REFERER")) {
			error_content = "防钓鱼检查不支持该请求来源";
		} else if (error_code.equals("ILLEGAL_ANTI_PHISHING_KEY")) {
			error_content = "防钓鱼检查非法时间戳参数";
		} else if (error_code.equals("ANTI_PHISHING_KEY_TIMEOUT")) {
			error_content = "防钓鱼检查时间戳超时";
		} else if (error_code.equals("ILLEGAL_EXTER_INVOKE_IP")) {
			error_content = "防钓鱼检查非法调用IP";
		} else if (error_code.equals("ILLEGAL_NUMBER_FORMAT")) {
			error_content = "数字格式不合法";
		} else if (error_code.equals("ILLEGAL_INTEGER_FORMAT")) {
			error_content = "Int类型格式不合法";
		} else if (error_code.equals("ILLEGAL_MONEY_FORMAT")) {
			error_content = "金额格式不合法";
		} else if (error_code.equals("ILLEGAL_DATA_FORMAT")) {
			error_content = "日期格式错误";
		} else if (error_code.equals("REGEXP_MATCH_FAIL")) {
			error_content = "正则表达式匹配失败";
		} else if (error_code.equals("ILLEGAL_LENGTH")) {
			error_content = "参数值长度不合法";
		} else if (error_code.equals("PARAMTER_IS_NULL")) {
			error_content = "参数值为空";
		} else if (error_code.equals("HAS_NO_PRIVILEGE")) {
			error_content = "无权访问";
		} else if (error_code.equals("SYSTEM_ERROR")) {
			error_content = "支付宝系统错误";
		} else if (error_code.equals("SESSION_TIMEOUT")) {
			error_content = "session超时";
		} else if (error_code.equals("ILLEGAL_TARGET_SERVICE")) {
			error_content = "错误的target_service";
		} else if (error_code.equals("ILLEGAL_ACCESS_SWITCH_SYSTEM")) {
			error_content = "partner不允许访问该类型的系统";
		} else if (error_code.equals("ILLEGAL_SWITCH_SYSTEM")) {
			error_content = "切换系统异常";
		} else if (error_code.equals("EXTERFACE_IS_CLOSED")) {
			error_content = "接口已关闭";
		} else {
			error_content = "未知错误，无接口说明";
		}
		return error_content;
	}

}
