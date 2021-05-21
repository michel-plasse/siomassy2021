<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Mes canaux"/>
<h1>Reponses à une quetsion</h1>
${erreur}
<c:forEach items="${reponses}" var="reponse">
    
    <table> 
        <h2> ${reponse.question.libelle} </h2>         
        <h3><p><i>Reponse:</i></p>
        <tr>
            <td>
                ${reponse.reponse}
            </td> 
         
            <td>
                ${reponse.personne.prenom}
                ${reponse.personne.nom}
            </td>
        
            
        </tr>      
            
             
        
    </table>
        
</c:forEach>
</body>
</html>
