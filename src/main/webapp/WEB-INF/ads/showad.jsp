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
    <div class="clear-grid">
        <h1><c:out value="${ad.title}"/></h1>
        <div class="ad-show-wrap">
            <div class="ad-show-pic-wrap">
                <div class="ad-show-pic">
                    <img src="<c:out value='${ad.url}'/>" alt="">
                </div>
            </div>
            <div class="description-wrap">
                <p><c:out value="${ad.description}"/></p>
                <p>Seller: <a href="/seller?username=<c:out value='${user.username}'/>"><c:out value="${user.username}"/></a></p>
                <p>Category: <c:out value="${category}"/></p>
            </div>
        </div>
    </div>
</container>
<jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>
