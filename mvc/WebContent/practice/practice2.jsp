<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="javax.servlet.http.Cookie" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>practice2.jsp</title>
</head>
<body>practice2.jsp
    <hr>

    <%-- Cookieを表示する --%>
    <%
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                out.println(cookie.getName() + "=" + cookie.getValue() + "<br>");
            }
        }
    %>

</body>
</html>