<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Wechat Payment Page</title>
</head>
<body>
	<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
	<script type="text/javascript">
		var flag = window.setInterval(function() {
			getOrderMsg('${orderNo}');
		}, 3000);
		var endtime= new Date().getTime();
		alert("endtime:"+endtime);
		function getOrderMsg(orderId) {
			if(new Date().getTime()-endtime > 10000 ){
				window.clearInterval(flag);
				alert("false");
				return ;
			}
			$.post("${pageContext.request.contextPath}/searchOrder/" + orderId,
					{}, function(data) {
						if (data == "1") {
							window.clearInterval(flag);
							alert("scuess");
						}
					});
		}
	</script>
	<img
		src="${pageContext.request.contextPath}/qrcode?width=150&height=150&content=${pngUrl}&type=png">
</body>
</html>