<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.2/semantic.min.css">
	    <link rel="stylesheet" href="css/master.css">
	    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	    <script src="js/semantic.min.js"></script>
		<title>メッセージ</title>
	</head>
	<body>
		<div class="ui container">
			<div class="ui borderless topmenu menu">
		     	<div class="ui container aq-header">
					<h1>メッセージフォーム</h1>
				</div>
			</div>
		</div>
		<div class="aq-wrapper">
		    <div class="ui raised very padded center aligned text container segment">
			    <div class="ui negative message">
			    	<div class="header">
							${message}
					</div>
				</div>
				<br>
				<div>
					<div class="center aligned">
						<form class="ui form" action="/group_developing/adminMenu.jsp" method="post">
							<button class="ui button teal" type="submit" name="button">管理者メニューに戻る</button>
						</form>
					</div><br>
					<div class="center aligned">
						<form class="ui form" action="/group_developing/MainMenu.jsp" method="post">
							<button class="ui button teal" type="submit" name="button">メインメニューに戻る</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>