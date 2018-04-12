<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty message}">
    <div class="alert alert-danger">
        <strong><c:out value="${message}"/></strong>
    </div>
    <%
        session.removeAttribute("message");
        request.getSession().removeAttribute("username");
        request.getSession().removeAttribute("email");
    %>
</c:if>
