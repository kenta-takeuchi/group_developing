<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<h1 class="ui center aligned">受注詳細（注文番号：${order_id}）</h1>
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
					<th colspan="12">
						<div class="ui form raised very padded center aligned text aq-margin">
							<div class="inline fields">
								<form
									action="/group_developing/ShowOrderUpdateFormServlet"
									method="post" class="field">
									<input type="hidden" name="order_id" value="${order_id}">
									<button class="ui left button teal" type="submit" name="button">変更</button>
								</form>
								<form action="/group_developing/ShowOrderDeleteConfirmServlet"
									method="post" class="field">
									<input type="hidden" name="order_id" value="${order_id}">
									<button class="ui right  button" type="submit" name="button">削除</button>
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


