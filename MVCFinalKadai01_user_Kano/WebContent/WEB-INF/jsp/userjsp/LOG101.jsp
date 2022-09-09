<!--
ユーザログイン画面
ユーザーがログインを行うページ
2022年9月9日
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>ユーザログイン</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/user.css">

</head>
<body>

    <%@ include file="/WEB-INF/jsp/common/Header.jsp"%>
    <div class="text-align">新規会員の方はこちら</div>
    <form>
        会員
        <input type="text" name="">
        <br>
        パスワード
        <input type="text" name="">

        <a href=""></a>
    </form>
</body>
</html>
