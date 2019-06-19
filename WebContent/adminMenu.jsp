<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title>管理者メニュー</title>
<link rel="stylesheet" href="css/master.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/semantic.min.js"></script>
</head>
<body>
	<div class="ui container">

		<div class="ui borderless topmenu menu">
			<div class="ui container aq-header">
				<h1 class="ui center aligned">管理者メニュー</h1>
			</div>
			<div class="ui header item">
				<form class="ui form" action="/group_developing/LogoutServlet"
					method="post">
					<button class="negative ui button" type="submit">ログアウト</button>
				</form>
			</div>
		</div>

		<div class="aq-wrapper">
			<div
				class="ui raised very padded center aligned text container segment">
				<div class="ui link list">
					<h2 class="ui header">受注分析/集計</h2>
					<br>
					<form class="ui form"
						action="/group_developing/ShowOrderAnalyzeServlet" method="post">
						<div class="field inline">
							<label>受注分析：</label>
							<div class="ui input">
								<select class="ui select" name="year">
									<option value="2018">2019年</option>
									<option value="2019" selected>2019年</option>
									<option value="2020">2020年</option>
									<option value="2021">2021年</option>
									<option value="2022">2022年</option>
									<option value="2023">2023年</option>
									<option value="2024">2024年</option>
									<option value="2025">2025年</option>
								</select>
							</div>
							<div class="ui input">
								<select class="ui select" name="month">
									<option value="01">1月</option>
									<option value="02">2月</option>
									<option value="03">3月</option>
									<option value="04">4月</option>
									<option value="05">5月</option>
									<option value="06">6月</option>
									<option value="07">7月</option>
									<option value="08">8月</option>
									<option value="09">9月</option>
									<option value="10">10月</option>
									<option value="11">11月</option>
									<option value="12">12月</option>
								</select>
							</div>
							<button class="ui teal button field" type="submit">分析</button>
						</div>
					</form>
					<form class="ui form"
						action="/group_developing/ShowOrderTotalServlet" method="post">
						<div class="field inline">
							<label>受注集計：</label>
							<div class="ui input">
								<select class="ui select" name="year">
									<option value="2018">2019年</option>
									<option value="2019" selected>2019年</option>
									<option value="2020">2020年</option>
									<option value="2021">2021年</option>
									<option value="2022">2022年</option>
									<option value="2023">2023年</option>
									<option value="2024">2024年</option>
									<option value="2025">2025年</option>
								</select>
							</div>
							<div class="ui input">
								<select class="ui select" name="month">
									<option value="01">1月</option>
									<option value="02">2月</option>
									<option value="03">3月</option>
									<option value="04">4月</option>
									<option value="05">5月</option>
									<option value="06">6月</option>
									<option value="07">7月</option>
									<option value="08">8月</option>
									<option value="09">9月</option>
									<option value="10">10月</option>
									<option value="11">11月</option>
									<option value="12">12月</option>
								</select>
							</div>
							<button class="ui green button field" type="submit">集計</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
