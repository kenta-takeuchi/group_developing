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
	<c:forEach items="${order}" var="order">
	<tr><td>${OrderBean.order_id}</td></tr>
	<tr><td>${OrderBean.customer_code}</td></tr>
	<tr><td>${OrderBean.employee_code}</td></tr>
	<tr><td>${OrderBean.ordered_date}</td></tr>
	<tr><td>${OrderBean.tax}</td></tr>
	<tr><td>${OrderBean.count_of_order_detail}</td></tr>
	<tr><td>${OrderBean.total_fee}</td></tr>


	</c:forEach>




</body>
</html>