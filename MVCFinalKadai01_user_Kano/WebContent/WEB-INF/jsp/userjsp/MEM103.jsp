<!--
会員番号発行
会員登録を完了し、ユーザーに会員Noを通知する。
2022年9月9日
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員番号発行</title>
</head>
<body>
	<div>
		会員登録が完了しました。
		<br>
		あなたの会員NOは
		<c:out value="" />
		です。
		<input type="button" onclick="location.href='default_login.html'" value="メニューへ">
	</div>
</body>
</html>