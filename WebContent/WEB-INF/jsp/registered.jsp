<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録完了！</title>
</head>
<body>
<h1>登録完了！！！！</h1>
<p>ユーザーID：<c:out value="${account.userId}" /></p>
<p>メールアドレス：<c:out value="${account.mail}" /></p>
<p>名前：<c:out value="${account.name}" /></p>
<p>年齢：<c:out value="${account.age}" /></p>
<a href="/sukkiriShop/WelcomeServlet">トップへ</a>
</body>
</html>