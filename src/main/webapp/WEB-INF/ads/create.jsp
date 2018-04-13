<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <container>
        <h1>Create a new Ad</h1>

        <div class="clear-grid">

            <div class="big-form-wrap">
                <form action="/ads/create" method="post">
                    <div class="form-group">
                        <label for="title">Title</label>
                        <input id="title" name="title" type="text" value='<c:out value="${title}"/>'>
                    </div>
                    <div class="form-group">
                        <label for="description">Description</label>
                        <textarea id="description" name="description" type="text"><c:out value="${description}"/></textarea>
                    </div>
                    <div class="form-group">
                        <label for="category">Category</label>
                        <input id="category" name="category" type="text" value='<c:out value="${category}"/>'>
                    </div>
                    <div class="form-group">
                        <label for="url">Image</label>
                        <input id="url" name="url" type="text" value='<c:out value="${url}"/>'>
                    </div>
                    <jsp:include page="/WEB-INF/partials/messages.jsp" />
                    <input type="submit" class="big-form-wrap-button">
                </form>
            </div>

        </div>

    </container>
<jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>
