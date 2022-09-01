<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error.jsp</title>
</head>
<body>error.jsp
    <hr> エラーページです。
    <br>

    <%
        out.println(exception.toString());
    %>

</body>
</html>