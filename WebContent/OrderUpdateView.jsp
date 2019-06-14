<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>受注変更</title>
    <link rel="stylesheet" href="css/master.css">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/semantic.min.js"></script>
  </head>
  <body>
    <div class="ui container">
      <div class="ui borderless topmenu menu">
        <div class="ui container aq-header">
          <h1>受注変更フォーム</h1>
        </div>
      </div>
      <div class="aq-wrapper">
        <div class="ui raised very padded center aligned text container segment">
          <form class="ui form" action="OrderUpdateServlet?action=regist" method = "post" method = "post">
            <div class="field">
              <h2>得意先コード</h2>
              <input type="text" name="" placeholder="半角数字のみ" required>
            </div>
            <div class="field">
              <h2>商品入力</h2>
            </div>

            <div class="four fields">
              <div class="field">
                <label class="ui label">番号</label>
                <br>
                <p>1</p>
              </div>
              <div class="field">
                <label class="ui label">カテゴリ</label>
                <br>
                <input type="text" name="" placeholder="" required>
              </div>
              <div class="field">
                <label class="ui label">商品名</label>
                <br>
                <input type="text" name="" placeholder="" required>
              </div>
              <div class="field">
                <label class="ui label">受注数</label>
                <br>
                <input type="number" min="1" name="" placeholder="" required>
              </div>
            </div>

            <div class="four fields">
              <div class="field">
                <p>2</p>
              </div>
              <div class="field">
                <input type="text" name="" placeholder="" >
              </div>
              <div class="field">
                <input type="text" name="" placeholder="" >
              </div>
              <div class="field">
                <input type="number" min="1" name="" placeholder="" >
              </div>
            </div>

            <div class="four fields">
              <div class="field">
                <p>3</p>
              </div>
              <div class="field">
                <input type="text" name="" placeholder="" >
              </div>
              <div class="field">
                <input type="text" name="" placeholder="" >
              </div>
              <div class="field">
                <input type="number" min="1" name="" placeholder="" >
              </div>
            </div>

            <div class="four fields">
              <div class="field">
                <p>4</p>
              </div>
              <div class="field">
                <input type="text" name="" placeholder="" >
              </div>
              <div class="field">
                <input type="text" name="" placeholder="" >
              </div>
              <div class="field">
                <input type="number" min="1" name="" placeholder="" >
              </div>
            </div>

            <div class="four fields">
              <div class="field">
                <p>5</p>
              </div>
              <div class="field">
                <input type="text" name="" placeholder="" >
              </div>
              <div class="field">
                <input type="text" name="" placeholder="" >
              </div>
              <div class="field">
                <input type="number" min="1" name="" placeholder="" >
              </div>
            </div>

            <div class="four fields">
              <div class="field">
                <p>6</p>
              </div>
              <div class="field">
                <input type="text" name="" placeholder="" >
              </div>
              <div class="field">
                <input type="text" name="" placeholder="" >
              </div>
              <div class="field">
                <input type="number" min="1" name="" placeholder="" >
              </div>
            </div>

            <div class="four fields">
              <div class="field">
                <p>7</p>
              </div>
              <div class="field">
                <input type="text" name="" placeholder="" >
              </div>
              <div class="field">
                <input type="text" name="" placeholder="" >
              </div>
              <div class="field">
                <input type="number" min="1" name="" placeholder="" >
              </div>
            </div>

            <div class="four fields">
              <div class="field">
                <p>8</p>
              </div>
              <div class="field">
                <input type="text" name="" placeholder="" >
              </div>
              <div class="field">
                <input type="text" name="" placeholder="" >
              </div>
              <div class="field">
                <input type="number" min="1" name="" placeholder="" >
              </div>
            </div>

            <div class="four fields">
              <div class="field">
                <p>9</p>
              </div>
              <div class="field">
                <input type="text" name="" placeholder="" >
              </div>
              <div class="field">
                <input type="text" name="" placeholder="" >
              </div>
              <div class="field">
                <input type="number" min="1" name="" placeholder="" >
              </div>
            </div>

            <div class="four fields">
              <div class="field">
                <p>10</p>
              </div>
              <div class="field">
                <input type="text" name="" placeholder="" >
              </div>
              <div class="field">
                <input type="text" name="" placeholder="" >
              </div>
              <div class="field">
                <input type="number" min="1" name="" placeholder="" >
              </div>
            </div>
            <input type="hidden" name="code" value="${orderCode}">
            <button type="submit"class="ui large teal button">登録</button>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
