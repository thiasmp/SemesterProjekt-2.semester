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
        <h1>Det her er dine godkendte ordre</h1>

        <table class="table table-striped">
            <thead>
            <tr>
                <td>Forespørgsels ID</td>
                <td>Længde</td>
                <td>Bredde</td>
                <td>Status</td>
            </tr>
            </thead>

            <c:forEach var="request" items="${sessionScope.requestConfirmList}">
                <tr>
                    <td>${request.id}</td>
                    <td>${request.length}</td>
                    <td>${request.width}</td>
                    <td>${request.status}</td>
                </tr>
            </c:forEach>
                <%--            <tr>--%>
                <%--                <td></td>--%>
                <%--                <td></td>--%>
                <%--                <td>Pris i alt:</td>--%>
                <%--                <td>${sessionScope.basket.totalSum()}</td>--%>
                <%--            </tr>--%>
        </table>

        <div style="margin-top: 5em;" class="container">
        <p>Se pris, stykliste og skitse af carport </p>
        <form name="forespørgsel" action="${pageContext.request.contextPath}/fc/svgpage"  method="POST">
            <div class="row mb-3">
                <div class="col-sm-4">
                    <input class="form-control" type="text" name="forespørgsel" placeholder="Forespørgsels ID">
                </div>
            </div>
            <c:if test="${requestScope.error != null }">
                <p style="color:red">
                        ${requestScope.error}
                </p>
            </c:if>

            <c:if test="${not empty param.msg}">
                <p style="font-size: large">${param.msg}</p>
            </c:if>
            <button class="btn btn-primary" type="submit">Se stykliste og tegning</button>
        </form>




    </jsp:body>
</t:genericpage>