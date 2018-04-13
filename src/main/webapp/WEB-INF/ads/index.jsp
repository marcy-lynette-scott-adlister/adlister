<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<container>
    <h1>Here Are all the ads!</h1>
    <div class="ad-module">
        <c:forEach var="ad" items="${ads}">
                <div class="ad-wrap">
                    <div class="ad-picture">
                        <%--<img style="width: 100%" src="${ad.url}" alt="">--%>
                            <img style="width: 100%" src="<c:out value='${ad.url}'/>" alt="">
                    </div>
                        <a href="/showad?id=${ad.id}"><h2>${ad.title}</h2></a>
                        <p class="ad-paragraph">${ad.description}</p>
                    <p class="read-more"><a href="/showad?id=${ad.id}">Read More <i class="fas fa-angle-double-right"></i></a></p>
                </div>
        </c:forEach>
    </div>
</container>

</body>
</html>
