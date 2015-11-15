class  
{
	public void paySuccess() {
		System.out.println("统一支付回调函数开始...");

		CallbackService callback = new CallbackServiceImpl(SimpleEntityUtil.getInstance());

		Map<String, String> resultMap = null;
		NotificationResult noti = null;
		try {
			InputStream in = getRequest().getInputStream();
			String resultXml = inputStreamToString(in);
			log.info("\n======WeChatPay 扫码支付成功回调服务 开始======\n" + resultXml);
			Notification result = callback.recveiveNotification(resultXml);
			String notiresult = result.getResult().toXml();
			
			System.out.println(resultMap);
			noti = NotificationResult.successResult();
		} catch (IOException e) {
			noti = NotificationResult.nullResult();
			e.printStackTrace();
		}
		System.out.println("统一支付回调函数结束...");

		String result = noti.toXml();
		renderText(result);//发送微信支付回调结果
		renderJson("回调完成，内容已经打印");
	}


	/**
	 * 输入流转字符串
	 * 
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public String inputStreamToString(InputStream is) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int i;
		while ((i = is.read()) != -1) {
			baos.write(i);
		}
		return baos.toString();
	}

	/**
	 * 其他回调结果返回内容参考方法
	 * 
	 * @param text
	 *            返回内容
	 */

	public void render() {
		HttpServletResponse response;
		PrintWriter writer = null;
		try {
			response.setHeader("Pragma", "no-cache"); // HTTP/1.0 caches might
														// not implement
														// Cache-Control and
														// might only implement
														// Pragma: no-cache
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);

			if (contentType == null) {
				response.setContentType(DEFAULT_CONTENT_TYPE);
			} else {
				response.setContentType(contentType);
				response.setCharacterEncoding(getEncoding());
			}

			writer = response.getWriter();
			writer.write(text);
			writer.flush();
		} catch (IOException e) {
			throw new RenderException(e);
		} finally {
			if (writer != null)
				writer.close();
		}
	}


}
