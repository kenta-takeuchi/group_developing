<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title>受注変更</title>
<link rel="stylesheet" href="css/master.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/semantic.min.js"></script>
</head>
<body>
	<div class="ui container">
		<div class="ui borderless topmenu menu">
			<div class="ui container aq-header">
				<h1>受注変更フォーム</h1>
			</div>
		</div>
		<div class="aq-wrapper">
			<div
				class="ui raised very padded center aligned text container segment">
				<form class="ui form" action="OrderUpdateServlet?action=regist"
					method="post" method="post">
					<div class="field">
						<h2>得意先コード</h2>
						<input type="text" name="customer" value="${customer_code}" required>
					</div>
					<div class="field">
						<h2>商品入力</h2>
					</div>
					<div class="four fields">
						<div class="field">
							<label class="ui label">番号</label>
						</div>
						<div class="field">
							<label class="ui label">商品名</label> <br>

						</div>
						<div class="field">
							<label class="ui label">受注数</label> <br>
						</div>
					</div>
					<!--c:forEach items = "${items}" var = "item" varStatus = "stat"
            	var ="i" begin = "1" end = "10" step = "1"-->
					<c:forEach items="${order_details}" var="od" varStatus="stat">
						<div class="four fields">
							<div class="field">
								<p>${stat.count}</p>
							</div>
							<div class="field">
								<select class="ui select" name="product_${stat.count}">
									<c:forEach items="${products}" var="p">
										<c:choose>
											<c:when test="${p.code eq od.product_code}">
												<option value="${p.code}" selected>${p.name}</option>
											</c:when>
											<c:otherwise>
												<option value="${p.code}">${p.name}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</div>
							<div class="field">
								<input type="number" min="1" name="quantity_${stat.count}"
									value="${od.quantity}">
							</div>
						</div>
					</c:forEach>
					<input type="hidden" name="code" value="${order_id}">
					<button type="submit" class="ui large teal button">登録</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
