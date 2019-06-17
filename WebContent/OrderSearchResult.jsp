<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>受注検索結果表示</title>
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

				<h1>検索結果一覧</h1>
			</div>
		</div>
		<table class="ui celled padded table center aligned">
			<thead>
				<tr>
					<th>受注コード</th>
					<th>登録日</th>
					<th>得意先コード</th>
					<th>受注スタッフコード</th>
					<th>詳細</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${searchResults}" var="sr">
					<tr>
						<td>${sr.id}</td>
						<td>${sr.date}</td>
						<td>${sr.employee_code}</td>
						<td>${sr.customer_code}</td>
						<td>
							<form class="ui form center aligned"
								action="/OrderSearchDetailServlet?action=detail" method="post">
								<input type="hidden" name="order_id" value="${sr.id}">
								<button class="ui button teal" type="submit" name="detail">詳細をみる</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
