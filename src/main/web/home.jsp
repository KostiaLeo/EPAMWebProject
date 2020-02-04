<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<fmt:setBundle basename="strings"/>

<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Gudea&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Source+Code+Pro:300,400,700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="styles.css">

<head>
    <title>FixAll</title>
</head>
<body>

<header id="header" class="header">
    <div class="main-header">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-5 headings d-flex">
                    <img src="${pageContext.request.contextPath}/auth/img/todolist.png">
                    <h4><fmt:message key="home.allRequests"/></h4>
                </div>
                <div class="col-lg-2 headings d-flex">
                    <img src="${pageContext.request.contextPath}/auth/img/survey.png">
                    <h4><fmt:message key="home.actions"/></h4>
                </div>
            </div>
        </div>
    </div>
</header>
<div class="row">
    <div class="all-orders col-lg-5">
        <c:forEach var="order" items="${sessionScope.myOrders}">
            <div class="one-order">
                <a><fmt:message key="home.info"/>: </a>
                <c:out value="${order.info}"/><br/>
                <a><fmt:message key="home.price"/>: </a>
                <c:out value="${order.price}"/><br/>
                <a><fmt:message key="home.status"/>: </a>
                <c:out value="${order.statusString}"/><br/>
                <a><fmt:message key="home.managerComment"/>: </a>
                <c:out value="${order.comment}"/><br/><br/>

                <a><fmt:message key="home.creatingDate"/>: </a>
                <c:out value="${order.creatingDate}"/><br/>

                <a><fmt:message key="home.managingDate"/>: </a>
                <c:out value="${order.managingDate}"/><br/>

                <a><fmt:message key="home.completingDate"/>: </a>
                <c:out value="${order.completingDate}"/>
            </div>
        </c:forEach>
    </div>

    <div class="form col-lg-6">
        <form action="<%= request.getContextPath() %>/user" method="post">
            <div class="form-group">
                <label class="action-text" style="margin-top: 0.5em">
                    <fmt:message key="home.request"/>
                </label>
                <!--input поменяла на textarea с тайпом textarea -->
                <textarea class="form-control" name="info" type="textarea" rows="5" ></textarea>
            </div>
            <div class="col-auto">
                <input type="hidden" value="home" name="action"/>
                <input type="submit" id="submitBtn" value="<fmt:message key="home.submit"/>" class="btn"/>
            </div>
        </form>
        <!-- форма для фидбека юзера -->
        <br/>
        <form action="<%= request.getContextPath() %>/user" method="post">
            <div class="form-group">
                <label class="action-text" style="margin-top: 0.5em"><fmt:message key="home.feedback"/></label>
                <textarea class="form-control" name="feedback" rows="5"></textarea>
            </div>
            <div class="col-auto">
                <input type="hidden" name="action" value="feedback"/>
                <input type="submit" name="sendBtn" class="btn" value="<fmt:message key="home.send"/>"/> <%-- send --%>
            </div>
        </form>
    </div>
</div>

</body>
</html>