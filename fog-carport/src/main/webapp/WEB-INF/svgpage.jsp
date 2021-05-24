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
            <table class="table table-striped">
                <thead>
                <tr>
                    <td>Materiale ID</td>
                    <td>Beskrivelse</td>
                    <td>Længde</td>
                    <td>Antal</td>
                </tr>
                </thead>
                <c:forEach var="material" items="${sessionScope.materialList}">
                    <tr>
                        <td>${material.id}</td>
                        <td>${material.description}</td>
                        <td>${material.length}</td>
                        <td>${material.quantity}</td>
                    </tr>
                </c:forEach>
            </table>

            <table class="table table-striped">
                <thead>
                <tr>
                    <td>Total Pris</td>
                </tr>
                </thead>
                    <tr>
                        <td>${sessionScope.price}</td>
                    </tr>
            </table>
            <h2>Tegning</h2>
            <p>Her er din carport</p>
                ${requestScope.svgdrawing}
        </div>
    </jsp:body>
</t:genericpage>