<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit Your Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
        <div class="col-md-6">

            <form action="/profile" method="post">
                <input type="text" name="Edit" value="<c:out value="${ad.title}" />">
                <textarea name="Description" value="Description" id="" cols="30" rows="10">${ad.description}</textarea>
                <input type="submit" value="Update">
                <input type="hidden" value="${ad.id}" name="Update">
            </form>



        </div>
</div>

</body>
</html>
