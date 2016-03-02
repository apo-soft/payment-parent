/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jann Liu
 *
 */
@RequestMapping("/bill")
@Controller
public class OrderBillController {
	private static final Logger logger = LoggerFactory.getLogger(OrderBillController.class);

	/**
	 * 入口订单处理登陆页
	 * 
	 * @return 登陆处理页地址
	 */
	@RequestMapping("/index")
	public String index(Model model) {
		if (logger.isDebugEnabled())
			logger.debug("bill index is called.");
		model.addAttribute("submitPath", "/bill/submit");
		return "bill/index";
	}

	/**
	 * 入口订单处理登陆页
	 * 
	 * @return 登陆处理页地址
	 */
	@RequestMapping("/submit")
	public String submit(Model model) {
		if (logger.isDebugEnabled())
			logger.debug("bill index is called.");

		// 完成订单处理

		model.addAttribute("submitPath", "/bill/submit");
		return "bill/submit";
	}
}
