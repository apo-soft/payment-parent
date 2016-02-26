<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Wechat Payment Page</title>
<script type=”text/javascript”>
window.setInterval(function(){
showalert(“aaaaa”);
}, 2000);
function showalert(mess)
{
//alert(mess);
}

</script>
</head>
<body>
	<img
		src="${pageContext.request.contextPath}/qrcode?width=150&height=150&content=${pngUrl}&type=png">
</body>
</html>