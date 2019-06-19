<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet"
			href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.2/semantic.min.css">
		<link rel="stylesheet" type="text/css" href="css/master.css">
		<script type="text/javascript"
			src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
		<script type="text/javascript"
			src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.2/semantic.min.js"></script>
		<meta charset="UTF-8">
		<title>メッセージ</title>
	</head>
	<body>
		<div class="ui borderless topmenu menu">
			<div class="ui container aq-header">
				<h1>エラーメッセージ</h1>
			</div>
		</div>
		<table class="ui celled padded table">
			<thead>
				<tr>
					<th class="ui borderless topmenu menu">
						<h1>${message}</h1>
					</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th colspan="12" class="center aligned">
						<form class="ui form" action="/group_developing/MainMenu.jsp" method="post">
						<button class="ui button teal" type="submit" name="button">メインメニューに戻る</button>
						</form>
					</th>
				</tr>
			</tfoot>
		</table>
	</body>
</html>