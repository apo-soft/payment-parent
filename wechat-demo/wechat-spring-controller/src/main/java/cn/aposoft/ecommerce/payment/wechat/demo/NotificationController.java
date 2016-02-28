package cn.aposoft.ecommerce.payment.wechat.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.aposoft.ecommerce.payment.wechat.CallbackService;
import cn.aposoft.ecommerce.payment.wechat.EntityUtil;
import cn.aposoft.ecommerce.payment.wechat.impl.CallbackServiceImpl;
import cn.aposoft.ecommerce.payment.wechat.impl.EntityUtilFactory;

@Controller
public class NotificationController {
	/*@Autowired*/
	private CallbackService callbackService;
	/**
	 * 接收支付成功消息
	 * */
	@RequestMapping(value="/notificationCon")
	public void receiveNotification(@RequestBody String notifyXml){
		if(notifyXml != null && !notifyXml.isEmpty()){
			new CallbackServiceImpl(EntityUtilFactory.getInstance()).recveiveNotification(notifyXml);
		}
	}
}
