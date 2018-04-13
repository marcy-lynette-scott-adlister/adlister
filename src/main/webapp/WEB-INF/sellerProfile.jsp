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
<container>
    <div class="clear-grid">
        <h1><c:out value="${seller.username}"/>'s Ads</h1>
        <c:forEach var="ad" items="${sellerAds}">

            <div class="profile-ad-wrap">
                <div class="profile-ad-picture"><img src="<c:out value='${ad.url}'/>" alt=""></div>
                <div class="profile-ad-info">
                    <a href='/showad?id=<c:out value="${ad.id}"/>'><h2><c:out value="${ad.title}"/></h2></a>
                    <p><c:out value="${ad.description}"/></p>
                    <p class="profile-ad-paragraph">Category: ${ad.category}</p>
                </div>
            </div>

        </c:forEach>

    </div>
</container>
<jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>