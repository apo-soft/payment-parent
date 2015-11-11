package cn.aposoft.ecommerce.payment.alipay.test;

import java.util.ArrayList;
import java.util.List;

import cn.aposoft.ecommerce.payment.alipay.config.PropertiesConfig;
import cn.aposoft.ecommerce.payment.alipay.inter.Config;
import cn.aposoft.ecommerce.payment.alipay.util.JsonUtil;
import cn.aposoft.ecommerce.payment.alipay.util.DateUtil;
import cn.aposoft.ecommerce.payment.alipay.vo.GoodsDetail;
import cn.aposoft.ecommerce.payment.alipay.vo.PayRequest;
import cn.aposoft.ecommerce.payment.alipay.vo.RequestBase;

public class AliTest {

	Config config = new PropertiesConfig("E:/environments/pay/ali/alipay.properties", "utf-8");

	public void config() {

		System.out.println(config);

	}

	public void setRequest(RequestBase base) {
		base.setApp_id(config.appid());
		base.setCharset(config.charset());
		base.setSign_type(config.sign_type());
		base.setTimestamp(DateUtil.getDateFormatter());
		base.setVersion(config.version());
		base.setNotify_url(config.notify_url());
		base.setSign(
				"voYcF572mliFXgM/MFLEN1+2xVEuAFhzschcBoUEnfOWHqxcFY8DhecCKwMhHja/LzB2cUE+x09bfH4JYnMNs0A/fGAe401Llc+EBhD+Fh8kFKN1LSql/ZCGCVs0gmm/gjkBSxiSwtSC+wjmpqolU+O9UvOuFfTlaYim7EqNYmo=");
	}

	public void setOrder(PayRequest order) {
		order.setOut_trade_no("1234567");
		order.setSubject("subject");
	}

	public void setGoodsDetail(GoodsDetail gd) {
		gd.setGoods_id("这是商品编号");
		gd.setGoods_name("ipad 16G");
		gd.setPrice("12.22");
		gd.setQuantity("1");
	}

	public void voTest() {
		RequestBase base = new RequestBase();
		PayRequest order = new PayRequest();
		GoodsDetail gd = new GoodsDetail();
		setRequest(base);
		setOrder(order);
		setGoodsDetail(gd);
		List<GoodsDetail> list = new ArrayList<GoodsDetail>();
		list.add(gd);
		order.setGoods_detail(list);

		base.setBiz_content(order);
		String output = JsonUtil.ObjectToJson(base);
		System.out.println(output);
	}

	public static void main(String[] args) {
		AliTest ali = new AliTest();
		// ali.config();
		ali.voTest();
	}

}
