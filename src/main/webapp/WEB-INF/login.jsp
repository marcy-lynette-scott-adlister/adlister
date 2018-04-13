<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <container>
        <div class="clear-grid">
            <h1>Please Log In</h1>

            <div class="big-form-wrap">
                <form action="/login" method="POST">

                        <label for="username">Username</label>
                        <input id="username" name="username" type="text" value='<c:out value="${username}"/>'>


                        <label for="password">Password</label>
                        <input id="password" name="password" type="password">

                    <jsp:include page="/WEB-INF/partials/messages.jsp" />
                    <input class="big-form-wrap-button" type="submit" value="Log In">
                </form>
            </div>

        </div>
    </container>
</body>
</html>
