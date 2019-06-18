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
			<i class="close icon"></i>
			<div class="header">以下の受注を削除します。</div>
			<p>よろしければ確認ボタンを押してください。</p>
		</div>
		<table class="ui celled padded table center aligned">
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
						<form class="ui form"
							action="/group_developing/OrderDeleteServlet" method="post">
							<button class="ui button teal" type="submit" name="button">確認</button>
							<input type="hidden" name="order_id" value="0001">
						</form>
					</th>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
</html>
