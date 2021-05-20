<%-- 
    Document   : listerEntrainementEtudiant
    Created on : 20 mai 2021, 09:29:13
    Author     : Karolawski
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<p:header title="liste des entrainements de l'étudiant"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>listerEntrainementEtudiant</title>
    </head>
    <body>
        <h1>Liste des entrainements étudiant</h1>     
        <table id="entrainement">
          <tr>
            <th>Intitulé</th>
            <th>Passé à</th>
            <th>Durée</th>
            <th>Est corrigée</th>
          </tr>
           <c:forEach items="${evaluations}" var="evaluation">
           <tr>
            <td>${evaluation.intitule}</td>
            <td>${evaluation.passeeA}</td>
            <td>${evaluation.duree}</td>
            <td>${evaluation.estCorrigee ? 'Oui' : 'Non'}</td>
          </tr>
           </c:forEach>
        </table>
    </body>
</html>
<p:footer/>
