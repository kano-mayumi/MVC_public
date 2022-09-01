<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>practice5.jsp</title>
</head>
<body>practice5.jsp
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

    <%-- JSPのコメントです。 --%>
    <!-- HTMLのコメントです。 -->

</body>
</html>