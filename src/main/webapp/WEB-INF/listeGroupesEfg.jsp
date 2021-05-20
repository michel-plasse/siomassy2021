<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Mes canaux"/>
<h1>Liste des groupes de l'EFG <c:out value="${efg}"></c:out></h1>
        <c:forEach items="${listeGroupesEfg}" var="groupe">
            Groupe ${groupe.idGroupe} : 
              <c:forEach items="${groupe.membresDuGroupe}" var="membre">
                  ${membre.prenom} ${membre.nom},
            
              </c:forEach>
            <hr>
         </c:forEach>
</body>
</html>
