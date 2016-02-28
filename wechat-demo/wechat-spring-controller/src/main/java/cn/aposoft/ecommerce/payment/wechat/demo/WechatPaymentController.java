package cn.aposoft.ecommerce.payment.wechat.demo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.aposoft.ecommerce.payment.wechat.Order;
import cn.aposoft.ecommerce.payment.wechat.PayResponse;
import cn.aposoft.ecommerce.payment.wechat.PaymentService;
import cn.aposoft.ecommerce.payment.wechat.bean.OrderVo;
import cn.aposoft.ecommerce.payment.wechat.service.PaymentStorageException;
import cn.aposoft.ecommerce.payment.wechat.service.PaymentStoreService;

/**
 * 支付控制器
 * 
 * @author Jann Liu
 *
 */
@Controller
public class WechatPaymentController {
	private static final Logger logger = LoggerFactory.getLogger(WechatPaymentController.class);
	@Autowired
	private PaymentService payService;

	@Autowired
	private PaymentStoreService payStoreService;
	
	public WechatPaymentController() {
	}

	/**
	 * 入口订单处理登陆页
	 * 
	 * @return 登陆处理页地址
	 */

	@RequestMapping("/topay")
	public String toPay() {
		return "payment/topay";
	}

	/**
	 * 接收订单提交的post请求,并进行预付款处理
	 * 
	 * @param order
	 *            待付款订单
	 * @param req
	 *            {@link HttpServletRequest}
	 * @return 预付款处理结果视图地址
	 */
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String showHomePage(OrderVo order, HttpServletRequest req) {
		Order o = null;
		try {
			o = createOrder(order);
			PayResponse result = payService.preparePay(o);
			if (!StringUtils.isEmpty(result.getCode_url())) {
				try {
					req.setAttribute("pngUrl", URLEncoder.encode(result.getCode_url(), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// this will never happen.
					logger.error("虚拟机不支持UTF-8编码");
				}
			}
			return "payment/wechat";
		} catch (PaymentStorageException e) {
			// this will never happen.
			logger.error("访问持久化读取SequenceOrderNo失败,", e);
			// TODO redirect to 500 页面
			return "payment/wechat500";
		}

	}

	// 创建通信的订单对象
	private Order createOrder(OrderVo order) throws PaymentStorageException {
		// 从存储读取自增订单编号
		String orderNo = payStoreService.getNextOrderNo();
		order.setBody(order.getBody());
		order.setGoods_tag("no");
		order.setOut_trade_no(orderNo);// 只要未支付，即可继续重复使用该单号
		order.setSpbill_create_ip("127.0.0.1");
		order.setTrade_type("NATIVE");
		order.setTotal_fee(order.getTotal_fee());
		return order;
	}

	/**
	 * 退款操作 TODO 未实现
	 * 
	 * @param model
	 *            输出对象
	 * @return 退款跳转页面view地址
	 */
	@RequestMapping("/refund")
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

}
