package cn.aposoft.ecommerce.payment.alipay.util;

/**
 * 标准相应数据格式
 * 
 * @author dragon
 *
 */
public class StandardData<T> {
	private int flag; // 1:表示成功,0:表示失败;
	private String msg; // 对处理结果的表述
	private T data;

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
