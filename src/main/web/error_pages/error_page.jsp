<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Kostia
  Date: 22.01.2020
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@page isErrorPage="true" %>
<%--<fmt:setLocale value="${param.lang}"/>--%>
<fmt:setBundle basename="strings"/>

<html>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="styles.css">
<link href="https://fonts.googleapis.com/css?family=Gudea&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Source+Code+Pro:300,400,700&display=swap" rel="stylesheet">
<fmt:setBundle basename="strings"/>
<head>
    <title>FixAll(error)</title>
</head>
<body class="register">
<center>
    <img src="${pageContext.request.contextPath}/auth/img/problem.png" style="width: 20em; height: 20em; margin-top: 15%">
    <h1 style="font-size: 4em; color: #fff"><fmt:message key="errorPage.defaultError"/></h1>
</center>
</body>
</html>
