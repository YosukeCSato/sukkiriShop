<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="../js/sample.js"></script>
<meta charset="UTF-8">
<title>スッキリ商店</title>
</head>
<body>
<h1><img src="../../WebContent/logo.png" alt="ログイン画面"></h1>
<p>ログイン画面</p>
<form action="/sukkiriShop/LoginServlet" method="post">
ユーザーID：<input type="text" name="userId"><br>
パスワード：<input type="password" name="pass"><br>
<input type="submit" value="ログイン">
</form>
</body>
</html>