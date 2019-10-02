<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録内容確認</title>
</head>
<body>
登録内容確認
<p>ユーザーID<c:out value="${account.userId}" /></p>
<p>メールアドレス<c:out value="${account.mail}" /></p>
<p>名前<c:out value="${account.name}" /></p>
<p>年齢<c:out value="${account.age}" /></p>
<form action="/sukkiriShop/CreateAccountServlet?action" method="post">
<input type="submit" value="登録">
<input type="hidden" name="account" value="${account}">
</form>
</body>
</html>