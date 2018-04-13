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
            <div style="width: 100px; height: 100px">
                <img style="width: 100%" src="${userUrl}" alt="">
            </div>
        <p>Email: ${sessionScope.user.email}</p>
        <a href="/edit">Change Profile Settings</a>
        <h2>Here are your ads:</h2>
        <c:forEach var="ad" items="${userAds}">
            <div class="col-md-6">
                <a href="/showad?id=${ad.id}"><h2>${ad.title}</h2></a>
                <p>${ad.description}</p>
                <p>Category: ${ad.category}</p>
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
