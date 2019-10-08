<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%
String action = (String)request.getAttribute("action");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者画面</title>
</head>
<body>
<% if(action == null) { %>
  <p>下記のユーザーを削除します</p>
  <p>ユーザーID：${userId}</p>
  <form action="/sukkiriShop/AdminServlet?action=delete" method="post">
  <input type="submit" value="削除">
  <input type="hidden" value="${userId}" name="userId">
  </form>
<% } else {%>
  <p>${userId}を削除しました</p>
  <form action="/sukkiriShop/AdminServlet" method="post">
  <input type="submit" value="戻る">
  </form>
<% } %>

</body>
</html>