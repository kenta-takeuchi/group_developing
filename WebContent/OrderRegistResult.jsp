<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>登録完了</title>
    <link rel="stylesheet" href="css/master.css">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/semantic.min.js"></script>
  </head>
<body>
  <div class="ui container">
    <div class="ui borderless topmenu menu">
      <div class="ui container aq-header">
        <h1 class="ui center aligned">受注管理システム</h1>
      </div>
    </div>
    <div class="aq-wrapper">
      <div class="ui raised very padded center aligned text container segment">
        <div class="ui green message">
          <div class="header">
           登録が完了しました。
          </div>
        </div>
        <br>
        <div class="actions">
          <form action="BacktoRegist">
          	<button class="ui large teal button" type="submit">登録画面へ戻る</button>
          </form>
        </div>
        <br>
      </div>
    </div>
  </div>
</body>
</html>