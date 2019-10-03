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
<c:if test="${errorMsg == null}">
<p>ユーザーID：<c:out value="${account.userId}" /></p>
<p>メールアドレス：<c:out value="${account.mail}" /></p>
<p>名前：<c:out value="${account.name}" /></p>
<p>年齢：<c:out value="${account.age}" /></p>
<form action="/sukkiriShop/CreateAccountServlet" method="post">
<input type="submit" value="登録">
<input type="hidden" name="userId" value="${account.userId}">
<input type="hidden" name="pass" value="${account.pass}">
<input type="hidden" name="mail" value="${account.mail}">
<input type="hidden" name="name" value="${account.name}">
<input type="hidden" name="age" value="${account.age}">
<input type="hidden" name="action" value="confirm">
</form>
</c:if>
<p><c:out value="${errorMsg}" /></p>
<a href="/sukkiriShop/CreateAccountServlet">戻る</a>
</body>
</html>