<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>受注検索</title>
	<link rel="stylesheet" href="css/master.css">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/semantic.min.js"></script>
</head>
<body>
	<div class="ui container">
		<div class="ui borderless topmenu menu">
			<div class="ui container aq-header">
				<h1 class="ui center aligned">受注検索フォーム</h1>
			</div>
		</div>
		<div class="aq-wrapper">
			<form class="ui form raised very padded center aligned text container segment" action="/group_developing/SearchServlet" method="post">
				<!--入力項目に不備があった場合、もしくはデータがなかった場合に以下にエラーメッセージを加えて検索画面に戻ってくる  -->
				<p>${message}</p>
				<h2 class="ui header">受注検索</h2>
				<div class="field inline">
					<label>登録日</label>
					<div class="ui input">
						<input class="prompt" name="ordered_date" type="text" placeholder="yyyy-mm-dd">
					</div>
				</div>
				<br>
				<div class="field inline">
					<label>得意先コード</label>
					<div class="ui input">
						<input class="prompt" name="customer_code" type="text">
					</div>
				</div>
				<br>
				<div class="field inline">
					<label>受注スタッフコード</label>
					<div class="ui input">
						<input class="prompt" name="employee_code" type="text">
					</div>
				</div>
				<br>
				<div class="actions">
					<button class=" ui large teal button" type="submit">検索</button>
				</div>

			</form>
		</div>
	</div>

</body>

</html>





