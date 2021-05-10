<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Demo Page for Employee Roles</h1>
        <h2>Hello ${sessionScope.email} </h2>
        You are now logged in as a EMPLOYEE of our wonderful site.

        <br/>
        <p>Klik her for at se alle <a href="${pageContext.request.contextPath}/fc/allrequestspage">forespørgseler</a>

    </jsp:body>
</t:genericpage>
