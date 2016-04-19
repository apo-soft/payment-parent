/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.util;

import java.nio.charset.Charset;

/**
 * @author Jann Liu
 *
 */
public class AposoftStringHttpMessageConverter extends org.springframework.http.converter.StringHttpMessageConverter {
	/**
	 * 构建基于charsetName的Converter
	 * 
	 * @see org.springframework.http.converter.StringHttpMessageConverter
	 * @param charset
	 *            字符集编码
	 */
	public AposoftStringHttpMessageConverter(String charset) {
		this(Charset.forName(charset));
	}

	/**
	 * 构建基于charset的Converter
	 * 
	 * @see org.springframework.http.converter.StringHttpMessageConverter
	 * @param charset
	 *            字符集
	 */
	public AposoftStringHttpMessageConverter(Charset charset) {
		super(charset);
	}
}
