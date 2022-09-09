<!--
会員情報確認画面
ユーザーが入力した会員情報を確認するページ
2022年9月9日
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報確認</title>
</head>
<body>
	<form action="newMemberRegister.html" method="POST">
		<div>
			この内容で登録しますか？
			<br>
			●会員情報
			<br>
		</div>
		<table border="1">
			<thead>
			</thead>
			<tbody>
				<tr>
					<th>氏名</th>
					<td><c:out value="${memberModel.name}"/></td>
				</tr>
				<tr>
					<th>年齢</th>
					<td><c:out value="${memberModel.age}"/></td>
				</tr>
				<tr>
					<th>性別</th>
					<td><c:out value="${memberModel.sex}"/></td>
				</tr>
				<tr>
					<th>郵便番号</th>
					<td><c:out value="${memberModel.zip}"/></td>
				</tr>
				<tr>
					<th>住所</th>
					<td><c:out value="${memberModel.address}"/></td>
				</tr>
				<tr>
					<th>電話番号</th>
					<td><c:out value="${memberModel.tel}"/></td>
				</tr>
			</tbody>


		</table>


		<input type="submit" value="登録">
		<input type="button" value="戻る">
	</form>
</body>
</html>