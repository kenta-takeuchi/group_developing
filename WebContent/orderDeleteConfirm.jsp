<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>受注削除</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.2/semantic.min.css">
<link rel="stylesheet" type="text/css" href="css/master.css">
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.2/semantic.min.js"></script>
</head>
<body>
	<div class="ui container">
		<div class="ui borderless topmenu menu">
			<div class="ui container aq-header">
				<h1>受注削除</h1>
			</div>
		</div>

		<div class="ui negative message">
			<div class="header">注文番号：${order_id} の受注を削除します。</div>
			<p>よろしければ削除ボタンを押してください。</p>
		</div>
		<table class="ui celled padded table center aligned">
			<thead>
				<tr>
					<th>番号</th>
					<th>商品コード</th>
					<th>受注数量</th>
					<th>金額</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${orderDetails}" var="orderDetail" varStatus="stat">
					<tr>
						<td class="single line">${stat.count}</td>
						<td>${orderDetail.product_code}</td>
						<td>${orderDetail.quantity}</td>
						<td>${orderDetail.total_fee}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="12" class="center aligned">
						<div class="ui form raised very padded center aligned text aq-margin">
							<div class="inline fields">
								<form
									action="/group_developing/OrderDeleteServlet"
									method="post" class="field">
									<button class="ui button teal" type="submit" name="button">削除</button>
									<input type="hidden" name="order_id" value="${order_id}">
								</form>
								<form action="/group_developing/ShowMainMenuServlet" method="post" class="field">
									<button class="ui button" type="submit" name="button">戻る</button>
								</form>
							</div>
						</div>
					</th>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
</html>
