<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>受注詳細</h1>
<c:forEach items="${items}"var="item">
<form action= "/.jsp">

受注コード<b>${OrderDetail.order_id }</b>
商品コード<b>${OrderDetail.product_code}</b>
受注商品数量<b>${OrderDetail.quantity}</b>
受注合計金額<b>${OrderDetail.total_fee}</b>


</form>




</c:forEach>






</body>
</html>