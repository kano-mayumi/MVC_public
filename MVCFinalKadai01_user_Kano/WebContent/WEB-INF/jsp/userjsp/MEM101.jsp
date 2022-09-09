<!--
会員情報入力画面
新規に会員登録をしようとするユーザーが必要な情報を入力するページ
2022年9月9日
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報入力</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/user.css">
</head>
<body>
	<form action="newMemberRegistrationConfilm.html" method="POST">
		氏名
		<input type="text" name="name">
		<br>
		パスワード
		<input type="password" name="password">
		<br>
		パスワード(確認用)
		<input type="password" name="passwordCheck">
		<br>
		年齢
		<input type="text" name="age">
		<br>
		性別
		<select  name="sex">
			<option value="female">女性</option>
			<option value="male">男性</option>
		</select>
		<br>
		郵便番号<input type="text" name="zip">
		<br>
		住所 <textarea  name="address"></textarea>
		<br>
		電話番号<input type="text" name="tel">
		<br>

	<input type="submit" value="確認">
	<input type="button" onclick="location.href='default_login.html'" value="戻る">
	<input type="button" value="クリア">
	</form>
</body>
</html>