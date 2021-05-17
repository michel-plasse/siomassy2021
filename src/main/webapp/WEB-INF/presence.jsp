<%@page import="fr.siomassy2021.model.Seance"%>
<%@page import="fr.siomassy2021.model.Personne"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Feuille de presence"/>
 
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
       <link rel="stylesheet" type="text/css" href="feuillePresence.css"/>
    </head>
    <body>
       
    <form method="POST">
         <fieldset>
        
        <label>Nom: <%= ((Personne) session.getAttribute("user")).getNom()%><label/>
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

  </fieldset>
    </form>
     

 
    </body>
</html>
