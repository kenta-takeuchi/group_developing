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
    <script src="js/script.js"></script>
  </head>
  <body>
    <div class="ui container">
      <div class="ui borderless topmenu menu">
        <div class="ui container aq-header">
          <h1>受注登録</h1>
        </div>
      </div>
      <div class="ui green message">
        <div class="header">以下の受注を登録します</div>
        <p>よろしければ確認ボタンを押してください。</p>
       </div>
       <form class="ui form" action="/group_developing/ConfirmControllerServlet" method="post">
         <label class="ui label large">
           得意先コード：${customer_code}
         </label>
         <table class="ui celled padded table center aligned">
          <thead>
            <tr>
              <th>番号</th>
              <th>商品名</th>
              <th>受注数</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${list}" var="bean" varStatus="stat">
              <tr>
                <td class="single line">${stat.count}</td>
                <td>${bean.product_code}</td>
                <td>${bean.quantity}</td>
              </tr>
              <input type="hidden" name="product_code_${stat.count}" value="${bean.product_code}">
              <input type="hidden" name="quantity_${stat.count}" value="${bean.quantity}">
            </c:forEach>
          </tbody>
          <tfoot>
            <tr>
              <th colspan="12" class="center aligned">
                <button class="ui button teal" type="submit" name="button">確認</button>
                <input type="hidden" name="customer_code" value="${customer_code}">
                <input type="hidden" name="order_id" value="${order_id}">
              </th>
            </tr>
          </tfoot>
        </table>
      </form>
      <form class="ui form" action="BacktoRegist" method="post">
        <button class="ui button green" type="submit" name="">
          TOPに戻る
        </button>
       </form>
    </div>
  </body>
</html>
