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
<% for(int i = 0; i < usersList.size(); i++) { %>
<p><%= usersList.get(i) %></p>
<% } %>
</body>
</html>