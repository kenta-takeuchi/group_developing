<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>受注検索詳細表示</title>
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
				<h1 class="ui center aligned">受注詳細${order_code} TODO
					受注コードをorder_codeで受け取る前提</h1>
				<!--form action="OrderShowUpdateFormServlet?action=update" method = "post">
	          <select name = "code">
		          <option value="1">1
	          </select>
          </form-->
			</div>
		</div>
		<table class="ui celled padded table">
			<thead>
				<tr>
					<th>番号</th>
					<th>カテゴリ</th>
					<th>商品名</th>
					<th>受注数</th>
					<th>商品単価</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${orderDetails}" var="orderDetail"
					varStatus="stat">
					<tr>
						<td>${stat.count}</td>
						<td class="single line">${orderDetail.category}</td>
						<td>${orderDetail.productName}</td>
						<td>${orderDetail.quantity}</td>
						<td>${orderDetail.productPrice}</td>
					</tr>
				</c:forEach>
				<tr>
					<td>1</td>
					<td class="single line">test</td>
					<td>test</td>
					<td>test</td>
					<td>test</td>
				</tr>
				<tr>
					<td>2</td>
					<td>test</td>
					<td>test</td>
					<td>test</td>
					<td>test</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="12" class="center aligned">
						<form action="ShowOrderUpdateFormServlet" method="post">
							<input type="hidden" name="order_id" value="0001">
							<button class="ui button teal" type="submit" name="update">変更</button>
						</form>
						<form action="OrderShowUpdateFormServlet" method="post">
							<input type="hidden" name="order_id" value="0001">
							<button class="ui button" type="submit" name="delete">削除</button>
						</form>
					</th>
				</tr>
			</tfoot>
		</table>
		<p>TODO 検索結果は${orderDetail}で受け取る前提</p>
	</div>
</body>
</html>
