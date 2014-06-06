<%-- 
    Document   : listGraduates
    Created on : 9 mars 2014, 20:28:07
    Author     : Spidyx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:basic>
    <jsp:attribute name="header">
        <h1>Your Graduates</h1>
    </jsp:attribute>
    <jsp:body>
        <c:choose>
            <c:when test="${not empty graduates}">
        <table class="table table-striped table-hover">
            <thead>
                <tr><th>Title</th><th>Date</th></tr>
            </thead>
            <tbody>
                
                <c:forEach items="${graduates}" var="graduate">
                    <tr>
                        <td>${graduate.course.description}</td>
                        <td>${graduate.date}</td>
                    </tr>
                    <!--
                    <c:url value="/Course?id=${course.id}" var="courseUrl"/>
                    <tr onclick="window.location.href='${courseUrl}';" class="link">
                        <td><a href="${courseUrl}"><strong>${course.title}</strong></a></td>
                        
                    -->
                    </tr>
                </c:forEach>
            </tbody>
        </table>
            </c:when>
            <c:otherwise>
                <p>You don't have any graduates.</p>
            </c:otherwise>
        </c:choose>
    </jsp:body>
</t:basic>
