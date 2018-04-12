<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp" />
<div class="container">
    <h1>Please fill in your information.</h1>
    <form action="/edit" method="post">
        <div class="form-group">
            <label>Username
                <input name="username" class="form-control" type="text" value=${sessionScope.user.username}>
            </label>
        </div>
        <div class="form-group">
            <label>Email
                <input name="email" class="form-control" type="text" value=${sessionScope.user.email}>
            </label>
        </div>
        <div class="form-group">
            <label>Profile Picture
                <input name="profilePic" class="form-control" type="text" value=${url}>
            </label>
        </div>
        <input type="submit" class="btn btn-primary btn-block">
    </form>
        <jsp:include page="/WEB-INF/partials/messages.jsp" />

    <form action="/update" method="post">
        <div class="form-group">
            <label>Old Password
                <input name="old_password" class="form-control" type="password">
            </label>
        </div>
        <div class="form-group">
            <label>New Password
                <input name="new_password" class="form-control" type="password">
            </label>
        </div>
        <div class="form-group">
            <label>Confirm New Password
                <input name="confirm_new_password" class="form-control" type="password">
            </label>
        </div>
        <input type="submit" class="btn btn-primary btn-block">
    </form>
    <form action="/delete" method="post">
        <input type="hidden" name="user_id" value="${session.Scope.user.id}">
        <input type="submit" class="btn btn-warning btn-block" value="Delete Account">
    </form>
</div>
</body>
</html>
