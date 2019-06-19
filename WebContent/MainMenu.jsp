<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>受注担当者メニュー</title>
    <link rel="stylesheet" href="css/master.css">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/semantic.min.js"></script>
  </head>
  <body>
    <div class="ui container">
      <div class="ui borderless topmenu menu">
        <div class="ui container aq-header">
          <h1 class="ui center aligned">受注担当者メニュー</h1>
        </div>
        <div class="ui header item">
          <form action="/group_developing/LogoutServlet" method="post">
	          <button class="negative ui button">
	            ログアウト
	          </button>
          </form>
        </div>
      </div>
      <div class="aq-wrapper">
        <div class="ui raised very padded center aligned text container segment">
          <div class="ui link list">
            <h2 class="active">受注管理</h2>
            <a class="item" href="/group_developing/ShowInputFormServlet?action=list">受注登録</a>
            <a class="item" href="/group_developing/ToSearch">検索</a>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
