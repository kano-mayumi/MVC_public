<!--
会員情報修正
会員情報の修正内容を入力するページ
2022年9月9日
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報修正</title>
</head>
<body>
	<form action="newMemberRegistrationConfilm.html" method="POST">
		<table border="1">
			<thead></thead>
			<tbody>
				<tr>
					<th>会員NO</th>
					<td></td>
				</tr>
				<tr>
					<th>氏名</th>
					<td>
						<input type="text" name="name">
					</td>
				</tr>
				<tr>
					<th>パスワード</th>
					<td>
						<input type="password" name="password">
					</td>
				</tr>
				<tr>
					<th>パスワード(確認用)</th>

					<td>
						<input type="password" name="passwordCheck">
					</td>
				</tr>
				<tr>
					<th>年齢</th>
					<td>
						<input type="text" name="age">
					</td>
				</tr>
				<tr>
					<th>性別</th>
					<td>
						<select name="sex">
							<option value="female">女性</option>
							<option value="male">男性</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>郵便番号</th>
					<td>
						<input type="text" name="zip">
					</td>
				</tr>
				<tr>
					<th>住所</th>
					<td>
						<textarea name="address"></textarea>
					</td>
				</tr>
				<tr>
					<th>電話番号</th>
					<td>
						<input type="text" name="tel">
					</td>
				</tr>
				<tr>
					<th>登録日</th>
					<td></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="確認">
		<input type="button" onclick="location.href='memberInfomationEditAndDelete.html'"
			value="戻る">
		<input type="reset" value="クリア">

	</form>
</body>
</html>