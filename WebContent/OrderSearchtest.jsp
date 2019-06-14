<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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

  <form action = "/group_developing/HelloServlet" method="post">


    <div class="ui container">
      <div class="ui borderless topmenu menu">
        <div class="ui container aq-header">
          <h1 class="ui center aligned">受注検索フォーム</h1>
        </div>
      </div>
      <div class="aq-wrapper">
          <h2 class="ui header">受注検索</h2>
          <div class="field inline">
            <label>登録日</label>
            <div class="ui input">
              <input class="prompt" type="date">
            </div>
          </div>
          <br>
          <div class="field inline">
            <label>仕入れ先コード</label>
            <div class="ui input">
              <input class="prompt" type="text">
            </div>
          </div>
          <br>
          <div class="field inline">
            <label>受注スタッフコード</label>
            <div class="ui input">
              <input class="prompt" type="text">
            </div>
          </div>
          <br>
          <div class="actions">

          <button class=" ui large teal button" type="submit">検索</button>

          </div>
      </div>
    </div>
</form>
</body>

</html>