<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Mes canaux"/>
<h1>Reponses</h1>
<c:forEach items="${reponses}" var="reponse">
    <p><strong>Question:</strong></p>
        <li>
            ${reponse.question.libelle}
        </li>
        <p>Reponse:</p>
        <li>
            ${reponse.reponse} 
        </li>
        ${reponse.personne.prenom}
        ${reponse.personne.nom}
        
</c:forEach>
</body>
</html>
