package cn.aposoft.ecommerce.payment.wechat.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.aposoft.ecommerce.payment.wechat.CallbackService;
import cn.aposoft.ecommerce.payment.wechat.Notification;
import cn.aposoft.ecommerce.payment.wechat.impl.NotificationResult;

@Controller
public class NotificationController {
	@Autowired
	private CallbackService callbackService;

	/**
	 * 接收支付成功消息
	 */
	@ResponseBody
	@RequestMapping(value = "/notificationCon")
	public String receiveNotification(@RequestBody String notifyXml) {
		if (notifyXml != null && !notifyXml.isEmpty()) {
			Notification notify = callbackService.recveiveNotification(notifyXml);
			NotificationResult notifyResult = notify.getResult();
			if ("SUCCESS".endsWith(notifyResult.getReturn_code())) {

			}
			return notify.getResult().toXml();

		}
		return NotificationResult.nullResult().toXml();
	}

	/**
	 * 接收支付成功消息
	 */
	@ResponseBody
	@RequestMapping(value = "/notify")
	public String receiveDemo() {

		return "刘健解决乱码";
	}
}
