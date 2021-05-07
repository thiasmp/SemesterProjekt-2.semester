<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Vi har modtaget din forespørgsel med disse mål:</h1>
        <br/>
            <h2>Længde: ${requestScope.længde} cm</h2>
        <br/>
            <h2>Bredde: ${requestScope.bredde} cm</h2>
            <br/>
        <h2>Afvent vurdering</h2>
    </jsp:body>

</t:genericpage>

