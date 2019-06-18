<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>受注詳細</h1>
	<c:forEach items="${sr}" var="order">
	<tr><td>${OrderDetailBean.order_id}</td></tr>
	<tr><td>${OrderDetailBean.customer_code}</td></tr>
	<tr><td>${OrderDetailBean.quantity}</td></tr>
	<tr><td>${OrderDetailBean.total_fee}</td></tr>
	<tr><td>${OrderDetailBean.total_fee / OrderDetailBean.total_fee}</td></tr>



	</c:forEach>




</body>
</html>