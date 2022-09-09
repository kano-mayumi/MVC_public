<!--
会員情報画面
ログインしているユーザーの登録情報を確認するページ/
会員情報修正・会員情報削除を行うための窓口としてのページ
2022年9月9日
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/user.css">

</head>
<body>


	<input type="submit" onclick="location.href='.html'" value="修正">
	<input type="submit" onclick="location.href='.html'" value="削除">
	<input type="button" onclick="location.href='default_login.html'" value="戻る">
</body>
</html>