<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
  <meta charset="utf-8">
  <title>受注登録</title>
  <link rel="stylesheet" href="css/master.css">
  <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
  <script src="js/semantic.min.js"></script>
</head>
<body>
  <div class="ui container">
    <div class="ui borderless topmenu menu">
      <div class="ui container aq-header">
        <h1>受注登録フォーム</h1>
      </div>
    </div>
      <div class="aq-wrapper">
        <div class="ui raised very padded center aligned text container segment">
          <form class="ui form" action="/group_developing/ShowInputFormServlet?action=regist">
            <div class="field">
              <h2>得意先コード</h2>
              <input type="text" name="customer_code" placeholder="半角数字のみ" required>
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
                <input type="text" name="category_code" required>
              </div>
              <div class="field">
                <label class="ui label">商品名</label>
                <br>
                <input type="text" name="name" required>
              </div>
              <div class="field">
                <label class="ui label">受注数</label>
                <br>
                <input type="number" min="1" name="quantity" required>
              </div>
            </div>

            <div class="four fields">
              <div class="field">
                <p>2</p>
              </div>
              <div class="field">
                <input type="text" name="category_code">
              </div>
              <div class="field">
                <input type="text" name="name">
              </div>
              <div class="field">
                <input type="number" min="1" name="quantity">
              </div>
            </div>

            <div class="four fields">
              <div class="field">
                <p>3</p>
              </div>
              <div class="field">
                <input type="text" name="category_code">
              </div>
              <div class="field">
                <input type="text" name="name">
              </div>
              <div class="field">
                <input type="number" min="1" name="quantity">
              </div>
            </div>
            <div class="four fields">
              <div class="field">
                <p>4</p>
              </div>
              <div class="field">
                <input type="text" name="category_code">
              </div>
              <div class="field">
                <input type="text" name="name">
              </div>
              <div class="field">
                <input type="number" min="1" name="quantity">
              </div>
            </div>

            <div class="four fields">
              <div class="field">
                <p>5</p>
              </div>
              <div class="field">
                <input type="text" name="category_code">
              </div>
              <div class="field">
                <input type="text" name="name">
              </div>
              <div class="field">
                <input type="number" min="1" name="quantity">
              </div>
            </div>

            <div class="four fields">
              <div class="field">
                <p>6</p>
              </div>
              <div class="field">
                <input type="text" name="category_code">
              </div>
              <div class="field">
                <input type="text" name="name">
              </div>
              <div class="field">
                <input type="number" min="1" name="quantity">
              </div>
            </div>

            <div class="four fields">
              <div class="field">
                <p>7</p>
              </div>
              <div class="field">
                <input type="text" name="category_code">
              </div>
              <div class="field">
                <input type="text" name="name">
              </div>
              <div class="field">
                <input type="number" min="1" name="quantity">
              </div>
            </div>

            <div class="four fields">
              <div class="field">
                <p>8</p>
              </div>
              <div class="field">
                <input type="text" name="category_code">
              </div>
              <div class="field">
                <input type="text" name="name">
              </div>
              <div class="field">
                <input type="number" min="1" name="quantity">
              </div>
            </div>

            <div class="four fields">
              <div class="field">
                <p>9</p>
              </div>
              <div class="field">
                <input type="text" name="category_code">
              </div>
              <div class="field">
                <input type="text" name="name">
              </div>
              <div class="field">
                <input type="number" min="1" name="quantity">
              </div>
            </div>

            <div class="four fields">
              <div class="field">
                <p>10</p>
              </div>
              <div class="field">
                <input type="text" name="category_code" >
              </div>
              <div class="field">
                <input type="text" name="name">
              </div>
              <div class="field">
                <input type="number" min="1" name="quantity">
              </div>
            </div>

            <button type="submit" class="ui large teal button">登録</button>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
