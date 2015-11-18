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
		renderText("success");

	}

	public void setNotifyValue(Notification notify) {
		Date notify_time = getParaToDate("notify_time");
		String notify_type = getPara("notify_type");
		String notify_id = getPara("notify_id");
		String sign_type = getPara("sign_type");
		String sign = getPara("sign");
		// 可选参数
		String out_trade_no = getPara("out_trade_no");
		String subject = getPara("subject");
		String trade_no = getPara("trade_no");
		String trade_status = getPara("trade_status");
		Date gmt_create = getParaToDate("gmt_create");
		String price = getPara("price");
		String quantity = getPara("quantity");
		String total_fee = getPara("total_fee");
		String body = getPara("body");
		String refund_fee = getPara("refund_fee");
		String out_biz_no = getPara("out_biz_no");

		String result = "notify_time:" + notify_time//
				+ "\r\n notify_type:" + notify_type//
				+ "\r\n notify_id:" + notify_id//
				+ "\r\n sign_type:" + sign_type//
				+ "\r\n sign:" + sign//
				+ "\r\n out_trade_no:" + out_trade_no//
				+ "\r\n subject:" + subject//
				+ "\r\n trade_no:" + trade_no//
				+ "\r\n trade_status:" + trade_status//
				+ "\r\n gmt_create:" + gmt_create//
				+ "\r\n price:" + price//
				+ "\r\n quantity:" + quantity//
				+ "\r\n total_fee:" + total_fee//
				+ "\r\n body:" + body//
				+ "\r\n refund_fee:" + refund_fee//
				+ "\r\n out_biz_no:" + out_biz_no;//
		System.out.println(result);


	}
}
