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
        Du er nu logget ind på Fog's carport side
        <br/>
        <br/>
        <p>Klik her for at lav en <a href="${pageContext.request.contextPath}/fc/newrequest">ny forespørgsel</a>
        <p>Klik her for at se  <a href="${pageContext.request.contextPath}/fc/viewconfirmed">godkendte ordre</a>
    </jsp:body>
</t:genericpage>