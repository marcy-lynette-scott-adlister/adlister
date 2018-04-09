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
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <h2>Here are your ads:</h2>
        <c:forEach var="ad" items="${userAds}">
            <div class="col-md-6">
                <a href="/showad?id=${ad.id}"><h2>${ad.title}</h2></a>
                <p>${ad.description}</p>
            </div>
        </c:forEach>
    </div>

</body>
</html>
