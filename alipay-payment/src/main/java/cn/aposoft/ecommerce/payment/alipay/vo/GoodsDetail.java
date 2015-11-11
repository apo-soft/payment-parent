package cn.aposoft.ecommerce.payment.alipay.vo;

/**
 * 商品明细说明
 * 
 * @author Yujinshui
 *
 */
public class GoodsDetail {
	/**
	 * 商品编号*
	 * <p>
	 * 商品的编号。
	 */
	private String goods_id;
	/**
	 * 支付宝统一的商品编号
	 * <p>
	 * 支付宝定义的统一商品编号
	 */
	private String alipay_goods_id;
	/**
	 * 商品名称*
	 * <p>
	 * 商品名称。
	 */
	private String goods_name;
	/**
	 * 商品数量*
	 * <p>
	 */
	private String quantity;
	/**
	 * 商品单价*
	 * <p>
	 * 商品单价，单位为元。
	 */
	private String price;
	/**
	 * 商品类目
	 * <p>
	 */
	private String goods_category;
	/**
	 * 商品描述
	 * <p>
	 * 商品描述信息。
	 */
	private String body;

	/**
	 * 商品编号*
	 * <p>
	 * 商品的编号。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午3:00:45
	 */
	public String getGoods_id() {
		return goods_id;
	}

	/**
	 * 商品编号*
	 * <p>
	 * 商品的编号。
	 * 
	 * @param goods_id
	 * @author Yujinshui
	 * @time 2015年11月10日 下午3:00:50
	 */
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	/**
	 * 支付宝统一的商品编号
	 * <p>
	 * 支付宝定义的统一商品编号
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午3:01:01
	 */
	public String getAlipay_goods_id() {
		return alipay_goods_id;
	}

	/**
	 * 支付宝统一的商品编号
	 * <p>
	 * 支付宝定义的统一商品编号
	 * 
	 * @param alipay_goods_id
	 * @author Yujinshui
	 * @time 2015年11月10日 下午3:01:04
	 */
	public void setAlipay_goods_id(String alipay_goods_id) {
		this.alipay_goods_id = alipay_goods_id;
	}

	/**
	 * 商品名称*
	 * <p>
	 * 商品名称。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午3:01:15
	 */
	public String getGoods_name() {
		return goods_name;
	}

	/**
	 * 商品名称*
	 * <p>
	 * 商品名称。
	 * 
	 * @param goods_name
	 * @author Yujinshui
	 * @time 2015年11月10日 下午3:01:18
	 */
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	/**
	 * 商品数量*
	 * <p>
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午3:01:29
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * 商品数量*
	 * <p>
	 * 
	 * @param quantity
	 * @author Yujinshui
	 * @time 2015年11月10日 下午3:01:33
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * 商品单价*
	 * <p>
	 * 商品单价，单位为元。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午3:01:42
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * 商品单价*
	 * <p>
	 * 商品单价，单位为元。
	 * 
	 * @param price
	 * @author Yujinshui
	 * @time 2015年11月10日 下午3:01:46
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * 商品类目
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午3:01:57
	 */
	public String getGoods_category() {
		return goods_category;
	}

	/**
	 * 商品类目
	 * 
	 * @param goods_category
	 * @author Yujinshui
	 * @time 2015年11月10日 下午3:02:00
	 */
	public void setGoods_category(String goods_category) {
		this.goods_category = goods_category;
	}

	/**
	 * 商品描述
	 * <p>
	 * 商品描述信息。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月10日 下午3:02:10
	 */
	public String getBody() {
		return body;
	}

	/**
	 * 商品描述
	 * <p>
	 * 商品描述信息。
	 * 
	 * @param body
	 * @author Yujinshui
	 * @time 2015年11月10日 下午3:02:13
	 */
	public void setBody(String body) {
		this.body = body;
	}
}
