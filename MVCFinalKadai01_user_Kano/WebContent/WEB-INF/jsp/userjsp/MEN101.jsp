<!--
ユーザメニュー画面
ユーザーが各機能を利用するための窓口としてのページ
2022年9月9日
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザメニュー</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/user.css">
</head>
<body>
    <div class="site-menu">
        <ul>
            <li><a href="newMemberRegistration.html">新規会員登録</a></li>
            <li><a href="memberInfomationEditAndDelete.html">会員情報変更・削除</a></li>
            <li><a href="productSearch.html">商品検索</a></li>
            <li><a href="basket.html">お買い物かご</a></li>
        </ul>
    </div>
        <ul>
            <li>会員情報の登録を行います。</li>
            <li>会員情報の変更、削除を行います。</li>
            <li>購入する商品の検索を行います。</li>
            <li>商品の注文を行います。</li>
        </ul>
        <input type="submit" onclick="location.href='fromUserMenu_login.html'" value="ログイン">
</body>
</html>