/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.service;

/**
 * @author Jann Liu
 *
 */
public class PaymentStorageException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * 默认构造函数
	 */
	public PaymentStorageException() {
	}

	/**
	 * 带异常消息的构造函数
	 * 
	 * @param message
	 *            错误消息
	 */
	public PaymentStorageException(String message) {
		super(message);
	}

	/**
	 * 带错误消息和内部引发异常的构造函数
	 * 
	 * @param message
	 *            错误消息
	 * @param t
	 *            内部引发的异常
	 */
	public PaymentStorageException(String message, Throwable t) {
		super(message, t);
	}
}
