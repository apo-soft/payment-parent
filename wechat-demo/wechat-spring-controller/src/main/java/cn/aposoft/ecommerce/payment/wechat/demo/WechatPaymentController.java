package cn.aposoft.ecommerce.payment.wechat.demo;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 支付控制器
 * 
 * @author Jann Liu
 *
 */
@Controller
@RequestMapping("/")
public class WechatPaymentController {

	public WechatPaymentController() {
	}

	@RequestMapping("/payment/wechat")
	public String showHomePage(Map<String, Object> model) {
		long sleep = 1 * 1000;
		System.out.println("in: /payment/wechat , at:" + new Date());
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "payment/wechat";
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
