<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>受注分析表</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.2/semantic.min.css">
  <link rel="stylesheet" type="text/css" href="css/master.css">
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.2/semantic.min.js"></script>
</head>
<body>
  <div class="ui container">
    <div class="ui borderless topmenu menu">
      <div class="ui container aq-header">
        <h1 class="ui center aligned">分析表</h1>
      </div>
    </div>
    <form class="ui form" action="" method="post">
      <table class="ui celled padded table">
        <thead>
          <tr>
            <th>商品名</th>
            <th>商品コード</th>
      　    <th>売り上げ</th>
      　    <th>前月売り上げ</th>
      　    <th>前月比</th>
      　  </tr>
    　  </thead>
        <tbody>
          <tr>
            <td>test</td>
            <td>test</td>
            <td>test</td>
            <td>test</td>
            <td>test</td>
          </tr>
          <tr>
            <td>test</td>
            <td>test</td>
            <td>test</td>
            <td>test</td>
            <td>test</td>
          </tr>
        </tbody>
        <tfoot>
          <tr>
            <th colspan="12" class="center aligned">
              <button class="ui button teal"type="button" name="button">メニューに戻る</button>
            </th>
          </tr>
        </tfoot>
      </table>
    </form>
  </div>
</body>
</html>
