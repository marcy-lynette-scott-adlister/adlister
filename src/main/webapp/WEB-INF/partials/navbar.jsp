<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>


    <div class="logo"><a href="/index.jsp"><img src="/images/logo.png" alt=""></a></div>
    <div class="nav-bar">
        <nav>

<%--Desktop Nav--%>
                    <ul class="menu-bar nav-pad">
                        <li><a href="/ads">Game Lister</a></li>
                        <c:if test="${sessionScope.user != null}">
                            <li><a href="/profile">Profile</a></li>
                            <li><a href="/ads/create">Create Ad</a></li>
                            <li><a href="/logout">Logout</a></li>
                        </c:if>
                        <c:if test="${sessionScope.user == null}">
                            <li><a href="/register">Register</a></li>
                            <li><a href="/login">Login</a></li>
                        </c:if>

                    </ul>

<%--Mobile Nav--%>

    <div class="hamburger">

        <div id="menuToggle">

            <input type="checkbox" />

            <span></span>
            <span></span>
            <span></span>

            <ul id="menu">

                <li><a href="/ads">Game Lister</a></li>
                <c:if test="${sessionScope.user != null}">
                    <li><a href="/profile">Profile</a></li>
                    <li><a href="/logout">Logout</a></li>
                </c:if>
                <c:if test="${sessionScope.user == null}">
                    <li><a href="/register">Register</a></li>
                    <li><a href="/login">Login</a></li>
                </c:if>

            </ul>
        </div>
    </div>

        </nav>
    </div>
</header>
<div class="search"><form action="/ads/search" method="get">
    <input type="text" name="search" placeholder="Search All Ads">
</form></div>
