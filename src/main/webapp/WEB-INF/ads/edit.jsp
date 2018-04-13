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

<container>
    <div class="clear-grid">
        <h1>Edit Ad</h1>

        <div class="big-form-wrap">
            <form action="/profile" method="POST">

                <label for="title">Title</label>
                <input type="text" id="title" name="Edit" value="<c:out value="${ad.title}" />">


                <label for="description">Description</label>
                <textarea name="Description" value="Description" id="description" cols="30" rows="10"><c:out value="${ad.description}"/></textarea>

                <label for="adImage">Ad Image</label>
                <input name="adPic" type="text" id="adImage" value=${url} >

                <label for="category">Category</label>
                <input type="text" id="category" name="category" value="<c:out value="${category}" />">

                <jsp:include page="/WEB-INF/partials/messages.jsp" />

                <input class="big-form-wrap-button" type="submit" value="Update">
                <input type="hidden" value="${ad.id}" name="Update">

            </form>
        </div>

    </div>
</container>
<jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>
