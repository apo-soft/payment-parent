<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Wechat Payment Page</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}${submitPath}"
		method="post">
		商品描述：<input type="text" name="body"></input> <br /> 商品价格：<input
			type="text" name="total_fee"></input> <br /> <input type="submit"
			value="提交订单"></input>
	</form>
</body>
</html>