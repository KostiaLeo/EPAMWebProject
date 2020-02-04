<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
  Created by IntelliJ IDEA.
  User: Kostia
  Date: 03.02.2020
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setBundle basename="strings"/>

<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="styles.css">
<link href="https://fonts.googleapis.com/css?family=Gudea&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Source+Code+Pro:300,400,700&display=swap" rel="stylesheet">
<head>
    <title>FixAll(master)</title>
</head>
<body class="manager-page align-center ">

<form action="<%= request.getContextPath() %>/admin" method="get" >
    <input type="hidden" name="admin_action" value="logout"/>
    <input type="submit" name="logout" value="<fmt:message key="admin.logout"/>" class="btn-white" style="margin-left: 90%"/>
</form>

<c:forEach var="order" items="${sessionScope.submittedOrders}">
    <div class="order-card col-lg-7">
        <div class="row">
            <img src="${pageContext.request.contextPath}/auth/img/order.png" class="heading-order">
            <h1><fmt:message key="admin.order"/></h1>
        </div>
        <hr>

        <div class="info-about-order">
            <a><fmt:message key="home.info"/>: </a>
            <c:out value="${order.info}"/><br/>
        </div>
        <hr>

        <form action="<%= request.getContextPath() %>/admin" method="post">
            <input type="hidden" name="admin_action" value="master"/>
            <input type="hidden" name="id" value="${order.id}"/>
            <center>
                <input type="submit" value="<fmt:message key="masterPage.done"/>" class="btn"
                       style="margin-top: 2em; width: 80%"/>
            </center>
        </form>
    </div>
</c:forEach>
</body>
</html>
