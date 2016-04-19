<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:form="http://www.springframework.org/tags/form" version="2.0">
	<jsp:directive.page language="java" contentType="text/html" />

	<html>
<head>
<meta charset="UTF-8" />
<title>Fill your bill:</title>
<c:url value="/resources/css/" var="cssbase" />
<link href="${cssbase}bootstrap.css" type="text/css" rel="stylesheet" />
<style type="text/css">
/* Sticky footer styles
      -------------------------------------------------- */
html, body {
	height: 100%;
	/* The html and body elements cannot have any padding or margin. */
}

/* Wrapper for page content to push down footer */
#wrap {
	min-height: 100%;
	height: auto !important;
	height: 100%;
	/* Negative indent footer by it's height */
	margin: 0 auto -60px;
}

/* Set the fixed height of the footer here */
#push, #footer {
	height: 60px;
}

#footer {
	background-color: #f5f5f5;
}

/* Lastly, apply responsive CSS fixes as necessary */
@media ( max-width : 767px) {
	#footer {
		margin-left: -20px;
		margin-right: -20px;
		padding-left: 20px;
		padding-right: 20px;
	}
}

/* Custom page CSS
      -------------------------------------------------- */
/* Not required for template or sticky footer method. */
.container {
	width: auto;
	max-width: 680px;
}

.container .credit {
	margin: 20px 0;
	text-align: center;
}

a {
	color: green;
}

.navbar-form {
	margin-left: 1em;
}
</style>
<link href="${cssbase}bootstrap-responsive.css" type="text/css"
	rel="stylesheet" />
</head>
<body>
	<div id="wrap">
		<div class="navbar navbar-inverse navbar-static-top">
			<div class="navbar-inner">
				<div class="container">
					<c:url value="/" var="root" />
					<a class="brand" href="${root}"><img
						src="${root}resources/img/logo.png" alt="Spring Security Sample" /></a>
					<div class="nav-collapse collapse">
						<c:if test="${pageContext.request.remoteUser != null}">
							<div>
								<form class="navbar-form pull-right" action="${root}logout"
									method="post">
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" /> <input type="submit"
										value="Log out" />
								</form>
								<p class="navbar-text pull-right">${pageContext.request.remoteUser}</p>
							</div>
						</c:if>
						<ul class="nav">
							<li><a href="${root}">Inbox</a></li>
							<li><a href="${root}">Compose</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- Begin page content -->
		<div class="container">
			<c:url value="/order" var="orderUrl" />
			<form name="f" action="${orderUrl}" method="post">
				<fieldset>
					<legend>Please Login</legend>
					<c:if test="${param.error != null}">
						<div class="alert alert-error">Invalid username and
							password.</div>
					</c:if>
					<c:if test="${param.logout != null}">
						<div class="alert alert-success">You have been logged out.</div>
					</c:if>
					<label for="username">商品描述：</label> <input type="text" id="body"
						name="body" value="${username}" /> <label for="password">商品价格：</label>
					<input type="text" id="total_fee" name="total_fee" /> <input
						type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<div class="form-actions">
						<button type="submit" class="btn">提交订单</button>
					</div>
				</fieldset>
			</form>
		</div>

		<div id="push"></div>
	</div>

	<div id="footer">
		<div class="container">
			<p class="muted credit">
				Visit the <a href="http://spring.io/spring-security">Spring
					Security</a> site for more <a
					href="https://github.com/spring-projects/spring-security/blob/master/samples/">samples</a>.
			</p>
		</div>
	</div>
</body>
	</html>
</jsp:root>