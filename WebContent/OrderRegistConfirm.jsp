<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
          <h1>受注変更</h1>
        </div>
      </div>
      <div class="ui negative message">
        <div class="header">
          以下の受注を変更します。
        </div>
        <p>よろしければ確認ボタンを押してください。</p>
      </div>
      <table class="ui celled padded table center aligned">
        <thead>
          <tr>
            <th>番号</th>
          　<th>カテゴリ</th>
        　  <th>商品名</th>
        　  <th>受注数</th>
        　  <th>商品単価</th>
        　</tr>
      　</thead>
        <tbody>
          <tr>
            <td>1</td>
            <td class="single line">test</td>
            <td>test</td>
            <td>test</td>
            <td>test</td>
          </tr>
          <tr>
            <td>2</td>
            <td>test</td>
            <td>test</td>
            <td>test</td>
            <td>test</td>
          </tr>
        </tbody>
        <tfoot>
          <tr>
            <th colspan="12" class="center aligned">
              <button class="ui button teal"type="button" name="button">確認</button>

            </th>
          </tr>
        </tfoot>
      </table>
      <button class="ui button green"type="button" name="">
        TOPに戻る
      </button>
    </div>
  </body>
</html>
