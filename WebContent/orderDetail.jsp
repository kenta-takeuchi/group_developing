<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>受注検索詳細表示</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.2/semantic.min.css">
    <link rel="stylesheet" type="text/css" href="css/master.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.2/semantic.min.js"></script>
  </head>
  <body>
    <div class="ui container">
      <form class="ui form" action="/group_developing/ShowOrderAnalyzeServlet" method="post">
        <div class="ui borderless topmenu menu">
          <div class="ui container aq-header">
            <h1 class="ui center aligned">受注詳細(受注コードが入る)</h1>
          </div>
        </div>
        <table class="ui celled padded table">
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
                <button class="ui button teal"type="button" name="button">編集</button>
                <button class="ui button"type="button" name="button">削除</button>
              </th>
            </tr>
          </tfoot>
        </table>
      </form>
    </div>
  </body>
</html>
