<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>practice7.jsp</title>
</head>
<body>practice7.jsp
    <hr> ここの下で別のJSPページへフォワードします。
    <br>
    <br>

    <%-- 別のJSPページへフォワード --%>
    <jsp:forward page="practice1.jsp" />

    <br>ここの上で別のJSPページへフォワードします。

</body>
</html>