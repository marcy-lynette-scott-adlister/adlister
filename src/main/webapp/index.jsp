<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Welcome to the OP Game Lister!</h1>
    </div>

    <div class="banner">
        <div class="banner-title-wrap">

        </div>
        <%--<div class="symbol-wrap">--%>
            <%--<div class="symbol"><img src="images/logo.png" alt=""></div>--%>
        <%--</div>--%>
            <div class="banner-name">Buy Games</div>
        <div class="banner-name2">Sell Games</div>
        <div class="banner-name3">Never Get Pwned Again!</div>
    </div>
    <jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>
