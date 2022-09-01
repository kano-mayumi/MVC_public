<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>practice1.jsp</title>
</head>
<body>practice1.jsp
    <hr> こんにちは。（これはHTML部分です）
    <br>

    <%-- 宣言 --%>
    <%!// このJSPクラスのインスタンス変数です。
    int year = 2018;

    // このJSPクラスのインスタンスメソッドです。
    public String getMessage() {
        return "こんにちは。（これはプログラム部分です）";
    }%>

    <%-- 以下は_jspServiceメソッド内の文となります。 --%>

    <%-- 式（出力） --%>
    <%=this.year%>年
    <br>

    <%-- スクリプトレット --%>
    <%
        // ローカル変数
        String msg = null;
        // インスタンスメソッドの呼び出し
        msg = this.getMessage();
    %>

    <%-- 式（出力） --%>
    <%=msg%><br>

    <%-- スクリプトレット --%>
    <%
        String now = null;
        now = new Date().toString();
    %>

    <%-- 式（出力） --%>
    <%=now%><br>

</body>
</html>