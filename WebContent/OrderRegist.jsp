<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title>受注登録</title>
<link rel="stylesheet" href="css/master.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/semantic.min.js"></script>
</head>
<body>
	<div class="ui container">
		<div class="ui borderless topmenu menu">
			<div class="ui container aq-header">
				<h1 class="ui center aligned">受注登録</h1>
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
				<form class="ui form"
					action="/group_developing/ShowInputFormServlet?action=regist"
					method="post">
					<div class="field">
						<h2>得意先コード</h2>
						<input type="text" name="customer_code" placeholder="半角数字のみ"
							required>
					</div>
					<div class="field">
						<h2>商品入力</h2>
					</div>

					<div class="three fields">
						<div class="field">
							<label class="ui label">番号</label>
						</div>
						<div class="field">
							<label class="ui label">商品名</label>
						</div>
						<div class="field">
							<label class="ui label">受注数</label>
						</div>
					</div>

					<c:forEach begin="1" end="10" varStatus="stat">
						<div class="three fields">
							<div class="field">
								<p>${stat.count}</p>
							</div>
							<div class="field">
								<select class="ui select" name="product_code_${stat.count}">
									<option value="-----">-----</option>
									<c:forEach items="${products}" var="p">
										<option value="${p.code}">${p.name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="field">
								<input type="number" min="1" name="quantity_${stat.count}">
							</div>
						</div>
					</c:forEach>

					<button type="submit" class="ui teal button">登録</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
