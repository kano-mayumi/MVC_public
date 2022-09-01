<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>practice_encoding.jsp</title>
</head>
<body>practice_encoding.jsp
    <hr>

    <%-- HTTPリクエストのボディ部分に入っているパラメータを取得 --%>
    <%-- 関連：TestServlet3.java                                --%>
    <%
        request.setCharacterEncoding("UTF-8"); // 送信されてきた文字のエンコーディング
        String name = request.getParameter("name");
    %> Name =
    <%=name%>

</body>
</html>