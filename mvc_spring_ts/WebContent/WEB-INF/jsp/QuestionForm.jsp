<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アンケートフォーム</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<h1>アンケートフォーム</h1>
	<hr>
	<div>
		<form action="conf.html" method="post">
			<div>
				<span>
					<span>回答者名：</span>
					<span>
						<span>名字</span>
						<input type="text" maxlength="10" name="lstName" value="${questionFormModel.lstName}" />
						<span class="error">${lstNameErrMsg}</span>
						<span>名前</span>
						<input type="text" maxlength="10" name="fstName" value="${questionFormModel.fstName}" />
						<span class="error">${fstNameErrMsg}</span>
					</span>
				</span>
			</div>
			<div>
				<span>
					<span>性別：</span>
					<span>
						<label>
							<input type="radio" name="gender" value="m" <c:if test="${questionFormModel.gender == 'm'}">checked</c:if>/>
							男(m)
						</label>
						<label>
							<input type="radio" name="gender" value="f" <c:if test="${questionFormModel.gender == 'f'}">checked</c:if>/>
							女(f)
						</label>
					</span>
					<span class="error">${genderErrMsg}</span>
				</span>
			</div>
			<div>
				<span>年齢</span>
				<span>
					<input type="number" min="12" max="100" name="age" value="${questionFormModel.age}">
				</span>
				<span class="error">${ageErrMsg}</span>
			</div>
			<div>
				<span>重視すること</span>
				<span>
					<span>
						<label>
							<input type="checkbox" name="important" value="給料"
							<c:forEach var="impt" items="${questionFormModel.important}">
								<c:if test="${impt == '給料'}">checked</c:if>
							</c:forEach>>
							給料
						</label>
					</span>
					<span>
						<label>
							<input type="checkbox" name="important" value="通勤時間"
							<c:forEach var="impt" items="${questionFormModel.important}">
								<c:if test="${impt == '通勤時間'}">checked</c:if>
							</c:forEach>>
							通勤時間
						</label>
					</span>
					<span>
						<label>
							<input type="checkbox" name="important" value="仕事内容"
							<c:forEach var="impt" items="${questionFormModel.important}">
								<c:if test="${impt == '仕事内容'}">checked</c:if>
							</c:forEach>>
							仕事内容
						</label>
					</span>
					<span>
						<label>
							<input type="checkbox" name="important" value="社内雰囲気"
							<c:forEach var="impt" items="${questionFormModel.important}">
								<c:if test="${impt == '社内雰囲気'}">checked</c:if>
							</c:forEach>>
							社内雰囲気
						</label>
					</span>
					<span>
						<label>
							<input type="checkbox" name="important" value="企業理念"
							<c:forEach var="impt" items="${questionFormModel.important}">
								<c:if test="${impt == '企業理念'}">checked</c:if>
							</c:forEach>>
							企業理念
						</label>
					</span>
				</span>
				<span class="error">${importantErrMsg}</span>
				<div>
					<input type="submit" value="送信">
				</div>
			</div>
		</form>
	</div>
	<hr>
	<h3>USER_BASICテーブル登録会員名一覧</h3>
	<div>
		<c:forEach var="ub" items="${userInfo.ubList}">
			<div>
				<span>
					(
					<c:out value="${ub.userNum}" />
					)
				</span>
				<c:out value="${ub.lstName}" />
				<c:out value="${ub.fstName}" />
			</div>
		</c:forEach>
	</div>
	<h3>USER_ANSテーブル登録状況</h3>
	<div>
		<c:forEach var="ua" items="${userInfo.uaList}">
			<div>
				<span>
					(
					<c:out value="${ua.userNum}" />
					)
				</span>
				<c:out value="${ua.selectAns}" />
			</div>
		</c:forEach>
	</div>
</body>
</html>