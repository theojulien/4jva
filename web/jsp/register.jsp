<%-- 
    Document   : register
    Created on : 26 févr. 2014, 15:54:07
    Author     : theo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basic>
    <jsp:attribute name="header">
        <h1>Mooc - Register</h1>
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
                <label for="name">Name:</label>
                <input type="text" name="name" />
            </div>
            <div>
                <label for="firstname">Firstname:</label>
                <input type="text" name="firstname" />
            </div>
            <div>
                <label for="email">Email:</label>
                <input type="email" name="email" />
            </div>
            <div>
                <label for="password">Password:</label>
                <input type="password" name="password" />
            </div>
            <div>
                <label for="confirmPassword">Confirm Password:</label>
                <input type="password" name="confirmPassword" />
            </div>
            <div>
                <input type="submit" value="Register" />
            </div>
        </form>
    </jsp:body>
</t:basic>
