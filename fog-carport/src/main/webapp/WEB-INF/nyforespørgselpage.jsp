<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Velkommen til forespørgsel siden</h1>
        <p>Hvis du vil lave en skræddersyet carport bedes du udfylde felterne neden for.</p>

        <div style="margin-top: 5em;" class="container">
            <form name="længde" action="${pageContext.request.contextPath}/fc/requestpage"  method="POST">
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="længde">Længde</label>
                    <div class="col-sm-4">
                        <input class="form-control" type="text" name="længde" placeholder="længde i cm">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="bredde">Bredde</label>
                    <div class="col-sm-4">
                        <input class="form-control" type="bredde" name="bredde" placeholder="bredde i cm">
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

                <c:if test="${requestScope.booleanTest = true}">
                    <p style="color:red">${requestScope.newError}</p>
                </c:if>
                <button class="btn btn-primary" type="submit">Send forespørgsel</button>
            </form>


        </div>

    </jsp:body>

</t:genericpage>

