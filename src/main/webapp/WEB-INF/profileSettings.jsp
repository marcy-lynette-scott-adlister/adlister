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

<container>
    <div class="clear-grid">
        <h1>Edit Your Profile</h1>
        <jsp:include page="/WEB-INF/partials/messages.jsp" />
        <div class="big-form-wrap">
            <form action="/edit" method="POST">

                <label for="username">Username</label>
                <input type="text" id="username" name="username" value="<c:out value="${sessionScope.user.username}" />">


                <label for="email">Email</label>
                <input name="email" id="email" type="text" value="<c:out value='${sessionScope.user.email}'/>">

                <label for="profileImage">Profile Image</label>
                <input name="profilePic" type="text" id="profileImage" value=${url} >

                <input class="big-form-wrap-button" type="submit" value="Update">

            </form>
        </div>
        <div class="big-form-wrap">
            <form action="/update" method="POST">

                <label for="oldPass">Old Password</label>
                <input type="password" id="oldPass" name="old_password">


                <label for="newPass">Old Password</label>
                <input type="password" id="newPass" name="new_password">

                <label for="confirmPass">Confirm New Password</label>
                <input name="confirm_new_password" type="password" id="confirmPass">

                <input class="big-form-wrap-button" type="submit" value="Update">

            </form>
        </div>
        <div class="big-form-wrap">
            <form action="/delete" method="POST">

                <input type="hidden" name="user_id" value="${session.Scope.user.id}">
                <input type="submit" class="big-form-wrap-button" value="Delete Account">

            </form>
        </div>

    </div>
</container>
</body>
</html>
