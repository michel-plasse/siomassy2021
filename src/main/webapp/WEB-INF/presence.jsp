<%@page import="fr.siomassy2021.model.Seance"%>
<%@page import="fr.siomassy2021.model.Personne"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Feuille de presence"/>
 
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
       <style>

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  width: 200px;
}
</style>
    </head>
    <body>
       
    <form method="POST">
        <div>
        <label>Nom: ${user.getNom()}<label/>
        <label>Prénom: <%=((Personne) session.getAttribute("user")).getPrenom()%><label/>
        <br/>    
        <label>Seance <%=((Seance) session.getAttribute("seanceDemarre")).getIdSeance()%> démarré le <%=((Seance) session.getAttribute("seanceDemarre")).getDebutA()%> <label/> 
       <br>
        <c:if  test="${sessionScope['etudiantEstPresent'] != true}">
        <input type="submit" value="présent" >
        </c:if>
        <c:if  test="${sessionScope['etudiantEstPresent'] == true}">
        Vous etes présent pour cette séance
        </c:if>
        </div>
    </form>
       
        <h1>Liste des presents</h1>     
        <table id="evaluations">
          <tr>
            <th>Nom</th>
            <th>Prenom</th>
          </tr>
           <c:forEach items="${listPresenceSeance}" var="presence">
           <tr>
       
            <td>${presence.getIdPersonne().getNom()}</td>
            <td>${presence.getIdPersonne().getPrenom()}</td>
          </tr>
           </c:forEach>
        </table>
     

 
    </body>
</html>
