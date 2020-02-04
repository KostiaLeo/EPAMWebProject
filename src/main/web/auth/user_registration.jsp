<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Kostia
  Date: 03.02.2020
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ page errorPage="auth_error_page.jsp" %>
<fmt:setBundle basename="strings"/>
<fmt:setLocale value="${param.lang}" scope="session"/>

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
<!-- List group -->
<div class="row justify-content-end">
    <div class="col-2">
        <button name="en" class="languages"><a href="?lang=en">English</a></button>
        <button name="rus" class="languages"><a href="?lang=ru">Русский</a></button>
    </div>
</div>

<div class="container col-lg-3 list">
    <div class="list-group list-group-horizontal" id="myList" role="tablist">
        <a class="list-group-item list-group-item-action active" data-toggle="list" href="#in" role="tab"
           style="border-radius: inherit"><fmt:message key="registration.SignIn"/></a>
        <a class="list-group-item list-group-item-action" data-toggle="list" href="#profile" role="tab"
           style="border-radius: inherit"><fmt:message key="registration.SignUp"/></a>
    </div>
</div>

<!-- Tab panes -->
<div class="tab-content">
    <div class="tab-pane active" id="in" role="tabpanel">
        <div class="container col-lg-3 reg-form">
            <center><img src="${pageContext.request.contextPath}/auth/img/user.png" class="user-img" alt=""></center>
            <!--sign up-->
            <form action="<%= request.getContextPath() %>/user" method="post"
                  class="form-group justify-content-center">
                <label for="usr"><fmt:message key="registration.Login"/>:</label>
                <input type="text" class="form-control" name="login"/>
                <label for="pwd"><fmt:message key="registration.Password"/>:</label>
                <input type="password" class="form-control" name="password"/>
                <input type="hidden" value="signUp" name="action"/>
                <center>
                    <input type="submit" value="<fmt:message key="registration.Submit"/>" class="btn-reg"/>
                </center>
            </form>
        </div>
    </div>
    <div class="tab-pane" id="profile" role="tabpanel">
        <div class="container col-lg-3 reg-form">
            <center><img src="${pageContext.request.contextPath}/auth/img/user.png" class="user-img" alt=""></center>
            <!--sign in-->
            <form action="<%= request.getContextPath() %>/user" method="post" class="form-group">
                <label for="usr"><fmt:message key="registration.Login"/>:</label>
                <input type="text" class="form-control" name="login"/>
                <label for="pwd"><fmt:message key="registration.Password"/>:</label>
                <input type="password" class="form-control" name="password"/>
                <label for="usr"><fmt:message key="registration.ConfirmPassword"/>:</label>
                <input type="password" class="form-control" name="confirmPassword"/>
                <input type="hidden" value="signIn" name="action"/>
                <center>
                    <input type="submit" value="<fmt:message key="registration.Submit"/>" class="btn-reg"/>
                </center>
            </form>
        </div>
    </div>
</div>

</body>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</html>
