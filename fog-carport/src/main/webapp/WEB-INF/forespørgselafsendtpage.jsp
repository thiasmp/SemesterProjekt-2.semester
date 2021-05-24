<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h2>Vi har modtaget din forespørgsel med disse mål:</h2>
        <br/>
            <h3>Længde: ${requestScope.længde} cm</h3>
        <br/>
            <h3>Bredde: ${requestScope.bredde} cm</h3>
            <br/>
        <h3>Din forespørgsel vil blive behandlet hurtigst muligt - du vil blive kontaktet ved opdateringer</h3>
    </jsp:body>
</t:genericpage>