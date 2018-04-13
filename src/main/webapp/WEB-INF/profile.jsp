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
            <h1>Welcome, ${sessionScope.user.username}!</h1>
            <div class="profile-pic-wrap">
                <div class="profile-pic">
                    <img src="${userUrl}" alt="">
                </div>
            </div>

            <div class="profile-info">
                <p>Email: ${sessionScope.user.email}</p>
                <p><a href="/edit"><i class="far fa-edit"></i> Change Profile Settings</a></p>
            </div>

            <div class="line"></div>

            <h2 class="profile-subheader">Your Ads:</h2>


                <c:forEach var="ad" items="${userAds}">

                    <div class="profile-ad-wrap">
                        <div class="profile-ad-picture"><img src="<c:out value='${ad.url}'/>" alt=""></div>
                        <div class="profile-ad-info">
                            <a href="/showad?id=${ad.id}"><h2>${ad.title}</h2></a>
                            <p>${ad.description}</p>
                            <p class="profile-ad-paragraph">Category: ${ad.category}</p>
                            <form action="/ads/edit" method="post">
                            <input type="hidden" name="Edit" value="${ad.id}">
                                <input type="submit" value="Edit">
                            </form>
                            <form action="/ads/delete" method="post">
                            <input type="hidden" name="Delete" value="${ad.id}">
                                <input type="submit" value="Delete">
                            </form>
                        </div>

                    </div>

                </c:forEach>
        </div>


    </container>

</body>
</html>
