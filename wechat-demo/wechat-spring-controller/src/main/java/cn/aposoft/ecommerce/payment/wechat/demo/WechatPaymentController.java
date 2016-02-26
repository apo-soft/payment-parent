package cn.aposoft.ecommerce.payment.wechat.demo;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.LogFactory;
import org.apache.http.client.utils.URLEncodedUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.aposoft.ecommerce.payment.wechat.Order;
import cn.aposoft.ecommerce.payment.wechat.PaymentService;
import cn.aposoft.ecommerce.payment.wechat.impl.PayResponse;
import cn.aposoft.ecommerce.payment.wechat.impl.PaymentServiceFactory;
import cn.aposoft.image.QRCodeUtil;

/**
 * 支付控制器
 * 
 * @author Jann Liu
 *
 */
@Controller
public class WechatPaymentController {
	
	@Autowired
	private PaymentService payservice ;
	public WechatPaymentController() {
	}

	@RequestMapping(value="/payment/order" ,method=RequestMethod.POST)
	public String showHomePage(OrderVo order ,HttpServletRequest req) {
		Order o = createOrder(order);
		PayResponse result = payservice.preparePay(o);
		if(!StringUtils.isEmpty(result.getCode_url()) ){
			try {
				req.setAttribute("pngUrl", URLEncoder.encode(result.getCode_url(),"utf-8"));
			} catch (UnsupportedEncodingException e) {
				//log
			}
		}
		return "payment/wechat";
	}
	
	private static  Order createOrder(OrderVo order){
		order.setBody(order.getBody());
		order.setGoods_tag("no");
		order.setOut_trade_no(NumUtil.makeNum(8));// 只要未支付，即可继续重复使用该单号
		order.setSpbill_create_ip("127.0.0.1");
		order.setTrade_type("NATIVE");  
		order.setTotal_fee(order.getTotal_fee());
		return order;
	}
	@RequestMapping("/topay")
	public String toPay(){
		return "payment/topay";
	}
	
	@RequestMapping("/payment/refund")
	public String refund(Map<String, Object> model) {
		long sleep = 5 * 1000;
		System.out.println("in: /payment/refund , at:" + new Date());
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "payment/wechat";
	}

	// <start id="spittlesPerPage"/>
	public static final int DEFAULT_SPITTLES_PER_PAGE = 25;

	private int spittlesPerPage = DEFAULT_SPITTLES_PER_PAGE;

	public void setSpittlesPerPage(int spittlesPerPage) {
		this.spittlesPerPage = spittlesPerPage;
	}

	public int getSpittlesPerPage() {
		return spittlesPerPage;
	}
	// <end id="spittlesPerPage"/>
}
