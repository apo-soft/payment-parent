<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Wechat Payment Page</title>
<c:url value="/resources/js/jquery-2.2.1.js" var="jqueryUrl" />
<script type="text/javascript" src="${jqueryUrl}"></script>
<script type="text/javascript">
	var flag = window.setInterval(function() {
		getOrderMsg('${model.orderNo}');
	}, 3000);
	var beginTime = new Date().getTime();
	console.log("query order state: beginTime:" + beginTime);
	var queryTime = 0;
	function getOrderMsg(orderId) {
		var currTime = new Date().getTime();
		if (currTime - beginTime > 10000) {
			window.clearInterval(flag);
			console.log("timeout occurd.");
			return;
		}
		$.get("${pageContext.request.contextPath}/searchOrder/" + orderId,
				function(data) {
					console.log(data);
					if (data === "1" || queryTime++ > 15) {
						window.clearInterval(flag);
					}
				});
	}
</script>
</head>
<body>


	<img
		src="${pageContext.request.contextPath}/qrcode?width=150&height=150&content=${model.pngUrl}&type=png">
</body>
</html>