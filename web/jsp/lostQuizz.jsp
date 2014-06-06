<%-- 
    Document   : lostQuizz
    Created on : 4 mars 2014, 16:30:01
    Author     : Antoine
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<t:basic>
    <jsp:attribute name="header">
        <h1>Mooc - Quizz Lost</h1>
        <h2>Resultats : ${resultat} %</h2>
    </jsp:attribute>
    <jsp:body>
        <a href="<c:url value="/Courses"/>">Return</a>
    </jsp:body>
</t:basic>