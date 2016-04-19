<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Please Login</title>
<c:url value="/resources/css/" var="cssbase" />
<link href="${cssbase}bootstrap.css" type="text/css" rel="stylesheet" />
<link href="${cssbase}spring-demo.css" type="text/css" rel="stylesheet" />
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
			<c:if test="${globalMessage != null}">
				<div class="alert alert-success">${globalMessage}</div>
			</c:if>
			<div>
				<c:url value="/login" var="loginUrl" />
				<form name="f" action="${loginUrl}" method="post">
					<fieldset>
						<legend>Please Login</legend>
						<c:if test="${param.error != null}">
							<div class="alert alert-error">Invalid username and
								password.</div>
						</c:if>
						<c:if test="${param.logout != null}">
							<div class="alert alert-success">You have been logged out.</div>
						</c:if>
						<label for="username">Username</label> <input type="text"
							id="username" name="username" value="${username}" /> <label
							for="password">Password</label> <input type="password"
							id="password" name="password" /> <input type="hidden"
							name="${_csrf.parameterName}" value="${_csrf.token}" />
						<div class="form-actions">
							<button type="submit" class="btn">Log in</button>
						</div>
					</fieldset>
				</form>
			</div>
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