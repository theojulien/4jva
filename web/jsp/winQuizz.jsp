<%-- 
    Document   : winQuizz
    Created on : 4 mars 2014, 14:46:42
    Author     : Antoine
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basic>
    <jsp:attribute name="header">
        <h1>Mooc - Quizz Win</h1>
        <h2>Resultats : ${resultat} %</h2>
    </jsp:attribute>
    <jsp:body>
        <form method="POST">
            <input type="submit" value="Obtain certification">
        </form>
    </jsp:body>
</t:basic>
