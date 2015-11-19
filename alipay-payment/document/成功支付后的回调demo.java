class  
{
	/**
	以jFinal为demo示例
	 * notify_url = http://yangxinxin-163.6655.la:16834/count/ali/paySuccess
	 * 
	 * @param
	 */
	public void paySuccess() {

		Notification notify = new Notification();
		setNotifyValue(notify);
		System.out.println(notify.toString());
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(date);
		System.out.println(str);
		// TODO 重复订单的处理部分-待做
		renderText("success");

	}

	public void setNotifyValue(Notification notify) {
		String notify_time = getPara("notify_time");
		String notify_type = getPara("notify_type");
		String notify_id = getPara("notify_id");
		String sign_type = getPara("sign_type");
		String sign = getPara("sign");
		String notify_action_type = getPara("notify_action_type");
		String out_trade_no = getPara("out_trade_no");
		String subject = getPara("subject");
		String trade_no = getPara("trade_no");
		String trade_status = getPara("trade_status");
		String gmt_create = getPara("gmt_create");
		String gmt_payment = getPara("gmt_payment");
		String seller_email = getPara("seller_email");
		String buyer_email = getPara("buyer_email");
		String seller_id = getPara("seller_id");
		String buyer_id = getPara("buyer_id");
		String price = getPara("price");
		String quantity = getPara("quantity");
		String total_fee = getPara("total_fee");
		String body = getPara("body");
		String refund_fee = getPara("refund_fee");
		String out_biz_no = getPara("out_biz_no");
		String paytools_pay_amount = getPara("paytools_pay_amount");
		String extra_common_param = getPara("extra_common_param");

		notify.setBody(body);
		notify.setBuyer_email(buyer_email);
		notify.setBuyer_id(buyer_id);
		notify.setExtra_common_param(extra_common_param);
		notify.setGmt_create(gmt_create);
		notify.setGmt_payment(gmt_payment);

		notify.setNotify_action_type(notify_action_type);
		notify.setNotify_id(notify_id);
		notify.setNotify_time(notify_time);
		notify.setNotify_type(notify_type);
		notify.setOut_biz_no(out_biz_no);
		notify.setOut_trade_no(out_trade_no);
		notify.setPaytools_pay_amount(paytools_pay_amount);
		notify.setPrice(price);
		notify.setQuantity(quantity);
		notify.setRefund_fee(refund_fee);
		notify.setSeller_email(seller_email);
		notify.setSeller_id(seller_id);
		notify.setSign(sign);
		notify.setSign_type(sign_type);
		notify.setSubject(subject);
		notify.setTotal_fee(total_fee);
		notify.setTrade_no(trade_no);
		notify.setTrade_status(trade_status);

		notify = NotificationUtil.checkAliSign(notify, config);//

	}
}
