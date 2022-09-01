<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>practice6.jsp</title>
</head>
<body>practice6.jsp
    <hr> ここの下にインクルードするページが展開されます。
    <br>
    <br>

    <%-- 別のJSPページをインクルード --%>
    <jsp:include page="practice1.jsp" />

    <br>ここの上にインクルードするページが展開されます。

</body>
</html>