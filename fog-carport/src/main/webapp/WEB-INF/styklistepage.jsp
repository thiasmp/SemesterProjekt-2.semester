<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <table class="table table-striped">
        <thead>
        <tr>
            <td>Forespørgsels ID</td>
            <td>Materiale ID</td>
            <td>Navn</td>
            <td>Beskrivelse</td>
            <td>Længde</td>
            <td>Antal</td>
            <td>Enhed</td>
        </tr>
        </thead>

        <c:forEach var="material" items="${sessionScope.billOfMaterials}">
            <tr>
                <td>${material.forespørgsel_id}</td>
                <td>${material.materiale_id}</td>
                <td>${material.navn}</td>
                <td>${material.beskrivelse}</td>
                <td>${material.længde}</td>
                <td>${material.antal}</td>
                <td>${material.enhed}</td>
            </tr>
        </c:forEach>
        </table>


    </jsp:body>
</t:genericpage>
