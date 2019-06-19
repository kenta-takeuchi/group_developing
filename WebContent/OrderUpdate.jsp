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
			<div class="ui header item green">
				<form action="/group_developing/BacktoRegist" method="post">
					<button class="positive ui button">メニューに戻る</button>
				</form>
			</div>
		</div>
		<div class="aq-wrapper">
			<div
				class="ui raised very padded center aligned text container segment">
				<form class="ui form" action="OrderUpdateServlet"
					method="post" method="post">
					<div class="field">
						<h2>得意先コード</h2>
						<input type="text" name="customer_code" value="${customer_code}" required>
					</div>
					<div class="field">
						<h2>商品入力</h2>
					</div>
					<div class="three fields">
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
					<!-- List型のorder_detailsが所有する情報があるだけ繰り返す -->
					<c:forEach items="${order_details}" var="od" varStatus="stat">
						<div class="three fields">
							<div class="field">
								<!-- 情報を数える -->
								<p>${stat.count}</p>
							</div>
							<div class="field">
								<select class="ui select" name="product_code_${stat.count}">
									<!-- 商品名の初期値を----と設定 -->
									<!-- 商品テーブルと受注明細の商品コードが一致したらその商品名を表示させる -->
									<!-- 商品テーブルと受注明細の商品コードが一致しなかったら商品名の初期値を表示させる  -->
									<option value="-----">-----</option>
									<c:forEach items="${products}" var="p">
										<c:choose>
											<c:when test="${p.code == od.product_code}">
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
					<input type="hidden" name="order_id" value="${order_id}">
					<button type="submit" class="ui large teal button">登録</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
