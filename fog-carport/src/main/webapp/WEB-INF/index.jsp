<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>
    <jsp:body>
        <div>
            <h1>Velkommen til Fog's Carport</h1>
            <br/>
            <h2>Vi sælger de bedste carporte i landet</h2>

            <div style="margin-top: 3em;margin-bottom: 3em;">
                Hvis du er logget ind kan du sende en forespørgsel på en skræddersyet carport
            </div>

            <c:if test="${sessionScope.role == 'employee' }">
                 <p><a href="fc/employeepage">Gå til administrator side</a>
             </c:if>

             <c:if test="${sessionScope.role == 'customer' }">

                <p><a href="fc/customerpage">Gå til kunde side</a>
            </c:if>
        </div>
    </jsp:body>
</t:genericpage>