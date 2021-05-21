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
            <h2>Tegning</h2>
            <p>Her er din carport</p>

            ${requestScope.svgdrawing}

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
        </div>

        <svg  xmlns="http://www.w3.org/2000/svg"
              xmlns:xlink="http://www.w3.org/1999/xlink"
              width="927" height="905"  viewBox="0 0 900 900"
              style="fill:black">
            <rect x="40" y="0" height="600" width="5"
                  style="stroke:black"></rect>
            <rect x="815" y="0" height="600" width="5"></rect>
            <rect x="45" y="35" height="5" width="770"></rect>
            <rect x="45" y="565" height="5" width="770"></rect>
            <line x1="95" y1="35" x2="625" y2="565" style="stroke:black; stroke-dasharray:10,10"></line>
            <line x1="95" y1="565" x2="625" y2="35" style="stroke:black; stroke-dasharray:10,10"></line>

            <rect x="150" y="32" height="10" width="10" style="stroke:black"></rect>
            <rect x="460" y="32" height="10" width="10" style="stroke:black"></rect>
            <rect x="770" y="32" height="10" width="10" style="stroke:black"></rect>
            <rect x="150" y="563" height="10" width="10" style="stroke:black"></rect>
            <rect x="460" y="563" height="10" width="10" style="stroke:black"></rect>
            <rect x="770" y="563" height="10" width="10" style="stroke:black"></rect>



            <svg  xmlns="http://www.w3.org/2000/svg"

                  width="900" height="900"  viewBox="0 0 900 900"
                  style="fill:black">
                <defs>
                    <marker
                            id="beginArrow"
                            markerWidth="12"
                            markerHeight="12"
                            refX="0"
                            refY="6"
                            orient="auto">
                        <path d="M0,6 L12,0 L12,12 L0,6" style="fill: #000000;" />
                    </marker>
                    <marker
                            id="endArrow"
                            markerWidth="12"
                            markerHeight="12"
                            refX="12"
                            refY="6"
                            orient="auto">
                        <path d="M0,0 L12,6 L0,12 L0,0 " style="fill: #000000;" />
                    </marker>
                </defs>


                <line x1="18" y1="0" x2="18" y2="600" style="stroke:#000000;
        marker-start: url(#beginArrow);
marker-end: url(#endArrow)"></line>
                <line x1="30" y1="610" x2="830" y2="610" style="stroke:#000000;
    marker-start: url(#beginArrow);
    marker-end: url(#endArrow);"></line>

                <text style="text-anchor: middle" transform="translate(13,300) rotate(-90)">${sessionScope.width} cm</text>
                <text style="text-anchor: middle" transform="translate(400,630)">${sessionScope.length} cm</text>
            </svg>

        </svg>

    </jsp:body>
</t:genericpage>