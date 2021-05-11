<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Velkommen ${sessionScope.email} </h1>
        Du er logget ind som administrator og kan redigere følgende

        <br/>
        <p>Klik her for at se alle <a href="${pageContext.request.contextPath}/fc/allrequestspage">forespørgseler</a>

    </jsp:body>
</t:genericpage>
