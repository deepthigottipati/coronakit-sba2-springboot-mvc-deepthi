<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"
	prefix="spring-form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">

<title>Signin Template for Bootstrap</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.0/examples/sign-in/">

<!-- Bootstrap core CSS -->
<link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="signin.css" rel="stylesheet">

<meta charset="ISO-8859-1">
<title>Custom Login Page</title>

<style>
.failed {
	color: red;
}
</style>
</head>
<body class="text-center">
	<core:if test="${param.error != null}">
		<i class="failed">Invalid Credentials!!!</i>
	</core:if>

	<spring-form:form class="form-signin" action="${pageContext.request.contextPath}/validate"
		method="POST">

		<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		<br />
		<br />
		<label class="sr-only">Enter user name</label>
		<input type="text" name="username" />
		<br />
		<br />
		<label class="sr-only">Enter password</label>
		<input type="password" name="password" />
		<br />
		<br />
		<input type="submit" value="Login" />
	</spring-form:form>
	<core:if test="${param.logout != null}">
		<i>You have been logged out successfully!!!</i>
	</core:if>


</body>