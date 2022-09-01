<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アンケートフォーム</title>
</head>
<body>
	<h1>入力確認</h1>
	<hr>
	<form action="register.html" method="post">
		<table border="1">
			<tr>
				<td>回答者名</td>
				<td>
					<c:out value="${questionForm.lstName}" />
					<c:out value="${questionForm.fstName}" />
				</td>
			</tr>
			<tr>
				<td>性別</td>
				<td>
					<c:if test="${questionForm.gender == 'm'}">男</c:if>
					<c:if test="${questionForm.gender == 'f'}">女</c:if>
				</td>
			</tr>
			<tr>
				<td>年齢</td>
				<td>
					<c:out value="${questionForm.age}" />
				</td>
			</tr>
			<tr>
				<td rowspan="0">重要視すること</td>
			</tr>
			<c:forEach var="important" items="${questionForm.important}">
				<tr>
					<td>
						<c:out value="${important}" />
					</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="登録">
	</form>
</body>
</html>