
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LesEvaluations</h1>
        
        <ol>
            <c:forEach items="${LesEvaluations}" var="evaluation">
                <li>${evaluation.intitule}</li>
            </c:forEach>
        </ol>
    </body>
</html>
