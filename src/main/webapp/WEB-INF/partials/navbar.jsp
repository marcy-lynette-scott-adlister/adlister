<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${sessionScope.user != null}">
                    <li><a href="/profile">Profile</a></li>
                    <li><a href="/logout">Logout</a></li>
                </c:if>
                <c:if test="${sessionScope.user == null}">
                    <li><a href="/register">Register</a></li>
                    <li><a href="/login">Login</a></li>
                </c:if>
                    <li style="margin-top: .5em; margin-right: .5em;">
                        <form action="/ads/search" method="get" class="form-inline my-2 my-lg-0">
                        <input type="text" name="search" placeholder="Search Ads" class="form-control mr-sm-2">
                        </form>
                    </li>
            </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
