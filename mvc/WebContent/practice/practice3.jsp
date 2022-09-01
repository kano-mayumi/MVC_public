<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" errorPage="/practice/error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>practice3.jsp</title>
</head>
<body>practice3.jsp
    <hr>

    <%-- エラー（例外）を発生させる --%>
    <%
        String message = null;
        int len = message.length(); // ヌルポ発生
    %> エラーは発生しませんでした。

</body>
</html>