<%-- 
    Document   : index
    Created on : 26 févr. 2014, 15:04:09
    Author     : theo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basic>
    <jsp:attribute name="header">
        <h1>Mooc - Index</h1>
    </jsp:attribute>
    <jsp:body>
        <c:if test="${empty sessionScope.user}">
            <a href="<c:url value="/register"/>">Register</a>
        </c:if>
    </jsp:body>
</t:basic>
