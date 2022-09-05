<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入力ページ</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/style.css">
</head>
<body>
        <form action="register.html" method="post">
            NAME
            <input type="text" name="studentName" value="
            <c:forEach var="studentModel" items="${studentModel.personalInfo}">
            <c:out value="${studentModel.personalName}"/>
             </c:forEach> 
            " class="namePadd">
            
            <br>
            AGE
            <input type="text" name="studentAge" value="<c:out value="${studentModel.studentAge}"/>" class= "numberPadd">
            <br>
            ADDRESS
            <input type="text" name="studentAddress" value="
            <c:forEach var="studentModel" items="${studentModel.personalInfo}">
            <c:out value="${studentModel.personalAddress}"/>
            </c:forEach>
            " class="addressWidth" >
            <br>
            CLASS_NO
            <input type="text" name="studentClassNo" value="<c:out value="${studentModel.studentClassNo}"/>"class= "numberPadd">
            <br>
            <input type="submit" value="登録">


            <a href="getStudent.html">ランダム取得</a>
        </form>
</body>
</html>

