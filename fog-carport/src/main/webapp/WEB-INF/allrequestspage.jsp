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
                <td>Længde</td>
                <td>Bredde</td>
                <td>Kunde ID</td>
                <td>Email</td>
            </tr>
            </thead>

            <c:forEach var="request" items="${sessionScope.requestList}">
                <tr>
                    <td>${request.id}</td>
                    <td>${request.length}</td>
                    <td>${request.width}</td>
                    <td>${request.userID}</td>
                    <td>${request.email}</td>
                </tr>
            </c:forEach>

        </table>


        <div style="margin-top: 5em;" class="container">
            <p>Se stykliste for forespørgsels id: </p>
            <form name="forespørgsel" action="${pageContext.request.contextPath}/fc/styklistepage"  method="POST">
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
                <button class="btn btn-primary" type="submit">Se stykliste</button>
            </form>


        </div>

    </jsp:body>
</t:genericpage>
