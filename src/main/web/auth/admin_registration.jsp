<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Kostia
  Date: 03.02.2020
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<fmt:setBundle basename="strings"/>

<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="styles.css">
<link href="https://fonts.googleapis.com/css?family=Gudea&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Source+Code+Pro:300,400,700&display=swap" rel="stylesheet">

<head>
    <title>FixAll</title>
</head>

<body class="register">

<div class="container col-lg-3 reg-form" style="margin-top: 10%">
    <center><img src="${pageContext.request.contextPath}/auth/img/user.png" class="user-img"></center>

    <form action="j_security_check" method="post" class="form-group">
        <label for="usr"><fmt:message key="registration.Login"/>:</label>
        <input type="text" class="form-control" name="j_username">
        <label for="pwd"><fmt:message key="registration.Password"/>:</label>
        <input type="password" class="form-control" name="j_password">
        <input type="submit" value="<fmt:message key="registration.Submit"/>" class="btn-reg"/>
    </form>
</div>
</body>
</html>
