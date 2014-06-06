<%-- 
    Document   : quizz
    Created on : 6 mars 2014, 00:46:56
    Author     : Antoine
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:basic>
    <jsp:attribute name="header">
        <h1>MOOC - Quizz</h1>
    </jsp:attribute>
    <jsp:body>
        <form method="POST" action="<c:url value="/auth/quizz"/>">
            <input type="hidden" name="courseId" value="${course.id}"/>
            <table class="table table-striped">
                <thead>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${not empty questions}">
                        <table>
                            <thead>
                            <th>Question</th>
                            <th> </th>
                            <th>Réponse</th>
                            </thead>
                            <tr>
                                <c:forEach items="${questions}" var="question">
                                <tr>
                                    <td>${question.subject}</td>
                                    <c:forEach items="${question.statements}" var="statement">
                                        <td><input type="checkbox" id ="${statement.id}" name="${statement.id}" ><c:out value="${statement.text}" /></td>
                                        </c:forEach>
                                </tr>
                            </c:forEach>
                            </tr>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <p>No Quizz in Database.</p>
                    </c:otherwise>
                </c:choose>
                <input type="submit" value="Envoyez">
                </form>
                </tbody>
            </table>
        </jsp:body>
    </t:basic>

