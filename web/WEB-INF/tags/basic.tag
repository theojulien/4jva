<%-- 
    Document   : basic
    Created on : 26 févr. 2014, 16:00:34
    Author     : theo
--%>

<%@tag description="Main tag of Mooc web app" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="alertError" fragment="true" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="scripts" fragment="true" %>
<%@attribute name="title" fragment="true" %>



<%-- any content can be specified here e.g.: --%>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <title><jsp:invoke fragment="title"/></title>
        <link href="<c:url value="/css/main.css"/>" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" type="text/css"/>
        <meta charset="utf-8"/>
        <jsp:invoke fragment="scripts"/>
    </head>
    <body>
        <header class="navbar navbar-inverse ">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="<c:url value="/"/>">Mooc</a>
                </div>
                <div>
                    <nav>
                        <ul class="nav navbar-nav">
                            <li><a href="<c:url value="/Courses"/>">Courses</a></li>
                                <c:choose>
                                    <c:when test="${empty sessionScope.user}">
                                    <li><a href="<c:url value="/login"/>">Login</a></li>
                                    </c:when>
                                    <c:otherwise>
                                    <li><a href="<c:url value="/auth/Graduates"/>">Graduates</a></li>
                                    <li><a href="<c:url value="/logout"/>">Logout</a></li>
                                    </c:otherwise>
                                </c:choose>
                        </ul>
                    </nav>
                </div>
            </div>
        </header>
        <section class="container" id="content">
            <c:if test="${not empty alertError}">
                <div class="alert alert-danger alert-dismissable"><jsp:invoke fragment="alertError"/></div>
            </c:if>
            <header>
                <jsp:invoke fragment="header"/>
            </header>
            <jsp:doBody/>
        </section>
    </body>
</html>