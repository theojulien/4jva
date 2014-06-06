<%-- 
    Document   : login
    Created on : 26 févr. 2014, 15:54:22
    Author     : theo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:basic>
    <jsp:attribute name="header">
        <h1>Mooc - Login</h1>
    </jsp:attribute>
    <jsp:body>
        <c:if test="${not empty error}">
            <div class="alert alert-danger alert-dismissable">
            Mauvais nom d'utilisateur/mot de passe.
            </div>
        </c:if>
        <form method="POST">
            <div>
                <label for="username">Username:</label>
                <input type="text" name="username" />
            </div>
            <div>
                <label for="password">Password:</label>
                <input type="password" name="password" />
            </div>
            <div>
                <input type="submit" value="Connect" />
            </div>
        </form>
    </jsp:body>
</t:basic>
