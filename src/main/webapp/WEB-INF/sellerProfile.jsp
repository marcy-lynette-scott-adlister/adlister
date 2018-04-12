<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1><c:out value="${seller.username}"/>'s Games</h1>
    <h2>Looking to sell: </h2>
    <c:forEach var="ad" items="${sellerAds}">
        <div class="col-md-6">
            <a href='/showad?id=<c:out value="${ad.id}"/>'><h2><c:out value="${ad.title}"/></h2></a>
            <p><c:out value="${ad.description}"/></p>
        </div>
    </c:forEach>
</div>

</body>
</html>