<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>受注集計表</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.2/semantic.min.css">
    <link rel="stylesheet" type="text/css" href="css/master.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.2/semantic.min.js"></script>
  </head>
  <body>
    <div class="ui container">
      <div class="ui borderless topmenu menu">
        <div class="ui container aq-header">
          <h1 class="ui center aligned">集計表</h1>
        </div>
      </div>
      <div class="ui segment center aligned text container">
        <div class="ui small statistics">
          <div class="statistic">
            <h2>受注総計</h2>
          </div>
          <div class="pink statistic">
            <div class="label">受注件数</div>
            <div class="value">${count_of_order_detail}</div>
            <div class="label">件</div>
          </div>
          <div class="orange statistic">
            <div class="label">受注総額</div>
            <div class="value">${total_fee}</div>
            <div class="label">円</div>
          </div>
        </div>
      </div>
      <form class="ui form" action="/group_developing/ShowAdminMenuServlet" method="post">
        <table class="ui celled padded table" style="width: 100%; height: 200px; ">
          <thead>
            <tr>
              <th>日にち</th>
              <th>受注件数</th>
              <th>受注合計金額</th>
              <th>平均受注金額</th>
              <th>最高受注額</th>
            </tr>
          </thead>
          <tbody style="height: 200px; overflow-y:scroll;">
            <c:forEach items="${order_totals}" var="ot">
              <tr>
                <th>${ot.ordered_date}</th>
                <th>${ot.count_of_order_detail}</th>
                <th>${ot.total_fee}</th>
                <th>${ot.average_fee}</th>
                <th>${ot.max_fee}</th>
              </tr>
            </c:forEach>
          </tbody>
          <tfoot>
            <tr>
              <th colspan="12" class="center aligned">
                <button class="ui button teal" type="submit" name="">メニューに戻る</button>
              </th>
            </tr>
          </tfoot>
        </table>
      </form>
    </div>
  </body>
</html>
