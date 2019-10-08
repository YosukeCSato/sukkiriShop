<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
List<String> usersList = (List<String>) request.getAttribute("usersList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー一覧</title>
</head>
<body>
<form action="/sukkiriShop/AdminServlet?action=confirm" method="post">
<% for(int i = 0; i < usersList.size(); i++) { %>
<% String user = usersList.get(i); %>
<input type="checkbox" value="<%= user %>" name="userId"><%= user %><br>
<% } %>
<input type="submit" value="削除">
</form>
</body>
</html>