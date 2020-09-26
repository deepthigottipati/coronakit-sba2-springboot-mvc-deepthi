<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cart</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

</head>
<body>
	<jsp:include page="userheader.jsp" />
	<section class="container-fluid p-4">
		<h3>Your Cart</h3>

<c:choose>
		<c:when test="${theKit==null || theKit.isEmpty() }">
			<p>Kit is empty</p>
		</c:when>
		<c:otherwise>
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>kit id</th>
					<th>carona kit id</th>
					<th>Product id</th>
					<th>quantity</th>
					<th>amount</th>
					
				</tr>
				<c:forEach items="${theKit}" var="kit">
				
					<tr>
						<td>${kit.id}</td>
						<td>${kit.coronaKitId }</td>
						<td>${kit.productId }</td>
						<td>${kit.quantity }</td>
						<td>${kit.amount }</td>
						<td>
						<a href="delete/${kit.id}">DELETE FORM KIT</a><span>|</span>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>

	</section>
	<hr/>
<a href="${pageContext.request.contextPath}/user/finalize"><input type="button" value="Finalize" /></a>
</body>
</html>