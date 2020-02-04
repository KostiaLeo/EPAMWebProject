<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Kostia
  Date: 03.02.2020
  Time: 19:02
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
<div class="container">
    <div class="row">

        <div class="col">
            <form action="<%= request.getContextPath()%>/admin" method="get">
                <input type="hidden" name="admin_action" value="manager"/>
                <input type="submit" value="<fmt:message key="admin.signUpManager"/>" style="width: 60%; border-radius: 25px;
	border-width: 0.1em;
	background-color: #2d3842;
    color: #fff;padding: 1em 1em 1em 1em; font-size: 1.5em; margin-left:20%; border-style: solid;"/>
            </form>
        </div>
        <div class="col">
            <form action="<%= request.getContextPath()%>/admin" method="get">
                <input type="hidden" name="admin_action" value="master"/>
                <input type="submit" value="<fmt:message key="admin.signUpMaster"/>" style="width: 60%; border-radius: 25px;
	border-width: 0.1em;
	background-color: #2d3842;
    color: #fff;padding: 1em 1em 1em 1em; font-size: 1.5em; margin-left:20%; border-style: solid"/>
            </form>
        </div>
    </div>
</body>
</html>
