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
        <c:choose>
        <c:when test="${sessionScope.user.url} == null">
            <div style="width: 100px; height: 100px">
                <img style="width: 100%" src="https://upload.wikimedia.org/wikipedia/commons/9/93/Default_profile_picture_%28male%29_on_Facebook.jpg" alt="">
            </div>
        </c:when>
        <c:otherwise>
            <div style="width: 100px; height: 100px">
                <img style="width: 100%" src="${sessionScope.user.url}" alt="">
            </div>
            </c:otherwise>
        </c:choose>
        <h2>Here are your ads:</h2>
        <c:forEach var="ad" items="${userAds}">
            <div class="col-md-6">
                <a href="/showad?id=${ad.id}"><h2>${ad.title}</h2></a>
                <p>${ad.description}</p>
                <form action="/ads/edit" method="post">
                <input type="hidden" name="Edit" value="${ad.id}">
                    <input type="submit" value="Edit">
                </form>
                <form action="/ads/delete" method="post">
                <input type="hidden" name="Delete" value="${ad.id}">
                    <input type="submit" value="Delete">
                </form>
            </div>
        </c:forEach>
    </div>

</body>
</html>
