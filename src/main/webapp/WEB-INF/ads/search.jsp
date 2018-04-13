<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing An Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<container>
    <div class="ad-module">
        <c:forEach var="ad" items="${searchResults}">
            <div class="ad-wrap">
                <div class="ad-picture">
                    <img src="<c:out value='${ad.url}'/>" alt="">
                </div>

                <a href="/showad?id=${ad.id}"><h2>${ad.title}</h2></a>
                <p class="ad-paragraph">${ad.description}</p>
                <p class="ad-paragraph"><c:out value="Category: ${ad.category}"/></p>
            </div>
        </c:forEach>
    </div>
</container>
<jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>
