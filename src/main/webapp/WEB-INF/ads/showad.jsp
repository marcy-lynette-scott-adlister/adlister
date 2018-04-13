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

<div class="container">
    <h1><c:out value="${ad.title}"/></h1>
    <div class="ad-picture">
        <%--<img style="width: 100%" src="${ad.url}" alt="">--%>
        <img style="width: 100%" src="<c:out value='${ad.url}'/>" alt="">
    </div>
    <p><c:out value="${ad.description}"/></p>
    <p>Seller: <a href="/seller?username=<c:out value='${user.username}'/>"><c:out value="${user.username}"/></a></p>
    <p>Category: <c:out value="${category}"/></p>
</div>
<jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>
