<%@taglib prefix="t" tagdir="/WEB-INF/tags/"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:basic>
    <jsp:attribute name="title">${course.title}</jsp:attribute>

    <jsp:attribute name="header">
        <h1>${course.title}</h1>
        <c:if test="${not empty user}">
            <div class="btn-group">
                <c:choose>
                    <c:when test="${not followed}">
                        <form action="<c:url value="/auth/follow"/>" method="POST">
                            <input type="hidden" name="courseId" value="${course.id}"/>
                            <button type="submit" class="btn btn-primary">Follow</button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-info" type="button" disabled="disabled">Followed</button>
                        </c:otherwise>
                </c:choose>
                        <c:choose>
                    <c:when test="${not graduated}">
                        <form action="<c:url value="/auth/quizz"/>" method="GET">
                            <input type="hidden" name="courseId" value="${course.id}"/>
                            <button type="submit" class="btn btn-success">Take a quizz</button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-info" type="button" disabled="disabled">Graduated</button>
                        </c:otherwise>
                </c:choose>
                        
                    
            </div>
        </c:if>
        <p class="lead">${course.description}</p>
    </jsp:attribute>
    <jsp:body>

        <table class="table table-striped">
            <thead>
                <tr><th>Title</th><th>Description</th><th>Duration</th></tr>
            </thead>
            <tbody>
                <c:forEach items="${course.modules}" var="module">
                    <tr>
                        <td><strong>${module.title}</strong></td><td>${module.description}</td><td>${module.minute}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </jsp:body>
</t:basic>