 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Mes canaux"/>

        <h1>Question</h1>
        
<c:forEach items="${questions}" var="question">
    <p><strong>Question:</strong></p>
        <li>
            ${question.question.libelle}
        </li>
        <p>Question:</p>
        <li>
            ${question.reponse} 
        </li>
        ${question.personne.prenom}
        ${question.personne.nom}
        
        </c:forEach>
    </body>
</html>
