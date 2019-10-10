<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ商店</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/JavaScript" src="/sukkiriShop/js/sample.js"></script>
</head>
<body>
<h1><img src="${pageContext.request.contextPath}/images/login.png" alt="ログイン画面" width="20%" height="20%"></h1>
<!-- <h1><img src="./images/logo.png" alt="ログイン画面"></h1> -->
<p>ログイン画面</p>
<form action="/sukkiriShop/LoginServlet" method="post">
ユーザーID：<input type="text" name="userId"><br>
パスワード：<input type="password" name="pass"><br>
<input type="submit" value="ログイン">
</form>
</body>
</html>