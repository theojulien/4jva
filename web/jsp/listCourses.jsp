<%-- 
    Document   : listCourses
    Created on : 27 févr. 2014, 23:17:59
    Author     : Spidyx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:basic>
    <jsp:attribute name="header">
        <h1>Liste des cours</h1>
    </jsp:attribute>
    <jsp:body>
        <table class="table table-striped table-hover">
            <thead>
                <tr><th>Titre</th><th>Description</th><th>Durée</th></tr>
            </thead>
            <tbody>
                <c:forEach items="${courses}" var="course">
                    <c:url value="/Course?id=${course.id}" var="courseUrl"/>
                    <tr onclick="window.location.href='${courseUrl}';" class="link">
                        <td><a href="${courseUrl}"><strong>${course.title}</strong></a></td>
                        <td>${course.description}</td>
                        <td>${course.getTotalDuration()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </jsp:body>
</t:basic>